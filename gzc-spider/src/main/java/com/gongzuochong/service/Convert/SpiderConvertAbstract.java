package com.gongzuochong.service.Convert;

import com.gongzuochong.entity.IdentEntEntity;
import com.gongzuochong.entity.JobEntity;
import com.gongzuochong.entity.dto.TransJob;
import com.gongzuochong.enums.ThirdUserType;
import com.gongzuochong.service.DistrictService;
import com.gongzuochong.service.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by marco on 2017/3/30.
 */
public abstract class SpiderConvertAbstract<T> implements ISpiderConvert<T> {
    @Autowired
    protected JobCategoryService jobCategoryService;
    @Autowired
    protected DistrictService districtService;

    @Override
    public TransJob convert2TransJob(ThirdUserType ty, T source) {
        IdentEntEntity identEntEntity = convertEnt(ty, source);
        JobEntity jobEntity = convertJob(ty, source);
        return new TransJob(ty, jobEntity, identEntEntity);
    }
}
