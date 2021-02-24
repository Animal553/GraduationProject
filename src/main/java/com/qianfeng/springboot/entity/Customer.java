package com.qianfeng.springboot.entity;

import java.util.Date;

public class Customer {
    private Integer customerId;
    private String customerName;
    private String phone;
    private Integer status;
    private Integer chargeId;
    private Integer createId;
    private Integer sourceId;
    private Integer industryId;
    private Integer levelId;
    private Date createTime;
    private Date updateTime;
    private Date nextTime;
    private Integer flg;
    private Employee chargeName;
    private Employee createName;
    private Source source;
    private Industry industry;
    private Level level;

    public Customer() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getChargeId() {
        return chargeId;
    }

    public void setChargeId(Integer chargeId) {
        this.chargeId = chargeId;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getNextTime() {
        return nextTime;
    }

    public void setNextTime(Date nextTime) {
        this.nextTime = nextTime;
    }

    public Integer getFlg() {
        return flg;
    }

    public void setFlg(Integer flg) {
        this.flg = flg;
    }

    public Employee getChargeName() {
        return chargeName;
    }

    public void setChargeName(Employee chargeName) {
        this.chargeName = chargeName;
    }

    public Employee getCreateName() {
        return createName;
    }

    public void setCreateName(Employee createName) {
        this.createName = createName;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", chargeId=" + chargeId +
                ", createId=" + createId +
                ", sourceId=" + sourceId +
                ", industryId=" + industryId +
                ", levelId=" + levelId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", nextTime=" + nextTime +
                ", flg=" + flg +
                ", chargeName=" + chargeName +
                ", createName=" + createName +
                ", source=" + source +
                ", industry=" + industry +
                ", level=" + level +
                '}';
    }
}
