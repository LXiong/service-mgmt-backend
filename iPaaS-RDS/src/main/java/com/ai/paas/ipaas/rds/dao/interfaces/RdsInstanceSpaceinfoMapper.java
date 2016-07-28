package com.ai.paas.ipaas.rds.dao.interfaces;

import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceSpaceinfo;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceSpaceinfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RdsInstanceSpaceinfoMapper {
    int countByExample(RdsInstanceSpaceinfoCriteria example);

    int deleteByExample(RdsInstanceSpaceinfoCriteria example);

    int deleteByPrimaryKey(Long instancespaceinfoid);

    int insert(RdsInstanceSpaceinfo record);

    int insertSelective(RdsInstanceSpaceinfo record);

    List<RdsInstanceSpaceinfo> selectByExample(RdsInstanceSpaceinfoCriteria example);

    RdsInstanceSpaceinfo selectByPrimaryKey(Long instancespaceinfoid);

    int updateByExampleSelective(@Param("record") RdsInstanceSpaceinfo record, @Param("example") RdsInstanceSpaceinfoCriteria example);

    int updateByExample(@Param("record") RdsInstanceSpaceinfo record, @Param("example") RdsInstanceSpaceinfoCriteria example);

    int updateByPrimaryKeySelective(RdsInstanceSpaceinfo record);

    int updateByPrimaryKey(RdsInstanceSpaceinfo record);
}