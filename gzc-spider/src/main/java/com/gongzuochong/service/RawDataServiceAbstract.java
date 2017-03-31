package com.gongzuochong.service;

import com.gongzuochong.entity.dto.TransJob;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by marco on 2017/3/31.
 */
public abstract class RawDataServiceAbstract<T> implements IRawDataService<T> {

    protected LinkedBlockingQueue<T> ERR_QUEUE = new LinkedBlockingQueue<>(1000);
    protected LinkedBlockingQueue<T> FAIL_QUEUE = new LinkedBlockingQueue<>(1000);
    @Autowired
    protected ISpiderJobService spiderJobService;

    private final static Integer QUERY_DEF_SIZE = 100;

    @Override
    public void startHandleRawData() {
        Object id = "0";
        while (true) {
            List<T> unPublished = findUnPublished(id, QUERY_DEF_SIZE);
            if (unPublished == null || unPublished.size() == 0) {
                break;
            }

            id = getMaxId(unPublished);

            for (T t : unPublished) {
                if (canPublished(t)) {
                    try {
                        TransJob transJob = convertRawData(t);
                        spiderJobService.addToTask(transJob);
                    } catch (Exception e) {
                        push2ErrQueue(t);
                    }
                } else {
                    push2FailQueue(t);
                }
            }
        }
    }

    @Override
    public void push2ErrQueue(T t) {
        try {
            ERR_QUEUE.put(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void push2FailQueue(T t) {
        try {
            FAIL_QUEUE.put(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
