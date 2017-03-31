package com.gongzuochong.dao;

import com.gongzuochong.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by marco on 2017/3/25.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("select mobile from UserEntity user where user.mobile in (?1)")
    List<String> findExistsMobile(Iterable<String> mobiles);

    UserEntity findTop1ByMobile(String mobile);
}
