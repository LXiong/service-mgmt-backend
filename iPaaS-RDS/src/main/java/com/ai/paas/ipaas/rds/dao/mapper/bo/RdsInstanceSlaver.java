package com.ai.paas.ipaas.rds.dao.mapper.bo;

import java.sql.Timestamp;

public class RdsInstanceSlaver {
    private Long instanceslaversrecordid;

    private Timestamp instancecreatetime;

    private Timestamp instancelastupdatetime;

    private Long instanceslaverid;

    private Long instanceslaverbelonger;

    public Long getInstanceslaversrecordid() {
        return instanceslaversrecordid;
    }

    public void setInstanceslaversrecordid(Long instanceslaversrecordid) {
        this.instanceslaversrecordid = instanceslaversrecordid;
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

    public Long getInstanceslaverid() {
        return instanceslaverid;
    }

    public void setInstanceslaverid(Long instanceslaverid) {
        this.instanceslaverid = instanceslaverid;
    }

    public Long getInstanceslaverbelonger() {
        return instanceslaverbelonger;
    }

    public void setInstanceslaverbelonger(Long instanceslaverbelonger) {
        this.instanceslaverbelonger = instanceslaverbelonger;
    }
}