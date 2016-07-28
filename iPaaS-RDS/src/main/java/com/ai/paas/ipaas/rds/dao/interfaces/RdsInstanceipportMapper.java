package com.ai.paas.ipaas.rds.dao.interfaces;

import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceipport;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceipportCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RdsInstanceipportMapper {
    int countByExample(RdsInstanceipportCriteria example);

    int deleteByExample(RdsInstanceipportCriteria example);

    int deleteByPrimaryKey(Long instanceipportid);

    int insert(RdsInstanceipport record);

    int insertSelective(RdsInstanceipport record);

    List<RdsInstanceipport> selectByExample(RdsInstanceipportCriteria example);

    RdsInstanceipport selectByPrimaryKey(Long instanceipportid);

    int updateByExampleSelective(@Param("record") RdsInstanceipport record, @Param("example") RdsInstanceipportCriteria example);

    int updateByExample(@Param("record") RdsInstanceipport record, @Param("example") RdsInstanceipportCriteria example);

    int updateByPrimaryKeySelective(RdsInstanceipport record);

    int updateByPrimaryKey(RdsInstanceipport record);
}