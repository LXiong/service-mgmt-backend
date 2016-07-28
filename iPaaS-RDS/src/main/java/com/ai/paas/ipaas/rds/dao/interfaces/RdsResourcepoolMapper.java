package com.ai.paas.ipaas.rds.dao.interfaces;

import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsResourcepool;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsResourcepoolCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RdsResourcepoolMapper {
    int countByExample(RdsResourcepoolCriteria example);

    int deleteByExample(RdsResourcepoolCriteria example);

    int deleteByPrimaryKey(Long resourceid);

    int insert(RdsResourcepool record);

    int insertSelective(RdsResourcepool record);

    List<RdsResourcepool> selectByExample(RdsResourcepoolCriteria example);

    RdsResourcepool selectByPrimaryKey(Long resourceid);

    int updateByExampleSelective(@Param("record") RdsResourcepool record, @Param("example") RdsResourcepoolCriteria example);

    int updateByExample(@Param("record") RdsResourcepool record, @Param("example") RdsResourcepoolCriteria example);

    int updateByPrimaryKeySelective(RdsResourcepool record);

    int updateByPrimaryKey(RdsResourcepool record);
}