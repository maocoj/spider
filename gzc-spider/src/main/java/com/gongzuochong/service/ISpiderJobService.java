package com.gongzuochong.service;


import com.gongzuochong.entity.IdentEntEntity;
import com.gongzuochong.entity.JobEntity;
import com.gongzuochong.entity.dto.TransJob;
import com.gongzuochong.enums.ThirdUserType;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;


/**
 * Created by marco on 2017/3/30.
 */

public interface ISpiderJobService {
    BlockingQueue<TransJob> QUEUE = new LinkedBlockingDeque<>(10000);
    BlockingQueue<TransJob> ERR_QUEUE = new LinkedBlockingDeque<>(10000);

    ExecutorService service = Executors.newFixedThreadPool(1);

    /**
     * 处理业务数据
     *
     * @param transJob
     */
    void handleData(TransJob transJob);

    /**
     * 添加数据到任务队列
     *
     */
    default void addToTask(TransJob transJob) {
        try {
            QUEUE.put(transJob);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行任务
     */
    @PostConstruct
    default void execute() {
        while (true) {
            try {
                TransJob transJob = QUEUE.take();
                handleData(transJob);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (RuntimeException e) {

            }
        }
    }
}
