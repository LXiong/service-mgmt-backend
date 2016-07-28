package com.ai.paas.ipaas.rds.dao.interfaces;

import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceStatus;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceStatusCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RdsInstanceStatusMapper {
    int countByExample(RdsInstanceStatusCriteria example);

    int deleteByExample(RdsInstanceStatusCriteria example);

    int deleteByPrimaryKey(Long instancestatusid);

    int insert(RdsInstanceStatus record);

    int insertSelective(RdsInstanceStatus record);

    List<RdsInstanceStatus> selectByExample(RdsInstanceStatusCriteria example);

    RdsInstanceStatus selectByPrimaryKey(Long instancestatusid);

    int updateByExampleSelective(@Param("record") RdsInstanceStatus record, @Param("example") RdsInstanceStatusCriteria example);

    int updateByExample(@Param("record") RdsInstanceStatus record, @Param("example") RdsInstanceStatusCriteria example);

    int updateByPrimaryKeySelective(RdsInstanceStatus record);

    int updateByPrimaryKey(RdsInstanceStatus record);
}