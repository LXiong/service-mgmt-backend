package com.ai.paas.ipaas.rds.dao.mapper.bo;

import java.sql.Timestamp;

public class RdsResourcepool {
    private Long resourceid;

    private Integer currentport;

    private Integer cycle;

    private String hostip;

    private Timestamp instancecreatetime;

    private Timestamp instancelastupdatetime;

    private Integer maxport;

    private Integer minport;

    private Integer sshpassword;

    private Integer sshuser;

    private Integer status;

    private Integer totalmemory;

    private Integer usedmemory;

    public Long getResourceid() {
        return resourceid;
    }

    public void setResourceid(Long resourceid) {
        this.resourceid = resourceid;
    }

    public Integer getCurrentport() {
        return currentport;
    }

    public void setCurrentport(Integer currentport) {
        this.currentport = currentport;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public String getHostip() {
        return hostip;
    }

    public void setHostip(String hostip) {
        this.hostip = hostip == null ? null : hostip.trim();
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

    public Integer getMaxport() {
        return maxport;
    }

    public void setMaxport(Integer maxport) {
        this.maxport = maxport;
    }

    public Integer getMinport() {
        return minport;
    }

    public void setMinport(Integer minport) {
        this.minport = minport;
    }

    public Integer getSshpassword() {
        return sshpassword;
    }

    public void setSshpassword(Integer sshpassword) {
        this.sshpassword = sshpassword;
    }

    public Integer getSshuser() {
        return sshuser;
    }

    public void setSshuser(Integer sshuser) {
        this.sshuser = sshuser;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTotalmemory() {
        return totalmemory;
    }

    public void setTotalmemory(Integer totalmemory) {
        this.totalmemory = totalmemory;
    }

    public Integer getUsedmemory() {
        return usedmemory;
    }

    public void setUsedmemory(Integer usedmemory) {
        this.usedmemory = usedmemory;
    }
}