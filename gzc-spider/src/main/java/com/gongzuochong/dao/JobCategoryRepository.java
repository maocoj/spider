package com.gongzuochong.dao;

import com.gongzuochong.entity.JobCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by marco on 2017/3/25.
 */
public interface JobCategoryRepository extends JpaRepository<JobCategoryEntity, Long>{
    JobCategoryEntity findTop1ByValue(Integer value);
}
