package com.ai.paas.ipaas.rds.dao.interfaces;

import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceRootaccount;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceRootaccountCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RdsInstanceRootaccountMapper {
    int countByExample(RdsInstanceRootaccountCriteria example);

    int deleteByExample(RdsInstanceRootaccountCriteria example);

    int deleteByPrimaryKey(Long instancerootaccountid);

    int insert(RdsInstanceRootaccount record);

    int insertSelective(RdsInstanceRootaccount record);

    List<RdsInstanceRootaccount> selectByExample(RdsInstanceRootaccountCriteria example);

    RdsInstanceRootaccount selectByPrimaryKey(Long instancerootaccountid);

    int updateByExampleSelective(@Param("record") RdsInstanceRootaccount record, @Param("example") RdsInstanceRootaccountCriteria example);

    int updateByExample(@Param("record") RdsInstanceRootaccount record, @Param("example") RdsInstanceRootaccountCriteria example);

    int updateByPrimaryKeySelective(RdsInstanceRootaccount record);

    int updateByPrimaryKey(RdsInstanceRootaccount record);
}