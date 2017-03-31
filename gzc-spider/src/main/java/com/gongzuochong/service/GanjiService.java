package com.gongzuochong.service;

import com.gongzuochong.config.GanjiDic;
import com.gongzuochong.dao.JobRepository;
import com.gongzuochong.entity.IdentEntEntity;
import com.gongzuochong.entity.JobEntity;
import com.gongzuochong.entity.UserEntity;
import com.gongzuochong.entity.mongo.GanjiQzJob;
import com.gongzuochong.enums.*;
import com.gongzuochong.service.Convert.GanjiConvertImpl;
import com.gongzuochong.util.ConstUtil;
import com.google.common.base.Strings;
import com.mongodb.WriteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Update.update;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.*;

/**
 * Created by marco on 2017/3/27.
 */
@Service
public class GanjiService {

    private final static Logger logger = LoggerFactory.getLogger(GanjiService.class);

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private GanjiConvertImpl ganjiConvert;
    @Autowired
    private UserService userService;
    @Autowired
    private IdentEntService identEntService;

    private final static Integer QUERY_SIZE = 100;

    private HashMap<String, Long> entMap = new HashMap<>(1000);

    public void doStartQz(){
        logger.info("========================开始处理数据============================");
        StopWatch stopWatch = new StopWatch("赶集数据处理");
        stopWatch.start();
        String startIndex = "0";
        int sucCount = 0;
        int failCount = 0;
        while(true){
            List<GanjiQzJob> ganjiModels = findUnPublished(startIndex, QUERY_SIZE);

            if (ganjiModels == null || ganjiModels.size() == 0){
                break;
            }

            Optional<String> max = ganjiModels.stream()
                    .map(GanjiQzJob::getId)
                    .max(Comparator.naturalOrder());

            if (max.isPresent()){
                startIndex = max.get();
            }

            //转换数据，处理数据
            Set<String> failSet = new HashSet<>();

            for (GanjiQzJob gjModel : ganjiModels){
                if (canPublish(gjModel)){
                    try{
                        handleData(gjModel);
                        sucCount++;
                    }catch (Exception e){
                        logger.error("处理出现异常,id:{}", gjModel.getId());
                        e.printStackTrace();
                        failSet.add(gjModel.getId());
                        updatePublishedById(gjModel.getId(), Published.err);
                        failCount++;
                    }
                } else {
                    logger.warn("数据不符合处理要求:{}", gjModel.getId());
                    failSet.add(gjModel.getId());
                    updatePublishedById(gjModel.getId(), Published.No);
                    failCount++;
                }
                logger.info("成功{}条，失败{}条",sucCount, failCount);

            }
            logger.info("本批次处理{}条数据，成功{}条，失败{}条", ganjiModels.size(), ganjiModels.size() - failSet.size(), failSet.size());
        }
        stopWatch.stop();
        logger.info("========================处理完毕============================");
        stopWatch.prettyPrint();
        logger.info("数据处理完毕，共处理{}条数据，成功{}条，失败{}条", sucCount+failCount ,sucCount, failCount);
    }

    @Transactional
    private void handleData(GanjiQzJob ganjiQzJob){
        GanjiQzJob.CommentOwnerInfo commentOwnerInfo = ganjiQzJob.getCommentOwnerInfo();
        Objects.requireNonNull(commentOwnerInfo);

        if (Strings.isNullOrEmpty(commentOwnerInfo.getPhone())){
            throw new RuntimeException("手机号码为空");
        }

        Long uid = null;

        String mobile = ConstUtil.checkMobile(commentOwnerInfo.getPhone()) ? commentOwnerInfo.getPhone() : null ;

        uid = entMap.get(commentOwnerInfo.getCompanyName());

        //第一步：查询该名称的所有企业，如果有同来源的企业uid 就用此uid
        if (uid == null){
            List<IdentEntEntity> entList = identEntService.findByEntName(commentOwnerInfo.getCompanyName());
            Optional<IdentEntEntity> first = entList.stream()
                    .filter(ent -> {
                        //logger.info(ent.toString());
                        UserEntity one = userService.findOne(ent.getUid());
                        //logger.info(one.toString());
                        return one != null && one.getThirdUserType() != null && one.getThirdUserType() == ThirdUserType.Ganji.getValue();

                    }).findFirst();

            if (first.isPresent()){
                uid = first.get().getUid();
            }
        }

        //第二步：如果没有且有手机号 查找此手机号同来源的uid
        if (uid == null && !Strings.isNullOrEmpty(mobile)){
            //有手机号的直接数据库匹配相同账号并且同类的作为uid
            UserEntity existUser = userService.findByMobile(mobile);
            if (existUser != null){
                if (existUser.getThirdUserType() != null && ThirdUserType.Ganji.getValue() == existUser.getThirdUserType()){
                    uid = existUser.getId();
                }
            } else {
                uid = userService.createUserWithMobile(ThirdUserType.Ganji, mobile);
                IdentEntEntity ent = ganjiConvert.convertEnt(uid, commentOwnerInfo);
                identEntService.save(ent);
            }
        }

        if (uid == null) {
            uid = userService.createUserWithMobile(ThirdUserType.Ganji, null);
            IdentEntEntity ent = ganjiConvert.convertEnt(uid, commentOwnerInfo);
            identEntService.save(ent);
        }

        entMap.put(commentOwnerInfo.getCompanyName(), uid);

        Objects.requireNonNull(uid);
        if (uid == 0){
            throw new RuntimeException("uid 不能为0 ");
        }

        JobEntity qzJob = ganjiConvert.convertJob(uid, ganjiQzJob);
        jobRepository.save(qzJob);
        updatePublishedById(ganjiQzJob.getId(), Published.Yes);
    }

    public int updatePublishedByIds(List<String> ids, Published published){
        WriteResult writeResult = mongoTemplate
                .updateFirst(query(where("id").in(ids))
                        , update("published", published.getCode()), GanjiQzJob.class);
        return writeResult.getN();
    }

    public int updatePublishedById(String id, Published published){
        WriteResult writeResult = mongoTemplate
                .updateFirst(query(where("id").is(id))
                        , update("published", published.getCode()), GanjiQzJob.class);
        return writeResult.getN();
    }

    public List<GanjiQzJob> findUnPublished(String startIndex, int limit){
        if (StringUtils.isEmpty(startIndex.trim())){
            startIndex = "0";
        }
        return mongoTemplate.find(query(where("id")
                .gt(startIndex)
                .and("published")
                .is(Published.None.getCode()))
                .with(new Sort(Sort.Direction.ASC,"id"))
                .limit(limit), GanjiQzJob.class);
    }

    private boolean canPublish(GanjiQzJob ganjiQzJob){
        boolean canPub = true;
        if (ganjiQzJob.getCommentOwnerInfo() == null){
            canPub = false;
        } else {
            if (Strings.isNullOrEmpty(ganjiQzJob.getCommentOwnerInfo().getPhone())){
                canPub = false;
            }
        }

        if (Strings.isNullOrEmpty(ganjiQzJob.getDomain())){
            canPub = false;
        } else {
            Integer city = GanjiDic.cityMap.get(ganjiQzJob.getDomain());
            if( city == null){
                canPub = false;
            }
        }

        if (Strings.isNullOrEmpty(ganjiQzJob.getTagName())){
            canPub = false;
        } else {
            Integer category = GanjiDic.categoryMap.get(ganjiQzJob.getTagName().trim());
            if (category == null){
                canPub = false;
            }
        }
        return canPub;
    }

}
