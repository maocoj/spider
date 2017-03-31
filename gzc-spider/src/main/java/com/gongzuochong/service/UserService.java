package com.gongzuochong.service;

import com.gongzuochong.dao.UserInfoRepository;
import com.gongzuochong.dao.UserRepository;
import com.gongzuochong.entity.IdentEntEntity;
import com.gongzuochong.entity.UserEntity;
import com.gongzuochong.entity.UserInfoEntity;
import com.gongzuochong.enums.ThirdUserType;
import com.google.common.base.Strings;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by marco on 2017/3/28.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private TicketService ticketService;

    Set<String> userMobiles = new HashSet<>(1000);

    /** 手机号码的迭代器 */
    Iterator<String> it = null;

    private final static String prefix = "16330";



    /**
     * 创建用户 不传mobile自动生成后创建
     * @param thirdUserType
     * @return
     */
    public long createUserWithMobile(final ThirdUserType thirdUserType, String mobile) {

        UserEntity user = new UserEntity();
        //自动生成一个手机号
        if (Strings.isNullOrEmpty(mobile)){
            mobile = getUserMobile();
        }
        String password = mobile + "G163";
        user.setMobile(mobile);
        String enpassword = this.encryptPassword(password);
        user.setPassword(enpassword);
        user.setState(1);
        user.setOldUser(0);
        user.setIcon("");
        user.setEmail("");
        user.setNick("");

        if (thirdUserType == null){
            user.setThirdUserType(ThirdUserType.GZC.getValue());
        }else {
            user.setThirdUserType(thirdUserType.getValue());
        }
        user.setUserType(1);
        user.setCreateTime(new Date());
        user.setLastLoginTime(new Date());
        UserEntity regist = this.regist(user);

        return regist.getId();
    }


    public long createUserWithRandomMobile(final ThirdUserType thirdUserType) {

        UserEntity user = new UserEntity();
        //自动生成一个手机号
        String mobile = getUserMobile();
        String password = mobile + "G163";
        user.setMobile(mobile);
        String enpassword = this.encryptPassword(password);
        user.setPassword(enpassword);
        user.setState(1);
        user.setOldUser(0);
        user.setIcon("");
        user.setEmail("");
        user.setNick("");

        if (thirdUserType == null){
            user.setThirdUserType(ThirdUserType.GZC.getValue());
        }else {
            user.setThirdUserType(thirdUserType.getValue());
        }
        user.setUserType(1);
        user.setCreateTime(new Date());
        user.setLastLoginTime(new Date());
        UserEntity regist = this.regist(user);

        return regist.getId();
    }

    public UserEntity findByMobile(String mobile) {
        return userRepository.findTop1ByMobile(mobile);
    }

    public UserEntity findOne(Long id){
        return userRepository.findOne(id);
    }

    public UserEntity regist(UserEntity userEntity) {
        userRepository.save(userEntity);

        String nick = userEntity.getThirdUname();
        if (StringUtils.isNullOrEmpty(nick)) {
            nick = userEntity.getMobile();
        }

        UserInfoEntity userInfo = new UserInfoEntity();
        userInfo.setUid(userEntity.getId());
        userInfo.setNick(nick);
        userInfo.setIcon("");
        userInfo.setMobile(userEntity.getMobile());
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(new Date());
        userInfo.setState(0);
        this.saveUserInfo(userInfo);

        return userEntity;
    }

    public String encryptPassword(String password) {
        return ticketService.createSavePassword(password);
    }

    public UserInfoEntity saveUserInfo(UserInfoEntity userInfo) {

        userInfoRepository.save(userInfo);

        return userInfo;
    }

    /** 获取一个用户的手机号*/
    public synchronized String getUserMobile() {
        if (it == null || !it.hasNext()) {
            userMobiles = advanceMobiles();
            it = userMobiles.iterator();
        }
        return it.next();
    }

    //预分配一批手机号
    private Set<String> advanceMobiles() {
        //预生成一批手机号
        Set<String> mobiles = getRandomMobiles();

        //到数据库中查询出已经存在的手机号
        List<String> existMobiles = userRepository.findExistsMobile(mobiles);

        //排除已存在的手机号
        Set<String> usableMobiles = mobiles.stream()
                .filter(mobile -> !existMobiles.contains(mobile))
                .collect(Collectors.toSet());

        if (usableMobiles.size() == 0) {
            return advanceMobiles();
        }
        return usableMobiles;
    }

    /**
     * 生成1000个手机号
     *
     * @return
     */
    private Set<String> getRandomMobiles() {
        Set<String> mobiles = new HashSet<>();
        while (true) {
            if (mobiles.size() >= 1000) {
                break;
            }
            mobiles.add(getRandomMobile());
        }
        return mobiles;
    }

    /**
     * 获取随机手机号
     *
     * @return
     */
    private String getRandomMobile() {

        //随机 生成 1 到 99999999的随机数 0 -1   0-999998   1- 999999
        long randomMobile = Math.round(Math.random() * 999998 + 1);
        String pattern = "000000";

        java.text.DecimalFormat df = new java.text.DecimalFormat(pattern);
        return prefix.concat(df.format(randomMobile));
    }
}
