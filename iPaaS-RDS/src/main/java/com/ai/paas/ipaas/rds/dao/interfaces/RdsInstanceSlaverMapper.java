package com.ai.paas.ipaas.rds.dao.interfaces;

import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceSlaver;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceSlaverCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RdsInstanceSlaverMapper {
    int countByExample(RdsInstanceSlaverCriteria example);

    int deleteByExample(RdsInstanceSlaverCriteria example);

    int deleteByPrimaryKey(Long instanceslaversrecordid);

    int insert(RdsInstanceSlaver record);

    int insertSelective(RdsInstanceSlaver record);

    List<RdsInstanceSlaver> selectByExample(RdsInstanceSlaverCriteria example);

    RdsInstanceSlaver selectByPrimaryKey(Long instanceslaversrecordid);

    int updateByExampleSelective(@Param("record") RdsInstanceSlaver record, @Param("example") RdsInstanceSlaverCriteria example);

    int updateByExample(@Param("record") RdsInstanceSlaver record, @Param("example") RdsInstanceSlaverCriteria example);

    int updateByPrimaryKeySelective(RdsInstanceSlaver record);

    int updateByPrimaryKey(RdsInstanceSlaver record);
}