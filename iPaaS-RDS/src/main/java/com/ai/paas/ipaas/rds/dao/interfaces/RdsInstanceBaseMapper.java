package com.ai.paas.ipaas.rds.dao.interfaces;

import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceBase;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceBaseCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RdsInstanceBaseMapper {
    int countByExample(RdsInstanceBaseCriteria example);

    int deleteByExample(RdsInstanceBaseCriteria example);

    int deleteByPrimaryKey(Long instanceid);

    int insert(RdsInstanceBase record);

    int insertSelective(RdsInstanceBase record);

    List<RdsInstanceBase> selectByExample(RdsInstanceBaseCriteria example);

    RdsInstanceBase selectByPrimaryKey(Long instanceid);

    int updateByExampleSelective(@Param("record") RdsInstanceBase record, @Param("example") RdsInstanceBaseCriteria example);

    int updateByExample(@Param("record") RdsInstanceBase record, @Param("example") RdsInstanceBaseCriteria example);

    int updateByPrimaryKeySelective(RdsInstanceBase record);

    int updateByPrimaryKey(RdsInstanceBase record);
}