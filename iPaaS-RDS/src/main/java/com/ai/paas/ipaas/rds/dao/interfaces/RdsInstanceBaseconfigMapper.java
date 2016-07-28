package com.ai.paas.ipaas.rds.dao.interfaces;

import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceBaseconfig;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceBaseconfigCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RdsInstanceBaseconfigMapper {
    int countByExample(RdsInstanceBaseconfigCriteria example);

    int deleteByExample(RdsInstanceBaseconfigCriteria example);

    int deleteByPrimaryKey(Long instancebaseconfigid);

    int insert(RdsInstanceBaseconfig record);

    int insertSelective(RdsInstanceBaseconfig record);

    List<RdsInstanceBaseconfig> selectByExample(RdsInstanceBaseconfigCriteria example);

    RdsInstanceBaseconfig selectByPrimaryKey(Long instancebaseconfigid);

    int updateByExampleSelective(@Param("record") RdsInstanceBaseconfig record, @Param("example") RdsInstanceBaseconfigCriteria example);

    int updateByExample(@Param("record") RdsInstanceBaseconfig record, @Param("example") RdsInstanceBaseconfigCriteria example);

    int updateByPrimaryKeySelective(RdsInstanceBaseconfig record);

    int updateByPrimaryKey(RdsInstanceBaseconfig record);
}