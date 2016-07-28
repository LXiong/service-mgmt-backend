package com.ai.paas.ipaas.rds.dao.mapper.bo;

import java.sql.Timestamp;

public class RdsInstanceSpaceinfo {
    private Long instancespaceinfoid;

    private String cpu;

    private String dbversion;

    private Double externalstorage;

    private Timestamp instancecreatetime;

    private Timestamp instancelastupdatetime;

    private Double internalstorage;

    private Integer maxconnectnumber;

    private String maxiops;

    private Double usedexternalstorage;

    private Double usedinternalstorage;

    private Long instancespaceinfobelonger;

    public Long getInstancespaceinfoid() {
        return instancespaceinfoid;
    }

    public void setInstancespaceinfoid(Long instancespaceinfoid) {
        this.instancespaceinfoid = instancespaceinfoid;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu == null ? null : cpu.trim();
    }

    public String getDbversion() {
        return dbversion;
    }

    public void setDbversion(String dbversion) {
        this.dbversion = dbversion == null ? null : dbversion.trim();
    }

    public Double getExternalstorage() {
        return externalstorage;
    }

    public void setExternalstorage(Double externalstorage) {
        this.externalstorage = externalstorage;
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

    public Double getInternalstorage() {
        return internalstorage;
    }

    public void setInternalstorage(Double internalstorage) {
        this.internalstorage = internalstorage;
    }

    public Integer getMaxconnectnumber() {
        return maxconnectnumber;
    }

    public void setMaxconnectnumber(Integer maxconnectnumber) {
        this.maxconnectnumber = maxconnectnumber;
    }

    public String getMaxiops() {
        return maxiops;
    }

    public void setMaxiops(String maxiops) {
        this.maxiops = maxiops == null ? null : maxiops.trim();
    }

    public Double getUsedexternalstorage() {
        return usedexternalstorage;
    }

    public void setUsedexternalstorage(Double usedexternalstorage) {
        this.usedexternalstorage = usedexternalstorage;
    }

    public Double getUsedinternalstorage() {
        return usedinternalstorage;
    }

    public void setUsedinternalstorage(Double usedinternalstorage) {
        this.usedinternalstorage = usedinternalstorage;
    }

    public Long getInstancespaceinfobelonger() {
        return instancespaceinfobelonger;
    }

    public void setInstancespaceinfobelonger(Long instancespaceinfobelonger) {
        this.instancespaceinfobelonger = instancespaceinfobelonger;
    }
}