package com.gongzuochong.service;

import com.gongzuochong.dao.DistrictRepository;
import com.gongzuochong.entity.DistrictEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marco on 2017/3/29.
 */
@Service
@CacheConfig(cacheNames = "district")
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Cacheable("district:parent")
    public List<DistrictEntity> findByParent(int parent){
        return districtRepository.findByParent(parent);
    }

    @Cacheable("district:value")
    public DistrictEntity findByValue(int value){
        return districtRepository.findByValue(value);
    }

    public static String getDistrictFullpath(int district) {
        String s = String.valueOf(district);
        if (s.length() == 8){
            return String.join(",", s.substring(0,2), s.substring(0,4), s.substring(0,6), s);
        }
        return "";
    }

}
