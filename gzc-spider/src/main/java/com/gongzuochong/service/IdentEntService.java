package com.gongzuochong.service;

import com.gongzuochong.dao.IdentEntRepository;
import com.gongzuochong.entity.IdentEntEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by marco on 2017/3/28.
 */
@Service
public class IdentEntService {

    /**初始化一个企业信息缓存，当缓存命中时直接去用户id，不用查找数据库*/
    Map<String, Long> entUserMap = new ConcurrentHashMap<>(10000);

    @Autowired
    private IdentEntRepository identEntRepository;

    public List<IdentEntEntity> findByEntName(String entName) {
        return identEntRepository.findByEntName(entName);
    }

    public IdentEntEntity saveIfNotExist(IdentEntEntity ent) {
        return identEntRepository.save(ent);
    }

    public void save(IdentEntEntity ent) {
        identEntRepository.save(ent);
    }
}
