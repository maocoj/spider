package com.gongzuochong.service;

import com.gongzuochong.dao.JobCategoryRepository;
import com.gongzuochong.entity.JobCategoryEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing JobCategory.
 */
@Service
public class JobCategoryService {
    private final static Logger logger = LoggerFactory.getLogger(JobCategoryService.class);

    @Autowired
    private JobCategoryRepository jobCategoryRepository;


    @Cacheable("fullPath")
    public String getFullPathText(Integer value){
        JobCategoryEntity one = jobCategoryRepository.findTop1ByValue(value);
        List<JobCategoryEntity> allTheOne = new ArrayList<>();
        allTheOne.add(one);
        while(one != null && one.getLevel() != 0){
            one = jobCategoryRepository.findTop1ByValue(one.getParent());
            if (one != null){
                allTheOne.add(one);
            }
        }
        Collections.reverse(allTheOne);
        List<String> collect;
        try{
            collect = allTheOne.stream()
                    .map(JobCategoryEntity::getValue)
                    .map(String::valueOf)
                    .collect(Collectors.toList());
        }catch (Exception e){
            logger.error("获取fullpath出错：jobtype:{}", value);
            throw e;
        }

        return String.join(",", collect);
    }
}
