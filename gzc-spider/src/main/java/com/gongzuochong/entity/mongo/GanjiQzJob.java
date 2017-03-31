package com.gongzuochong.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by marco on 2017/3/25.
 */
@Document(collection = "ganji_list")
public class GanjiQzJob {
    @Id
    private String _id;

    private String id;
    private String domain;//城市
    private String title;
    /** 街道 **/
    @Field("street_name")
    private String streetName;
    @Field("street_id")
    private String streetId;

    /** 区域 **/
    @Field("district_name")
    private String districtName;
    @Field("district_id")
    private String districtId;
    /** 职位类别 **/
    private String tag;
    private String tagName;

    @Field("work_address")
    private String workAddress;
    private Integer CategoryId;

    private String description;

    @Field("max_age")
    private String maxAge;
    @Field("min_age")
    private String minAge;

    /** 需要的人数 **/
    @Field("need_num")
    private String needNum;

    private Welfare welfare;
    private CommentOwnerInfo commentOwnerInfo;

    @Field("study_degree")
    private StudyDegree studyDegree;
    private Price price;
    private Sex sex;

    @Field("work_years")
    private WorkYear workYear;

    private Integer published;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetId() {
        return streetId;
    }

    public void setStreetId(String streetId) {
        this.streetId = streetId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(String maxAge) {
        this.maxAge = maxAge;
    }

    public String getMinAge() {
        return minAge;
    }

    public void setMinAge(String minAge) {
        this.minAge = minAge;
    }

    public String getNeedNum() {
        return needNum;
    }

    public void setNeedNum(String needNum) {
        this.needNum = needNum;
    }

    public Welfare getWelfare() {
        return welfare;
    }

    public void setWelfare(Welfare welfare) {
        this.welfare = welfare;
    }

    public CommentOwnerInfo getCommentOwnerInfo() {
        return commentOwnerInfo;
    }

    public void setCommentOwnerInfo(CommentOwnerInfo commentOwnerInfo) {
        this.commentOwnerInfo = commentOwnerInfo;
    }

    public StudyDegree getStudyDegree() {
        return studyDegree;
    }

    public void setStudyDegree(StudyDegree studyDegree) {
        this.studyDegree = studyDegree;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Integer getPublished() {
        return published;
    }

    public void setPublished(Integer published) {
        this.published = published;
    }

    public WorkYear getWorkYear() {
        return workYear;
    }

    public void setWorkYear(WorkYear workYear) {
        this.workYear = workYear;
    }

    public Integer getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Integer categoryId) {
        CategoryId = categoryId;
    }

    public class Welfare{
        private String other;
        private String room;
        private String insurance;

        public String getOther() {
            return other;
        }

        public void setOther(String other) {
            this.other = other;
        }

        public String getRoom() {
            return room;
        }

        public void setRoom(String room) {
            this.room = room;
        }

        public String getInsurance() {
            return insurance;
        }

        public void setInsurance(String insurance) {
            this.insurance = insurance;
        }
    }

    public class CommentOwnerInfo{
        private String userName;
        private String companyName;
        private String phone;
        private String ownerId;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(String ownerId) {
            this.ownerId = ownerId;
        }

    }

    public class StudyDegree{
        private String t;
        private String v;

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getV() {
            return v;
        }

        public void setV(String v) {
            this.v = v;
        }
    }

    public class Price{
        private String t;
        private String v;

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getV() {
            return v;
        }

        public void setV(String v) {
            this.v = v;
        }
    }

    public class Sex{
        private String t;
        private String v;

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getV() {
            return v;
        }

        public void setV(String v) {
            this.v = v;
        }
    }

    public class WorkYear{
        private String t;
        private String v;

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getV() {
            return v;
        }

        public void setV(String v) {
            this.v = v;
        }
    }

}
