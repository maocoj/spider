package com.gongzuochong.dao;

import com.gongzuochong.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by marco on 2017/3/25.
 */
public interface UserInfoRepository extends JpaRepository<UserInfoEntity,Long> {
}
