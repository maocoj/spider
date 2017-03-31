package com.gongzuochong.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by marco on 2017/3/25.
 */
@Entity
@Table(name = "job", schema = "wechat", catalog = "")
public class JobEntity {
    private long id;
    private int indexed;
    private int state;
    private long uid;
    private int employerType;
    private String title;
    private String pics;
    private String entName;
    private int jobType;
    private int cateFirst;
    private String cateFullpath;
    private int places;
    private int city;
    private int district;
    private String districtFullpath;
    private String address;
    private String phone;
    private String telphone;
    private String contactName;
    private int sex;
    private int education;
    private int minAge;
    private int maxAge;
    private int minHeight;
    private int maxHeight;
    private Date startDate;
    private Date endDate;
    private String checkinTime;
    private String checkoutTime;
    private String workTime;
    private int pay;
    private Integer payQz;
    private int unit;
    private int payment;
    private Integer workingYear;
    private Integer isInterview;
    private String tags;
    private String content;
    private String memo;
    private Long viewCount;
    private Date postTime;
    private Date createTime;
    private Date updateTime;
    private int settlementType;
    private int verifyType;
    private int employCount;
    private int isStudent;
    private int platform;
    private Double baiduLat;
    private Double baiduLon;
    private Double latitude;
    private Double longitude;
    private Date lbsSyncTime;
    private Integer userType;
    private String sourceId;
    private int recommendPlace;
    private int jobSource;

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
    @Column(name = "indexed", nullable = false)
    public int getIndexed() {
        return indexed;
    }

    public void setIndexed(int indexed) {
        this.indexed = indexed;
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
    @Column(name = "uid", nullable = false)
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "employer_type", nullable = false)
    public int getEmployerType() {
        return employerType;
    }

    public void setEmployerType(int employerType) {
        this.employerType = employerType;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 90)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "pics", nullable = true, length = 400)
    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    @Basic
    @Column(name = "ent_name", nullable = true, length = 100)
    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    @Basic
    @Column(name = "job_type", nullable = false)
    public int getJobType() {
        return jobType;
    }

    public void setJobType(int jobType) {
        this.jobType = jobType;
    }

    @Basic
    @Column(name = "cate_first", nullable = false)
    public int getCateFirst() {
        return cateFirst;
    }

    public void setCateFirst(int cateFirst) {
        this.cateFirst = cateFirst;
    }

    @Basic
    @Column(name = "cate_fullpath", nullable = false, length = 50)
    public String getCateFullpath() {
        return cateFullpath;
    }

    public void setCateFullpath(String cateFullpath) {
        this.cateFullpath = cateFullpath;
    }

    @Basic
    @Column(name = "places", nullable = false)
    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    @Basic
    @Column(name = "city", nullable = false)
    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    @Basic
    @Column(name = "district", nullable = false)
    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    @Basic
    @Column(name = "district_fullpath", nullable = false, length = 50)
    public String getDistrictFullpath() {
        return districtFullpath;
    }

    public void setDistrictFullpath(String districtFullpath) {
        this.districtFullpath = districtFullpath;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 400)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 50)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "telphone", nullable = true, length = 50)
    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    @Basic
    @Column(name = "contact_name", nullable = true, length = 50)
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Basic
    @Column(name = "sex", nullable = false)
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "education", nullable = false)
    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    @Basic
    @Column(name = "min_age", nullable = false)
    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    @Basic
    @Column(name = "max_age", nullable = false)
    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    @Basic
    @Column(name = "min_height", nullable = false)
    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    @Basic
    @Column(name = "max_height", nullable = false)
    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Basic
    @Column(name = "start_date", nullable = true)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = true)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "checkin_time", nullable = true, length = 6)
    public String getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(String checkinTime) {
        this.checkinTime = checkinTime;
    }

    @Basic
    @Column(name = "checkout_time", nullable = true, length = 6)
    public String getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(String checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    @Basic
    @Column(name = "work_time", nullable = false, length = 50)
    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    @Basic
    @Column(name = "pay", nullable = false)
    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    @Basic
    @Column(name = "pay_qz", nullable = true)
    public Integer getPayQz() {
        return payQz;
    }

    public void setPayQz(Integer payQz) {
        this.payQz = payQz;
    }

    @Basic
    @Column(name = "unit", nullable = false)
    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "payment", nullable = false)
    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    @Basic
    @Column(name = "working_year", nullable = true)
    public Integer getWorkingYear() {
        return workingYear;
    }

    public void setWorkingYear(Integer workingYear) {
        this.workingYear = workingYear;
    }

    @Basic
    @Column(name = "is_interview", nullable = true)
    public Integer getIsInterview() {
        return isInterview;
    }

    public void setIsInterview(Integer isInterview) {
        this.isInterview = isInterview;
    }

    @Basic
    @Column(name = "tags", nullable = true, length = 50)
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 4000)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "memo", nullable = false, length = 1000)
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Basic
    @Column(name = "view_count", nullable = true)
    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    @Basic
    @Column(name = "post_time", nullable = true)
    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
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
    @Column(name = "settlement_type", nullable = false)
    public int getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(int settlementType) {
        this.settlementType = settlementType;
    }

    @Basic
    @Column(name = "verify_type", nullable = false)
    public int getVerifyType() {
        return verifyType;
    }

    public void setVerifyType(int verifyType) {
        this.verifyType = verifyType;
    }

    @Basic
    @Column(name = "employ_count", nullable = false)
    public int getEmployCount() {
        return employCount;
    }

    public void setEmployCount(int employCount) {
        this.employCount = employCount;
    }

    @Basic
    @Column(name = "is_student", nullable = false)
    public int getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(int isStudent) {
        this.isStudent = isStudent;
    }

    @Basic
    @Column(name = "platform", nullable = false)
    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    @Basic
    @Column(name = "baidu_lat", nullable = true, precision = 0)
    public Double getBaiduLat() {
        return baiduLat;
    }

    public void setBaiduLat(Double baiduLat) {
        this.baiduLat = baiduLat;
    }

    @Basic
    @Column(name = "baidu_lon", nullable = true, precision = 0)
    public Double getBaiduLon() {
        return baiduLon;
    }

    public void setBaiduLon(Double baiduLon) {
        this.baiduLon = baiduLon;
    }

    @Basic
    @Column(name = "latitude", nullable = true, precision = 0)
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude", nullable = true, precision = 0)
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "lbs_sync_time", nullable = true)
    public Date getLbsSyncTime() {
        return lbsSyncTime;
    }

    public void setLbsSyncTime(Date lbsSyncTime) {
        this.lbsSyncTime = lbsSyncTime;
    }

    @Basic
    @Column(name = "user_type", nullable = true)
    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "source_id", nullable = true, length = 32)
    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    @Basic
    @Column(name = "recommend_place", nullable = false)
    public int getRecommendPlace() {
        return recommendPlace;
    }

    public void setRecommendPlace(int recommendPlace) {
        this.recommendPlace = recommendPlace;
    }

    @Basic
    @Column(name = "job_source", nullable = false)
    public int getJobSource() {
        return jobSource;
    }

    public void setJobSource(int jobSource) {
        this.jobSource = jobSource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobEntity jobEntity = (JobEntity) o;

        if (id != jobEntity.id) return false;
        if (indexed != jobEntity.indexed) return false;
        if (state != jobEntity.state) return false;
        if (uid != jobEntity.uid) return false;
        if (employerType != jobEntity.employerType) return false;
        if (jobType != jobEntity.jobType) return false;
        if (cateFirst != jobEntity.cateFirst) return false;
        if (places != jobEntity.places) return false;
        if (city != jobEntity.city) return false;
        if (district != jobEntity.district) return false;
        if (sex != jobEntity.sex) return false;
        if (education != jobEntity.education) return false;
        if (minAge != jobEntity.minAge) return false;
        if (maxAge != jobEntity.maxAge) return false;
        if (minHeight != jobEntity.minHeight) return false;
        if (maxHeight != jobEntity.maxHeight) return false;
        if (pay != jobEntity.pay) return false;
        if (unit != jobEntity.unit) return false;
        if (payment != jobEntity.payment) return false;
        if (settlementType != jobEntity.settlementType) return false;
        if (verifyType != jobEntity.verifyType) return false;
        if (employCount != jobEntity.employCount) return false;
        if (isStudent != jobEntity.isStudent) return false;
        if (platform != jobEntity.platform) return false;
        if (recommendPlace != jobEntity.recommendPlace) return false;
        if (jobSource != jobEntity.jobSource) return false;
        if (title != null ? !title.equals(jobEntity.title) : jobEntity.title != null) return false;
        if (pics != null ? !pics.equals(jobEntity.pics) : jobEntity.pics != null) return false;
        if (entName != null ? !entName.equals(jobEntity.entName) : jobEntity.entName != null) return false;
        if (cateFullpath != null ? !cateFullpath.equals(jobEntity.cateFullpath) : jobEntity.cateFullpath != null)
            return false;
        if (districtFullpath != null ? !districtFullpath.equals(jobEntity.districtFullpath) : jobEntity.districtFullpath != null)
            return false;
        if (address != null ? !address.equals(jobEntity.address) : jobEntity.address != null) return false;
        if (phone != null ? !phone.equals(jobEntity.phone) : jobEntity.phone != null) return false;
        if (telphone != null ? !telphone.equals(jobEntity.telphone) : jobEntity.telphone != null) return false;
        if (contactName != null ? !contactName.equals(jobEntity.contactName) : jobEntity.contactName != null)
            return false;
        if (startDate != null ? !startDate.equals(jobEntity.startDate) : jobEntity.startDate != null) return false;
        if (endDate != null ? !endDate.equals(jobEntity.endDate) : jobEntity.endDate != null) return false;
        if (checkinTime != null ? !checkinTime.equals(jobEntity.checkinTime) : jobEntity.checkinTime != null)
            return false;
        if (checkoutTime != null ? !checkoutTime.equals(jobEntity.checkoutTime) : jobEntity.checkoutTime != null)
            return false;
        if (workTime != null ? !workTime.equals(jobEntity.workTime) : jobEntity.workTime != null) return false;
        if (payQz != null ? !payQz.equals(jobEntity.payQz) : jobEntity.payQz != null) return false;
        if (workingYear != null ? !workingYear.equals(jobEntity.workingYear) : jobEntity.workingYear != null)
            return false;
        if (isInterview != null ? !isInterview.equals(jobEntity.isInterview) : jobEntity.isInterview != null)
            return false;
        if (tags != null ? !tags.equals(jobEntity.tags) : jobEntity.tags != null) return false;
        if (content != null ? !content.equals(jobEntity.content) : jobEntity.content != null) return false;
        if (memo != null ? !memo.equals(jobEntity.memo) : jobEntity.memo != null) return false;
        if (viewCount != null ? !viewCount.equals(jobEntity.viewCount) : jobEntity.viewCount != null) return false;
        if (postTime != null ? !postTime.equals(jobEntity.postTime) : jobEntity.postTime != null) return false;
        if (createTime != null ? !createTime.equals(jobEntity.createTime) : jobEntity.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(jobEntity.updateTime) : jobEntity.updateTime != null) return false;
        if (baiduLat != null ? !baiduLat.equals(jobEntity.baiduLat) : jobEntity.baiduLat != null) return false;
        if (baiduLon != null ? !baiduLon.equals(jobEntity.baiduLon) : jobEntity.baiduLon != null) return false;
        if (latitude != null ? !latitude.equals(jobEntity.latitude) : jobEntity.latitude != null) return false;
        if (longitude != null ? !longitude.equals(jobEntity.longitude) : jobEntity.longitude != null) return false;
        if (lbsSyncTime != null ? !lbsSyncTime.equals(jobEntity.lbsSyncTime) : jobEntity.lbsSyncTime != null)
            return false;
        if (userType != null ? !userType.equals(jobEntity.userType) : jobEntity.userType != null) return false;
        if (sourceId != null ? !sourceId.equals(jobEntity.sourceId) : jobEntity.sourceId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + indexed;
        result = 31 * result + state;
        result = 31 * result + (int) (uid ^ (uid >>> 32));
        result = 31 * result + employerType;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (pics != null ? pics.hashCode() : 0);
        result = 31 * result + (entName != null ? entName.hashCode() : 0);
        result = 31 * result + jobType;
        result = 31 * result + cateFirst;
        result = 31 * result + (cateFullpath != null ? cateFullpath.hashCode() : 0);
        result = 31 * result + places;
        result = 31 * result + city;
        result = 31 * result + district;
        result = 31 * result + (districtFullpath != null ? districtFullpath.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (telphone != null ? telphone.hashCode() : 0);
        result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
        result = 31 * result + sex;
        result = 31 * result + education;
        result = 31 * result + minAge;
        result = 31 * result + maxAge;
        result = 31 * result + minHeight;
        result = 31 * result + maxHeight;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (checkinTime != null ? checkinTime.hashCode() : 0);
        result = 31 * result + (checkoutTime != null ? checkoutTime.hashCode() : 0);
        result = 31 * result + (workTime != null ? workTime.hashCode() : 0);
        result = 31 * result + pay;
        result = 31 * result + (payQz != null ? payQz.hashCode() : 0);
        result = 31 * result + unit;
        result = 31 * result + payment;
        result = 31 * result + (workingYear != null ? workingYear.hashCode() : 0);
        result = 31 * result + (isInterview != null ? isInterview.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (memo != null ? memo.hashCode() : 0);
        result = 31 * result + (viewCount != null ? viewCount.hashCode() : 0);
        result = 31 * result + (postTime != null ? postTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + settlementType;
        result = 31 * result + verifyType;
        result = 31 * result + employCount;
        result = 31 * result + isStudent;
        result = 31 * result + platform;
        result = 31 * result + (baiduLat != null ? baiduLat.hashCode() : 0);
        result = 31 * result + (baiduLon != null ? baiduLon.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (lbsSyncTime != null ? lbsSyncTime.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (sourceId != null ? sourceId.hashCode() : 0);
        result = 31 * result + recommendPlace;
        result = 31 * result + jobSource;
        return result;
    }
}
