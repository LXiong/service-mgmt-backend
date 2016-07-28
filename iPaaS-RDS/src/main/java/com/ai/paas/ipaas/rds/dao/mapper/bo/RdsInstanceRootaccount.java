package com.ai.paas.ipaas.rds.dao.mapper.bo;

import java.sql.Timestamp;

public class RdsInstanceRootaccount {
    private Long instancerootaccountid;

    private Timestamp instancecreatetime;

    private Timestamp instancelastupdatetime;

    private String rootaccout;

    private String rootpassword;

    private Long instancerootaccountbelonger;

    public Long getInstancerootaccountid() {
        return instancerootaccountid;
    }

    public void setInstancerootaccountid(Long instancerootaccountid) {
        this.instancerootaccountid = instancerootaccountid;
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

    public String getRootaccout() {
        return rootaccout;
    }

    public void setRootaccout(String rootaccout) {
        this.rootaccout = rootaccout == null ? null : rootaccout.trim();
    }

    public String getRootpassword() {
        return rootpassword;
    }

    public void setRootpassword(String rootpassword) {
        this.rootpassword = rootpassword == null ? null : rootpassword.trim();
    }

    public Long getInstancerootaccountbelonger() {
        return instancerootaccountbelonger;
    }

    public void setInstancerootaccountbelonger(Long instancerootaccountbelonger) {
        this.instancerootaccountbelonger = instancerootaccountbelonger;
    }
}