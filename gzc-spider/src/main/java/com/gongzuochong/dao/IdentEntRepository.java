package com.gongzuochong.dao;

import com.gongzuochong.entity.IdentEntEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by marco on 2017/3/25.
 */
public interface IdentEntRepository extends JpaRepository<IdentEntEntity,Long>{

    IdentEntEntity findTop1ByEntName(String companyName);

    List<IdentEntEntity> findByEntName(String entName);
}
