package com.ai.paas.ipaas.rds.dao.mapper.bo;

import java.sql.Timestamp;

public class RdsInstanceBaseconfig {
    private Long instancebaseconfigid;

    private Timestamp instancecreatetime;

    private String instancedatapath;

    private String instancehomepath;

    private Timestamp instancelastupdatetime;

    private String ipwhitelist;

    private Long instancebaseconfigbelonger;

    public Long getInstancebaseconfigid() {
        return instancebaseconfigid;
    }

    public void setInstancebaseconfigid(Long instancebaseconfigid) {
        this.instancebaseconfigid = instancebaseconfigid;
    }

    public Timestamp getInstancecreatetime() {
        return instancecreatetime;
    }

    public void setInstancecreatetime(Timestamp instancecreatetime) {
        this.instancecreatetime = instancecreatetime;
    }

    public String getInstancedatapath() {
        return instancedatapath;
    }

    public void setInstancedatapath(String instancedatapath) {
        this.instancedatapath = instancedatapath == null ? null : instancedatapath.trim();
    }

    public String getInstancehomepath() {
        return instancehomepath;
    }

    public void setInstancehomepath(String instancehomepath) {
        this.instancehomepath = instancehomepath == null ? null : instancehomepath.trim();
    }

    public Timestamp getInstancelastupdatetime() {
        return instancelastupdatetime;
    }

    public void setInstancelastupdatetime(Timestamp instancelastupdatetime) {
        this.instancelastupdatetime = instancelastupdatetime;
    }

    public String getIpwhitelist() {
        return ipwhitelist;
    }

    public void setIpwhitelist(String ipwhitelist) {
        this.ipwhitelist = ipwhitelist == null ? null : ipwhitelist.trim();
    }

    public Long getInstancebaseconfigbelonger() {
        return instancebaseconfigbelonger;
    }

    public void setInstancebaseconfigbelonger(Long instancebaseconfigbelonger) {
        this.instancebaseconfigbelonger = instancebaseconfigbelonger;
    }
}