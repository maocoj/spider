package com.gongzuochong.dao;

import com.gongzuochong.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by marco on 2017/3/25.
 */
public interface JobRepository extends JpaRepository<JobEntity, Long> {
    JobEntity findOne(Long id);
}
