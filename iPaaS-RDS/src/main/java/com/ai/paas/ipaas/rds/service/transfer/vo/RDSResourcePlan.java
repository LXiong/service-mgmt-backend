package com.ai.paas.ipaas.rds.service.transfer.vo;

import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceStatus;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceipport;
import com.ai.paas.ipaas.rds.dao.wo.ResourcePool;

/**  
 * 生成字段-RDSResourcePlan
 * instanceipport/
 * instanceresourcebelonger/
 * @author  作者 “WTF” E-mail: 1031248990@qq.com
 * @date 创建时间：2016年7月12日 下午4:33:11 
 * @version 
 * @since  
 */
public class RDSResourcePlan {

	public ResourcePool instanceresourcebelonger;
	public RdsInstanceipport instanceIpPort;
	public RdsInstanceStatus instanceStatus;
}
