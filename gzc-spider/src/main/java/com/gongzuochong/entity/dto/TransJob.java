package com.gongzuochong.entity.dto;

import com.gongzuochong.entity.IdentEntEntity;
import com.gongzuochong.entity.JobEntity;
import com.gongzuochong.enums.ThirdUserType;

/**
 * Created by marco on 2017/3/30.
 */
public class TransJob {
    private ThirdUserType thirdUserType;
    private JobEntity jobEntity;
    private IdentEntEntity identEntEntity;

    public TransJob(ThirdUserType thirdUserType, JobEntity jobEntity, IdentEntEntity identEntEntity) {
        this.thirdUserType = thirdUserType;
        this.jobEntity = jobEntity;
        this.identEntEntity = identEntEntity;
    }

    public TransJob() {
    }

    public JobEntity getJobEntity() {
        return jobEntity;
    }

    public void setJobEntity(JobEntity jobEntity) {
        this.jobEntity = jobEntity;
    }

    public IdentEntEntity getIdentEntEntity() {
        return identEntEntity;
    }

    public void setIdentEntEntity(IdentEntEntity identEntEntity) {
        this.identEntEntity = identEntEntity;
    }

    public ThirdUserType getThirdUserType() {
        return thirdUserType;
    }

    public void setThirdUserType(ThirdUserType thirdUserType) {
        this.thirdUserType = thirdUserType;
    }
}
