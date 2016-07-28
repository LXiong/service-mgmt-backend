package com.ai.paas.ipaas.rds.dao.mapper.bo;

import java.sql.Timestamp;

public class RdsInstanceStatus {
    private Long instancestatusid;

    private Timestamp instancecreatetime;

    private Timestamp instancelastupdatetime;

    private Integer instancestatus;

    private Long instancestatusbelonger;

    public Long getInstancestatusid() {
        return instancestatusid;
    }

    public void setInstancestatusid(Long instancestatusid) {
        this.instancestatusid = instancestatusid;
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

    public Integer getInstancestatus() {
        return instancestatus;
    }

    public void setInstancestatus(Integer instancestatus) {
        this.instancestatus = instancestatus;
    }

    public Long getInstancestatusbelonger() {
        return instancestatusbelonger;
    }

    public void setInstancestatusbelonger(Long instancestatusbelonger) {
        this.instancestatusbelonger = instancestatusbelonger;
    }
}