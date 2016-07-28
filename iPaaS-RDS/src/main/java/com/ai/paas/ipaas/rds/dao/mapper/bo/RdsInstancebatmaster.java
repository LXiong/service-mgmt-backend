package com.ai.paas.ipaas.rds.dao.mapper.bo;

import java.sql.Timestamp;

public class RdsInstancebatmaster {
    private Long instancebatmasterrecordid;

    private Timestamp instancecreatetime;

    private Timestamp instancelastupdatetime;

    private Long instancebatmasterid;

    private Long instancebatmasterbelonger;

    public Long getInstancebatmasterrecordid() {
        return instancebatmasterrecordid;
    }

    public void setInstancebatmasterrecordid(Long instancebatmasterrecordid) {
        this.instancebatmasterrecordid = instancebatmasterrecordid;
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

    public Long getInstancebatmasterid() {
        return instancebatmasterid;
    }

    public void setInstancebatmasterid(Long instancebatmasterid) {
        this.instancebatmasterid = instancebatmasterid;
    }

    public Long getInstancebatmasterbelonger() {
        return instancebatmasterbelonger;
    }

    public void setInstancebatmasterbelonger(Long instancebatmasterbelonger) {
        this.instancebatmasterbelonger = instancebatmasterbelonger;
    }
}