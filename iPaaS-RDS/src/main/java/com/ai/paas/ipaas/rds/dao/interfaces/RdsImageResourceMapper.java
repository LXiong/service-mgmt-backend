package com.ai.paas.ipaas.rds.dao.interfaces;

import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsImageResource;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsImageResourceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RdsImageResourceMapper {
    int countByExample(RdsImageResourceCriteria example);

    int deleteByExample(RdsImageResourceCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(RdsImageResource record);

    int insertSelective(RdsImageResource record);

    List<RdsImageResource> selectByExample(RdsImageResourceCriteria example);

    RdsImageResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RdsImageResource record, @Param("example") RdsImageResourceCriteria example);

    int updateByExample(@Param("record") RdsImageResource record, @Param("example") RdsImageResourceCriteria example);

    int updateByPrimaryKeySelective(RdsImageResource record);

    int updateByPrimaryKey(RdsImageResource record);
}