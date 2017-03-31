package com.gongzuochong.service;

import com.gongzuochong.config.GanjiDic;
import com.gongzuochong.entity.IdentEntEntity;
import com.gongzuochong.entity.dto.TransJob;
import com.gongzuochong.entity.mongo.GanjiQzJob;
import com.gongzuochong.enums.Published;
import com.gongzuochong.enums.ThirdUserType;
import com.gongzuochong.service.Convert.ISpiderConvert;
import com.google.common.base.Strings;
import com.mongodb.WriteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.util.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

/**
 * Created by marco on 2017/3/31.
 */
public class GanjiQzRawDataServiceImpl extends RawDataServiceAbstract<GanjiQzJob> {
    private final static Logger logger = LoggerFactory.getLogger(GanjiService.class);

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ISpiderConvert convert;

    @Override
    public boolean updatePublished(String id, Published published) {
        WriteResult writeResult = mongoTemplate
                .updateFirst(query(where("id").is(id))
                        , update("published", published.getCode()), GanjiQzJob.class);
        return writeResult.wasAcknowledged();
    }

    @Override
    public  boolean canPublished(GanjiQzJob ganjiQzJob) {
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

    @Override
    public String getMaxId(List<GanjiQzJob> t) {
        Optional<String> max = t.stream().map(GanjiQzJob::getId)
                .max(Comparator.naturalOrder());
        return max.orElse("0");
    }


    @Override
    public TransJob convertRawData(GanjiQzJob ganjiQzJob) {
        return convert.convert2TransJob(ThirdUserType.Ganji, ganjiQzJob);
    }

    @Override
    public List<GanjiQzJob> findUnPublished(Object startIndex, int limit) {
        if (StringUtils.isEmpty(((String)startIndex).trim())){
            startIndex = "0";
        }
        return mongoTemplate.find(query(where("id")
                .gt(startIndex)
                .and("published")
                .is(Published.None.getCode()))
                .with(new Sort(Sort.Direction.ASC,"id"))
                .limit(limit), GanjiQzJob.class);
    }
}
