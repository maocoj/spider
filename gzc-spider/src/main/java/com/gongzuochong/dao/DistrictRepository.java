package com.gongzuochong.dao;

import com.gongzuochong.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by marco on 2017/3/25.
 */

public interface DistrictRepository extends JpaRepository<DistrictEntity, Long> {
    List<DistrictEntity> findByParent(int parent);

    DistrictEntity findByValue(int value);
}
