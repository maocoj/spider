package com.gongzuochong.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by marco on 2017/3/25.
 */
@Entity
@Table(name = "ident_ent", schema = "wechat", catalog = "")
public class IdentEntEntity {
    private long id;
    private long uid;
    private String entName;
    private String entIcon;
    private String alias;
    private int entNature;
    private int industry;
    private int scale;
    private int contactPosition;
    private int district;
    private String address;
    private String contact;
    private String legalRep;
    private String legalIdCard;
    private String tel;
    private String description;
    private String licensePic;
    private String backgroundPic;
    private String regNumber;
    private int degree;
    private int state;
    private Date createTime;
    private Date updateTime;

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
    @Column(name = "uid", nullable = false)
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "ent_name", nullable = false, length = 100)
    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    @Basic
    @Column(name = "ent_icon", nullable = false, length = 100)
    public String getEntIcon() {
        return entIcon;
    }

    public void setEntIcon(String entIcon) {
        this.entIcon = entIcon;
    }

    @Basic
    @Column(name = "alias", nullable = true, length = 100)
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Basic
    @Column(name = "ent_nature", nullable = false)
    public int getEntNature() {
        return entNature;
    }

    public void setEntNature(int entNature) {
        this.entNature = entNature;
    }

    @Basic
    @Column(name = "industry", nullable = false)
    public int getIndustry() {
        return industry;
    }

    public void setIndustry(int industry) {
        this.industry = industry;
    }

    @Basic
    @Column(name = "scale", nullable = false)
    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    @Basic
    @Column(name = "contact_position", nullable = false)
    public int getContactPosition() {
        return contactPosition;
    }

    public void setContactPosition(int contactPosition) {
        this.contactPosition = contactPosition;
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
    @Column(name = "address", nullable = true, length = 400)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "contact", nullable = true, length = 50)
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Basic
    @Column(name = "legal_rep", nullable = false, length = 50)
    public String getLegalRep() {
        return legalRep;
    }

    public void setLegalRep(String legalRep) {
        this.legalRep = legalRep;
    }

    @Basic
    @Column(name = "legal_id_card", nullable = false, length = 30)
    public String getLegalIdCard() {
        return legalIdCard;
    }

    public void setLegalIdCard(String legalIdCard) {
        this.legalIdCard = legalIdCard;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 30)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 4000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "license_pic", nullable = false, length = 100)
    public String getLicensePic() {
        return licensePic;
    }

    public void setLicensePic(String licensePic) {
        this.licensePic = licensePic;
    }

    @Basic
    @Column(name = "background_pic", nullable = false, length = 400)
    public String getBackgroundPic() {
        return backgroundPic;
    }

    public void setBackgroundPic(String backgroundPic) {
        this.backgroundPic = backgroundPic;
    }

    @Basic
    @Column(name = "reg_number", nullable = false, length = 50)
    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    @Basic
    @Column(name = "degree", nullable = false)
    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdentEntEntity that = (IdentEntEntity) o;

        if (id != that.id) return false;
        if (uid != that.uid) return false;
        if (entNature != that.entNature) return false;
        if (industry != that.industry) return false;
        if (scale != that.scale) return false;
        if (contactPosition != that.contactPosition) return false;
        if (district != that.district) return false;
        if (degree != that.degree) return false;
        if (state != that.state) return false;
        if (entName != null ? !entName.equals(that.entName) : that.entName != null) return false;
        if (entIcon != null ? !entIcon.equals(that.entIcon) : that.entIcon != null) return false;
        if (alias != null ? !alias.equals(that.alias) : that.alias != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (contact != null ? !contact.equals(that.contact) : that.contact != null) return false;
        if (legalRep != null ? !legalRep.equals(that.legalRep) : that.legalRep != null) return false;
        if (legalIdCard != null ? !legalIdCard.equals(that.legalIdCard) : that.legalIdCard != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (licensePic != null ? !licensePic.equals(that.licensePic) : that.licensePic != null) return false;
        if (backgroundPic != null ? !backgroundPic.equals(that.backgroundPic) : that.backgroundPic != null)
            return false;
        if (regNumber != null ? !regNumber.equals(that.regNumber) : that.regNumber != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (uid ^ (uid >>> 32));
        result = 31 * result + (entName != null ? entName.hashCode() : 0);
        result = 31 * result + (entIcon != null ? entIcon.hashCode() : 0);
        result = 31 * result + (alias != null ? alias.hashCode() : 0);
        result = 31 * result + entNature;
        result = 31 * result + industry;
        result = 31 * result + scale;
        result = 31 * result + contactPosition;
        result = 31 * result + district;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (legalRep != null ? legalRep.hashCode() : 0);
        result = 31 * result + (legalIdCard != null ? legalIdCard.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (licensePic != null ? licensePic.hashCode() : 0);
        result = 31 * result + (backgroundPic != null ? backgroundPic.hashCode() : 0);
        result = 31 * result + (regNumber != null ? regNumber.hashCode() : 0);
        result = 31 * result + degree;
        result = 31 * result + state;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IdentEntEntity{" +
                "id=" + id +
                ", uid=" + uid +
                ", entName='" + entName + '\'' +
                ", entIcon='" + entIcon + '\'' +
                ", alias='" + alias + '\'' +
                ", entNature=" + entNature +
                ", industry=" + industry +
                ", scale=" + scale +
                ", contactPosition=" + contactPosition +
                ", district=" + district +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", legalRep='" + legalRep + '\'' +
                ", legalIdCard='" + legalIdCard + '\'' +
                ", tel='" + tel + '\'' +
                ", description='" + description + '\'' +
                ", licensePic='" + licensePic + '\'' +
                ", backgroundPic='" + backgroundPic + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", degree=" + degree +
                ", state=" + state +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
