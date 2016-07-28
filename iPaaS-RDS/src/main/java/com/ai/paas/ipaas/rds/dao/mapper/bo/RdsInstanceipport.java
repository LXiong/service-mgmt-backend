package com.ai.paas.ipaas.rds.dao.mapper.bo;

import java.sql.Timestamp;

public class RdsInstanceipport {
    private Long instanceipportid;

    private Timestamp instancecreatetime;

    private String instanceip;

    private Timestamp instancelastupdatetime;

    private String instanceurl;

    private Integer port;

    private Long instanceipportbelonger;

    public Long getInstanceipportid() {
        return instanceipportid;
    }

    public void setInstanceipportid(Long instanceipportid) {
        this.instanceipportid = instanceipportid;
    }

    public Timestamp getInstancecreatetime() {
        return instancecreatetime;
    }

    public void setInstancecreatetime(Timestamp instancecreatetime) {
        this.instancecreatetime = instancecreatetime;
    }

    public String getInstanceip() {
        return instanceip;
    }

    public void setInstanceip(String instanceip) {
        this.instanceip = instanceip == null ? null : instanceip.trim();
    }

    public Timestamp getInstancelastupdatetime() {
        return instancelastupdatetime;
    }

    public void setInstancelastupdatetime(Timestamp instancelastupdatetime) {
        this.instancelastupdatetime = instancelastupdatetime;
    }

    public String getInstanceurl() {
        return instanceurl;
    }

    public void setInstanceurl(String instanceurl) {
        this.instanceurl = instanceurl == null ? null : instanceurl.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Long getInstanceipportbelonger() {
        return instanceipportbelonger;
    }

    public void setInstanceipportbelonger(Long instanceipportbelonger) {
        this.instanceipportbelonger = instanceipportbelonger;
    }
}