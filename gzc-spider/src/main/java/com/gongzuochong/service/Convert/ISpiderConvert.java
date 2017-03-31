package com.gongzuochong.service.Convert;

import com.gongzuochong.entity.IdentEntEntity;
import com.gongzuochong.entity.JobEntity;
import com.gongzuochong.entity.dto.TransJob;
import com.gongzuochong.enums.ThirdUserType;

/**
 * Created by marco on 2017/3/30.
 * 爬虫信息处理转换
 */
public interface ISpiderConvert<T> {
    /**
     * 转换成一个不带uid的JobEntity
     * @param sourceJob
     * @return
     */
    JobEntity convertJob(ThirdUserType ty, T sourceJob);

    /**
     * 转换成一个不带uid的EntEntity
     * @param sourceEnt
     * @return
     */
    IdentEntEntity convertEnt(ThirdUserType ty, T sourceEnt);


    TransJob convert2TransJob(ThirdUserType ty, T source);
}
