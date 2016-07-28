package com.ai.paas.ipaas.rds.dao.wo;

import java.util.List;

import com.ai.paas.ipaas.ServiceUtil;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsInstanceBaseconfigMapper;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsInstanceRootaccountMapper;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsInstanceSlaverMapper;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsInstanceSpaceinfoMapper;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsInstanceStatusMapper;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsInstancebatmasterMapper;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsInstanceipportMapper;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceBase;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceBaseconfig;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceBaseconfigCriteria;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceRootaccount;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceRootaccountCriteria;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceSlaver;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceSlaverCriteria;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceSpaceinfo;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceSpaceinfoCriteria;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceStatus;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceStatusCriteria;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstancebatmaster;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstancebatmasterCriteria;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceipport;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceipportCriteria;

public class InstanceBase {

	private RdsInstanceBase rdsInstanceBase;
	private RdsInstanceipport rdsInstanceipport;
	private RdsInstanceStatus rdsInstanceStatus;
	private RdsInstanceBaseconfig RdsInstanceBaseConfig;
	private RdsInstanceSpaceinfo RdsInstanceSpaceInfo;
	private RdsInstanceRootaccount rdsInstanceRootAccount;
	private List<RdsInstanceSlaver> rdsInstanceSlaverList;
	private RdsInstancebatmaster rdsInstanceBatMaster;

	// rdsInstanceBase有值，通过数据库将子表信息查询得到完整obj
	public InstanceBase getCompleteInstanceBase() {
		RdsInstanceipportMapper instanceIpPortMapper = ServiceUtil.getMapper(RdsInstanceipportMapper.class);
		RdsInstanceipportCriteria instanceIpPortCriteria = new RdsInstanceipportCriteria();
		instanceIpPortCriteria.createCriteria().andInstanceipportbelongerEqualTo(this.rdsInstanceBase.getInstanceid());
		List<RdsInstanceipport> RdsInstanceipportList = instanceIpPortMapper.selectByExample(instanceIpPortCriteria);
		if (null != RdsInstanceipportList) {
			this.rdsInstanceipport = RdsInstanceipportList.get(0);
		}

		RdsInstanceStatusMapper instanceStatusMapper = ServiceUtil.getMapper(RdsInstanceStatusMapper.class);
		RdsInstanceStatusCriteria instanceStatusCriteria = new RdsInstanceStatusCriteria();
		instanceStatusCriteria.createCriteria().andInstancestatusbelongerEqualTo(this.rdsInstanceBase.getInstanceid());
		List<RdsInstanceStatus> rdsInstanceStatusList = instanceStatusMapper.selectByExample(instanceStatusCriteria);
		if (null != rdsInstanceStatusList) {
			this.rdsInstanceStatus = rdsInstanceStatusList.get(0);
		}

		RdsInstanceBaseconfigMapper instanceBaseconfigMapper = ServiceUtil.getMapper(RdsInstanceBaseconfigMapper.class);
		RdsInstanceBaseconfigCriteria instanceBaseconfigCriteria = new RdsInstanceBaseconfigCriteria();
		instanceBaseconfigCriteria.createCriteria()
				.andInstancebaseconfigbelongerEqualTo(this.rdsInstanceBase.getInstanceid());
		List<RdsInstanceBaseconfig> instanceBaseconfigList = instanceBaseconfigMapper
				.selectByExample(instanceBaseconfigCriteria);
		if (null != instanceBaseconfigList) {
			this.RdsInstanceBaseConfig = instanceBaseconfigList.get(0);
		}

		RdsInstanceSpaceinfoMapper instanceSpaceinfoMapper = ServiceUtil.getMapper(RdsInstanceSpaceinfoMapper.class);
		RdsInstanceSpaceinfoCriteria instanceSpaceinfoCriteria = ServiceUtil
				.getMapper(RdsInstanceSpaceinfoCriteria.class);
		instanceSpaceinfoCriteria.createCriteria()
				.andInstancespaceinfobelongerEqualTo(this.rdsInstanceBase.getInstanceid());
		List<RdsInstanceSpaceinfo> instanceSpaceInfoList = instanceSpaceinfoMapper
				.selectByExample(instanceSpaceinfoCriteria);
		if (null != instanceSpaceInfoList) {
			this.RdsInstanceSpaceInfo = instanceSpaceInfoList.get(0);
		}

		RdsInstanceRootaccountMapper instanceRootAccountMapper = ServiceUtil
				.getMapper(RdsInstanceRootaccountMapper.class);
		RdsInstanceRootaccountCriteria instanceRootAccountCriteria = new RdsInstanceRootaccountCriteria();
		instanceRootAccountCriteria.createCriteria()
				.andInstancerootaccountbelongerEqualTo(this.rdsInstanceBase.getInstanceid());
		List<RdsInstanceRootaccount> rootaccList = instanceRootAccountMapper
				.selectByExample(instanceRootAccountCriteria);
		if (null != rootaccList) {
			this.rdsInstanceRootAccount = rootaccList.get(0);
		}

		RdsInstanceSlaverMapper instanceSlaverMapper = ServiceUtil.getMapper(RdsInstanceSlaverMapper.class);
		RdsInstanceSlaverCriteria instanceSlaverCriteria = new RdsInstanceSlaverCriteria();
		instanceSlaverCriteria.createCriteria().andInstanceslaverbelongerEqualTo(this.rdsInstanceBase.getInstanceid());
		List<RdsInstanceSlaver> RdsInstanceSlaverList = instanceSlaverMapper.selectByExample(instanceSlaverCriteria);
		this.rdsInstanceSlaverList = RdsInstanceSlaverList;

		RdsInstancebatmasterMapper instancebatmasterMapper = ServiceUtil.getMapper(RdsInstancebatmasterMapper.class);
		RdsInstancebatmasterCriteria instancebatmasterCriteria = new RdsInstancebatmasterCriteria();
		instancebatmasterCriteria.createCriteria()
				.andInstancebatmasterbelongerEqualTo(this.rdsInstanceBase.getInstanceid());
		List<RdsInstancebatmaster> instanceBatMasterList = instancebatmasterMapper
				.selectByExample(instancebatmasterCriteria);
		if (null != instanceBatMasterList) {
			this.rdsInstanceBatMaster = instanceBatMasterList.get(0);
		}

		return this;
	}

	// 通过传入RdsInstanceBase查询数据库获取完整obj
	public InstanceBase getCompleteInstanceBase(RdsInstanceBase rdsInstanceBase) {
		RdsInstanceipportMapper instanceIpPortMapper = ServiceUtil.getMapper(RdsInstanceipportMapper.class);
		RdsInstanceipportCriteria instanceIpPortCriteria = new RdsInstanceipportCriteria();
		instanceIpPortCriteria.createCriteria().andInstanceipportbelongerEqualTo(rdsInstanceBase.getInstanceid());
		List<RdsInstanceipport> RdsInstanceipportList = instanceIpPortMapper.selectByExample(instanceIpPortCriteria);
		if (null != RdsInstanceipportList) {
			this.rdsInstanceipport = RdsInstanceipportList.get(0);
		}

		RdsInstanceStatusMapper instanceStatusMapper = ServiceUtil.getMapper(RdsInstanceStatusMapper.class);
		RdsInstanceStatusCriteria instanceStatusCriteria = new RdsInstanceStatusCriteria();
		instanceStatusCriteria.createCriteria().andInstancestatusbelongerEqualTo(rdsInstanceBase.getInstanceid());
		List<RdsInstanceStatus> rdsInstanceStatusList = instanceStatusMapper.selectByExample(instanceStatusCriteria);
		if (null != rdsInstanceStatusList) {
			this.rdsInstanceStatus = rdsInstanceStatusList.get(0);
		}

		RdsInstanceBaseconfigMapper instanceBaseconfigMapper = ServiceUtil.getMapper(RdsInstanceBaseconfigMapper.class);
		RdsInstanceBaseconfigCriteria instanceBaseconfigCriteria = new RdsInstanceBaseconfigCriteria();
		instanceBaseconfigCriteria.createCriteria()
				.andInstancebaseconfigbelongerEqualTo(rdsInstanceBase.getInstanceid());
		List<RdsInstanceBaseconfig> instanceBaseconfigList = instanceBaseconfigMapper
				.selectByExample(instanceBaseconfigCriteria);
		if (null != instanceBaseconfigList) {
			this.RdsInstanceBaseConfig = instanceBaseconfigList.get(0);
		}

		RdsInstanceSpaceinfoMapper instanceSpaceinfoMapper = ServiceUtil.getMapper(RdsInstanceSpaceinfoMapper.class);
		RdsInstanceSpaceinfoCriteria instanceSpaceinfoCriteria = ServiceUtil
				.getMapper(RdsInstanceSpaceinfoCriteria.class);
		instanceSpaceinfoCriteria.createCriteria().andInstancespaceinfobelongerEqualTo(rdsInstanceBase.getInstanceid());
		List<RdsInstanceSpaceinfo> instanceSpaceInfoList = instanceSpaceinfoMapper
				.selectByExample(instanceSpaceinfoCriteria);
		if (null != instanceSpaceInfoList) {
			this.RdsInstanceSpaceInfo = instanceSpaceInfoList.get(0);
		}

		RdsInstanceRootaccountMapper instanceRootAccountMapper = ServiceUtil
				.getMapper(RdsInstanceRootaccountMapper.class);
		RdsInstanceRootaccountCriteria instanceRootAccountCriteria = new RdsInstanceRootaccountCriteria();
		instanceRootAccountCriteria.createCriteria()
				.andInstancerootaccountbelongerEqualTo(rdsInstanceBase.getInstanceid());
		List<RdsInstanceRootaccount> rootaccList = instanceRootAccountMapper
				.selectByExample(instanceRootAccountCriteria);
		if (null != rootaccList) {
			this.rdsInstanceRootAccount = rootaccList.get(0);
		}

		RdsInstanceSlaverMapper instanceSlaverMapper = ServiceUtil.getMapper(RdsInstanceSlaverMapper.class);
		RdsInstanceSlaverCriteria instanceSlaverCriteria = new RdsInstanceSlaverCriteria();
		instanceSlaverCriteria.createCriteria().andInstanceslaverbelongerEqualTo(rdsInstanceBase.getInstanceid());
		List<RdsInstanceSlaver> RdsInstanceSlaverList = instanceSlaverMapper.selectByExample(instanceSlaverCriteria);
		this.rdsInstanceSlaverList = RdsInstanceSlaverList;

		RdsInstancebatmasterMapper instancebatmasterMapper = ServiceUtil.getMapper(RdsInstancebatmasterMapper.class);
		RdsInstancebatmasterCriteria instancebatmasterCriteria = new RdsInstancebatmasterCriteria();
		instancebatmasterCriteria.createCriteria().andInstancebatmasterbelongerEqualTo(rdsInstanceBase.getInstanceid());
		List<RdsInstancebatmaster> instanceBatMasterList = instancebatmasterMapper
				.selectByExample(instancebatmasterCriteria);
		if (null != instanceBatMasterList) {
			this.rdsInstanceBatMaster = instanceBatMasterList.get(0);
		}

		return this;
	}

	public InstanceBase getCompleteInstanceBase(Long rdsInstanceBaseID) {
		RdsInstanceipportMapper instanceIpPortMapper = ServiceUtil.getMapper(RdsInstanceipportMapper.class);
		RdsInstanceipportCriteria instanceIpPortCriteria = new RdsInstanceipportCriteria();
		instanceIpPortCriteria.createCriteria().andInstanceipportbelongerEqualTo(rdsInstanceBaseID);
		List<RdsInstanceipport> RdsInstanceipportList = instanceIpPortMapper.selectByExample(instanceIpPortCriteria);
		if (null != RdsInstanceipportList) {
			this.rdsInstanceipport = RdsInstanceipportList.get(0);
		}

		RdsInstanceStatusMapper instanceStatusMapper = ServiceUtil.getMapper(RdsInstanceStatusMapper.class);
		RdsInstanceStatusCriteria instanceStatusCriteria = new RdsInstanceStatusCriteria();
		instanceStatusCriteria.createCriteria().andInstancestatusbelongerEqualTo(rdsInstanceBaseID);
		List<RdsInstanceStatus> rdsInstanceStatusList = instanceStatusMapper.selectByExample(instanceStatusCriteria);
		if (null != rdsInstanceStatusList) {
			this.rdsInstanceStatus = rdsInstanceStatusList.get(0);
		}

		RdsInstanceBaseconfigMapper instanceBaseconfigMapper = ServiceUtil.getMapper(RdsInstanceBaseconfigMapper.class);
		RdsInstanceBaseconfigCriteria instanceBaseconfigCriteria = new RdsInstanceBaseconfigCriteria();
		instanceBaseconfigCriteria.createCriteria().andInstancebaseconfigbelongerEqualTo(rdsInstanceBaseID);
		List<RdsInstanceBaseconfig> instanceBaseconfigList = instanceBaseconfigMapper
				.selectByExample(instanceBaseconfigCriteria);
		if (null != instanceBaseconfigList) {
			this.RdsInstanceBaseConfig = instanceBaseconfigList.get(0);
		}

		RdsInstanceSpaceinfoMapper instanceSpaceinfoMapper = ServiceUtil.getMapper(RdsInstanceSpaceinfoMapper.class);
		RdsInstanceSpaceinfoCriteria instanceSpaceinfoCriteria = ServiceUtil
				.getMapper(RdsInstanceSpaceinfoCriteria.class);
		instanceSpaceinfoCriteria.createCriteria().andInstancespaceinfobelongerEqualTo(rdsInstanceBaseID);
		List<RdsInstanceSpaceinfo> instanceSpaceInfoList = instanceSpaceinfoMapper
				.selectByExample(instanceSpaceinfoCriteria);
		if (null != instanceSpaceInfoList) {
			this.RdsInstanceSpaceInfo = instanceSpaceInfoList.get(0);
		}

		RdsInstanceRootaccountMapper instanceRootAccountMapper = ServiceUtil
				.getMapper(RdsInstanceRootaccountMapper.class);
		RdsInstanceRootaccountCriteria instanceRootAccountCriteria = new RdsInstanceRootaccountCriteria();
		instanceRootAccountCriteria.createCriteria().andInstancerootaccountbelongerEqualTo(rdsInstanceBaseID);
		List<RdsInstanceRootaccount> rootaccList = instanceRootAccountMapper
				.selectByExample(instanceRootAccountCriteria);
		if (null != rootaccList) {
			this.rdsInstanceRootAccount = rootaccList.get(0);
		}

		RdsInstanceSlaverMapper instanceSlaverMapper = ServiceUtil.getMapper(RdsInstanceSlaverMapper.class);
		RdsInstanceSlaverCriteria instanceSlaverCriteria = new RdsInstanceSlaverCriteria();
		instanceSlaverCriteria.createCriteria().andInstanceslaverbelongerEqualTo(rdsInstanceBaseID);
		List<RdsInstanceSlaver> RdsInstanceSlaverList = instanceSlaverMapper.selectByExample(instanceSlaverCriteria);
		this.rdsInstanceSlaverList = RdsInstanceSlaverList;

		RdsInstancebatmasterMapper instancebatmasterMapper = ServiceUtil.getMapper(RdsInstancebatmasterMapper.class);
		RdsInstancebatmasterCriteria instancebatmasterCriteria = new RdsInstancebatmasterCriteria();
		instancebatmasterCriteria.createCriteria().andInstancebatmasterbelongerEqualTo(rdsInstanceBaseID);
		List<RdsInstancebatmaster> instanceBatMasterList = instancebatmasterMapper
				.selectByExample(instancebatmasterCriteria);
		if (null != instanceBatMasterList) {
			this.rdsInstanceBatMaster = instanceBatMasterList.get(0);
		}

		return this;
	}

	public boolean insertCompleteInstanceBase() {
		if (null == rdsInstanceBase || null == rdsInstanceipport || null == rdsInstanceStatus
				|| null == RdsInstanceBaseConfig || null == RdsInstanceSpaceInfo || null == rdsInstanceRootAccount) {
			return false;
		}

		RdsInstanceipportMapper instanceIpPortMapper = ServiceUtil.getMapper(RdsInstanceipportMapper.class);
		RdsInstanceStatusMapper instanceStatusMapper = ServiceUtil.getMapper(RdsInstanceStatusMapper.class);
		RdsInstanceBaseconfigMapper instanceBaseconfigMapper = ServiceUtil.getMapper(RdsInstanceBaseconfigMapper.class);
		RdsInstanceSpaceinfoMapper instanceSpaceinfoMapper = ServiceUtil.getMapper(RdsInstanceSpaceinfoMapper.class);
		RdsInstanceRootaccountMapper instanceRootAccountMapper = ServiceUtil
				.getMapper(RdsInstanceRootaccountMapper.class);

		instanceIpPortMapper.insertSelective(rdsInstanceipport);
		instanceStatusMapper.insertSelective(rdsInstanceStatus);
		instanceBaseconfigMapper.insertSelective(RdsInstanceBaseConfig);
		instanceSpaceinfoMapper.insertSelective(RdsInstanceSpaceInfo);
		instanceRootAccountMapper.insertSelective(rdsInstanceRootAccount);

		if (null != rdsInstanceSlaverList) {
			RdsInstanceSlaverMapper instanceSlaverMapper = ServiceUtil.getMapper(RdsInstanceSlaverMapper.class);
			for (RdsInstanceSlaver is : rdsInstanceSlaverList) {
				instanceSlaverMapper.insertSelective(is);
			}
		}
		if (null != rdsInstanceBatMaster) {
			RdsInstancebatmasterMapper instancebatmasterMapper = ServiceUtil
					.getMapper(RdsInstancebatmasterMapper.class);
			instancebatmasterMapper.insertSelective(rdsInstanceBatMaster);
		}

		return true;

	}
}
