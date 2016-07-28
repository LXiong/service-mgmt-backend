package com.ai.paas.ipaas.rds.dao.mapper.bo;

import java.sql.Timestamp;

public class RdsInstanceBase {
    private Long instanceid;

    private String instancecategory;

    private Timestamp instancecreatetime;

    private Timestamp instancelastupdatetime;

    private String instancelocation;

    private String instancemysqlcategory;

    private String instancename;

    private Integer instancenetworktype;

    private String instancetag;

    private String instanceusetype;

    private String serialNumber;

    private String userId;

    private Long instanceimagebelonger;

    private Long instanceresourcebelonger;

    public Long getInstanceid() {
        return instanceid;
    }

    public void setInstanceid(Long instanceid) {
        this.instanceid = instanceid;
    }

    public String getInstancecategory() {
        return instancecategory;
    }

    public void setInstancecategory(String instancecategory) {
        this.instancecategory = instancecategory == null ? null : instancecategory.trim();
    }

    public Timestamp getInstancecreatetime() {
        return instancecreatetime;
    }

    public void setInstancecreatetime(Timestamp instancecreatetime) {
        this.instancecreatetime = instancecreatetime;
    }

    public Timestamp getInstancelastupdatetime() {
        return instancelastupdatetime;
    }

    public void setInstancelastupdatetime(Timestamp instancelastupdatetime) {
        this.instancelastupdatetime = instancelastupdatetime;
    }

    public String getInstancelocation() {
        return instancelocation;
    }

    public void setInstancelocation(String instancelocation) {
        this.instancelocation = instancelocation == null ? null : instancelocation.trim();
    }

    public String getInstancemysqlcategory() {
        return instancemysqlcategory;
    }

    public void setInstancemysqlcategory(String instancemysqlcategory) {
        this.instancemysqlcategory = instancemysqlcategory == null ? null : instancemysqlcategory.trim();
    }

    public String getInstancename() {
        return instancename;
    }

    public void setInstancename(String instancename) {
        this.instancename = instancename == null ? null : instancename.trim();
    }

    public Integer getInstancenetworktype() {
        return instancenetworktype;
    }

    public void setInstancenetworktype(Integer instancenetworktype) {
        this.instancenetworktype = instancenetworktype;
    }

    public String getInstancetag() {
        return instancetag;
    }

    public void setInstancetag(String instancetag) {
        this.instancetag = instancetag == null ? null : instancetag.trim();
    }

    public String getInstanceusetype() {
        return instanceusetype;
    }

    public void setInstanceusetype(String instanceusetype) {
        this.instanceusetype = instanceusetype == null ? null : instanceusetype.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Long getInstanceimagebelonger() {
        return instanceimagebelonger;
    }

    public void setInstanceimagebelonger(Long instanceimagebelonger) {
        this.instanceimagebelonger = instanceimagebelonger;
    }

    public Long getInstanceresourcebelonger() {
        return instanceresourcebelonger;
    }

    public void setInstanceresourcebelonger(Long instanceresourcebelonger) {
        this.instanceresourcebelonger = instanceresourcebelonger;
    }
}