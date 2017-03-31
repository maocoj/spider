package com.gongzuochong.service;

import com.gongzuochong.dao.IdentEntRepository;
import com.gongzuochong.dao.JobRepository;
import com.gongzuochong.entity.IdentEntEntity;
import com.gongzuochong.entity.JobEntity;
import com.gongzuochong.entity.UserEntity;
import com.gongzuochong.entity.dto.TransJob;
import com.gongzuochong.enums.ThirdUserType;
import com.gongzuochong.util.ConstUtil;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by marco on 2017/3/30.
 * 数据->DB
 */
@Service
public class SpiderJobServiceImpl implements ISpiderJobService{
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private IdentEntRepository identEntRepository;
    @Autowired
    private UserService userService;

    @Override
    public void handleData(TransJob transJob){
        ThirdUserType thirdType = transJob.getThirdUserType();
        JobEntity job = transJob.getJobEntity();
        IdentEntEntity ent = transJob.getIdentEntEntity();

        Objects.requireNonNull(thirdType);
        Objects.requireNonNull(job);

        Long uid = null;
        String mobile = ConstUtil.checkMobile(job.getPhone()) ? job.getPhone() : null;

        //第一步：查询该名称的所有企业，如果有同来源的企业uid 就用此uid
        if (ent != null && !Strings.isNullOrEmpty(ent.getEntName())){
            List<IdentEntEntity> entList = identEntRepository.findByEntName(ent.getEntName());
            Optional<IdentEntEntity> first = entList.stream()
                    .filter(e -> {
                        UserEntity one = userService.findOne(e.getUid());
                        return one != null && one.getThirdUserType() != null && one.getThirdUserType() == thirdType.getValue();
                    }).findFirst();

            if (first.isPresent()){
                uid = first.get().getUid();
            }
        }

        //第二步：如果没有uid且有手机号 查找此手机号同来源的uid
        if (uid == null && !Strings.isNullOrEmpty(mobile)){
            //有手机号的直接数据库匹配相同账号并且同类的作为uid
            UserEntity existUser = userService.findByMobile(mobile);
            if (existUser != null){
                if (existUser.getThirdUserType() != null && thirdType.getValue() == existUser.getThirdUserType()){
                    uid = existUser.getId();
                }
            } else {
                uid = userService.createUserWithMobile(thirdType, mobile);
            }
        }

        if (uid == null) {
            uid = userService.createUserWithRandomMobile(thirdType);
        }

        Objects.requireNonNull(uid);
        if (uid == 0){
            throw new RuntimeException("uid 不能为0 ");
        }
        job.setUid(uid);
        jobRepository.save(job);

        if (ent != null){
            ent.setUid(uid);
            identEntRepository.save(ent);
        }

    }
}
