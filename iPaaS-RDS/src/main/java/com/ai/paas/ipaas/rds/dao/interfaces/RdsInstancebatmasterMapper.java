package com.ai.paas.ipaas.rds.dao.interfaces;

import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstancebatmaster;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstancebatmasterCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RdsInstancebatmasterMapper {
    int countByExample(RdsInstancebatmasterCriteria example);

    int deleteByExample(RdsInstancebatmasterCriteria example);

    int deleteByPrimaryKey(Long instancebatmasterrecordid);

    int insert(RdsInstancebatmaster record);

    int insertSelective(RdsInstancebatmaster record);

    List<RdsInstancebatmaster> selectByExample(RdsInstancebatmasterCriteria example);

    RdsInstancebatmaster selectByPrimaryKey(Long instancebatmasterrecordid);

    int updateByExampleSelective(@Param("record") RdsInstancebatmaster record, @Param("example") RdsInstancebatmasterCriteria example);

    int updateByExample(@Param("record") RdsInstancebatmaster record, @Param("example") RdsInstancebatmasterCriteria example);

    int updateByPrimaryKeySelective(RdsInstancebatmaster record);

    int updateByPrimaryKey(RdsInstancebatmaster record);
}