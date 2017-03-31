package com.gongzuochong.service;

import com.gongzuochong.entity.dto.TransJob;
import com.gongzuochong.enums.Published;

import java.util.List;

/**
 * Created by marco on 2017/3/30.
 */
public interface IRawDataService<T> {


    /**
     * 启动原始数据处理任务
     */
    void startHandleRawData();


    /**
     * 获取未发布的数据
     *
     * @param startIndex  起始位置
     * @param limit  限制
     * @return  原始对象列表
     */
    List<T> findUnPublished(Object startIndex, int limit);

    /**
     * 更新原始对象发布状态
     *
     * @param id  原始对象id
     * @param published  发布状态
     * @return  是否更新
     */
    boolean updatePublished(String id, Published published);


    /**
     * 检验然是数据是否可以发布
     *
     * @param t
     * @return
     */
    boolean canPublished(T t);

    String getMaxId(List<T> t);

    TransJob convertRawData(T t);

    void push2ErrQueue(T t);

    void push2FailQueue(T t);
}
