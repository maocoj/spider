package com.gongzuochong.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by marco on 2017/3/25.
 */
@Entity
@Table(name = "user", schema = "wechat", catalog = "")
public class UserEntity {
    private long id;
    private String mobile;
    private String nick;
    private String icon;
    private String email;
    private String password;
    private int state;
    private int oldUser;
    private int orderState;
    private int userType;
    private String openid;
    private Integer platform;
    private Date createTime;
    private Date lastLoginTime;
    private Integer thirdUserType;
    private String thirdUid;
    private String thirdUname;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 20)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "nick", nullable = false, length = 30)
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Basic
    @Column(name = "icon", nullable = false, length = 50)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "old_user", nullable = false)
    public int getOldUser() {
        return oldUser;
    }

    public void setOldUser(int oldUser) {
        this.oldUser = oldUser;
    }

    @Basic
    @Column(name = "order_state", nullable = false)
    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    @Basic
    @Column(name = "user_type", nullable = false)
    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "openid", nullable = true, length = 100)
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Basic
    @Column(name = "platform", nullable = true)
    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "last_login_time", nullable = false)
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Basic
    @Column(name = "third_user_type", nullable = true)
    public Integer getThirdUserType() {
        return thirdUserType;
    }

    public void setThirdUserType(Integer thirdUserType) {
        this.thirdUserType = thirdUserType;
    }

    @Basic
    @Column(name = "third_uid", nullable = true, length = 100)
    public String getThirdUid() {
        return thirdUid;
    }

    public void setThirdUid(String thirdUid) {
        this.thirdUid = thirdUid;
    }

    @Basic
    @Column(name = "third_uname", nullable = true, length = 100)
    public String getThirdUname() {
        return thirdUname;
    }

    public void setThirdUname(String thirdUname) {
        this.thirdUname = thirdUname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (state != that.state) return false;
        if (oldUser != that.oldUser) return false;
        if (orderState != that.orderState) return false;
        if (userType != that.userType) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (nick != null ? !nick.equals(that.nick) : that.nick != null) return false;
        if (icon != null ? !icon.equals(that.icon) : that.icon != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (openid != null ? !openid.equals(that.openid) : that.openid != null) return false;
        if (platform != null ? !platform.equals(that.platform) : that.platform != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (lastLoginTime != null ? !lastLoginTime.equals(that.lastLoginTime) : that.lastLoginTime != null)
            return false;
        if (thirdUserType != null ? !thirdUserType.equals(that.thirdUserType) : that.thirdUserType != null)
            return false;
        if (thirdUid != null ? !thirdUid.equals(that.thirdUid) : that.thirdUid != null) return false;
        if (thirdUname != null ? !thirdUname.equals(that.thirdUname) : that.thirdUname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (nick != null ? nick.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + state;
        result = 31 * result + oldUser;
        result = 31 * result + orderState;
        result = 31 * result + userType;
        result = 31 * result + (openid != null ? openid.hashCode() : 0);
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        result = 31 * result + (thirdUserType != null ? thirdUserType.hashCode() : 0);
        result = 31 * result + (thirdUid != null ? thirdUid.hashCode() : 0);
        result = 31 * result + (thirdUname != null ? thirdUname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", nick='" + nick + '\'' +
                ", icon='" + icon + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                ", oldUser=" + oldUser +
                ", orderState=" + orderState +
                ", userType=" + userType +
                ", openid='" + openid + '\'' +
                ", platform=" + platform +
                ", createTime=" + createTime +
                ", lastLoginTime=" + lastLoginTime +
                ", thirdUserType=" + thirdUserType +
                ", thirdUid='" + thirdUid + '\'' +
                ", thirdUname='" + thirdUname + '\'' +
                '}';
    }
}
