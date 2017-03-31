package com.gongzuochong.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by marco on 2017/3/25.
 */
@Entity
@Table(name = "job_category", schema = "wechat", catalog = "")
public class JobCategoryEntity {
    private int id;
    private int value;
    private String code;
    private String text;
    private String sName;
    private int level;
    private int parent;
    private int disabled;
    private int order;
    private Date createTime;
    private Date updateTime;
    private Integer isleaf;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "value", nullable = false)
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 200)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "text", nullable = false, length = 128)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "s_name", nullable = false, length = 50)
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Basic
    @Column(name = "level", nullable = false)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Basic
    @Column(name = "parent", nullable = false)
    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    @Basic
    @Column(name = "disabled", nullable = false)
    public int getDisabled() {
        return disabled;
    }

    public void setDisabled(int disabled) {
        this.disabled = disabled;
    }

    @Basic
    @Column(name = "order", nullable = false)
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
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
    @Column(name = "update_time", nullable = false)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "isleaf", nullable = true)
    public Integer getIsleaf() {
        return isleaf;
    }

    public void setIsleaf(Integer isleaf) {
        this.isleaf = isleaf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobCategoryEntity that = (JobCategoryEntity) o;

        if (id != that.id) return false;
        if (value != that.value) return false;
        if (level != that.level) return false;
        if (parent != that.parent) return false;
        if (disabled != that.disabled) return false;
        if (order != that.order) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (sName != null ? !sName.equals(that.sName) : that.sName != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (isleaf != null ? !isleaf.equals(that.isleaf) : that.isleaf != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + value;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (sName != null ? sName.hashCode() : 0);
        result = 31 * result + level;
        result = 31 * result + parent;
        result = 31 * result + disabled;
        result = 31 * result + order;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (isleaf != null ? isleaf.hashCode() : 0);
        return result;
    }
}
