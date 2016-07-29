package com.ai.paas.ipaas.rds.dao.wo;

import java.util.List;

import com.ai.paas.ipaas.ServiceUtil;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsImageResourceMapper;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsInstanceBaseMapper;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsInstanceBaseconfigMapper;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsInstanceRootaccountMapper;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsInstanceSlaverMapper;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsInstanceSpaceinfoMapper;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsInstanceStatusMapper;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsInstancebatmasterMapper;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsInstanceipportMapper;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsResourcepoolMapper;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsImageResource;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceBase;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceBaseCriteria;
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
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsResourcepool;

public class InstanceBase {

	private RdsInstanceBase rdsInstanceBase;
	private RdsInstanceipport rdsInstanceipport;
	private RdsInstanceStatus rdsInstanceStatus;
	private RdsInstanceBaseconfig rdsInstanceBaseConfig;
	private RdsInstanceSpaceinfo rdsInstanceSpaceInfo;
	private RdsInstanceRootaccount rdsInstanceRootAccount;
	private List<RdsInstanceSlaver> rdsInstanceSlaverList;
	private RdsInstancebatmaster rdsInstanceBatMaster;

	private RdsImageResource rdsImageResource;
	private RdsResourcepool rdsResourcepool;
	
	/**
	 * rdsInstanceBase有值，通过数据库将子表信息查询得到完整obj
	 */
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
			this.rdsInstanceBaseConfig = instanceBaseconfigList.get(0);
		}

		RdsInstanceSpaceinfoMapper instanceSpaceinfoMapper = ServiceUtil.getMapper(RdsInstanceSpaceinfoMapper.class);
		RdsInstanceSpaceinfoCriteria instanceSpaceinfoCriteria = ServiceUtil
				.getMapper(RdsInstanceSpaceinfoCriteria.class);
		instanceSpaceinfoCriteria.createCriteria()
				.andInstancespaceinfobelongerEqualTo(this.rdsInstanceBase.getInstanceid());
		List<RdsInstanceSpaceinfo> instanceSpaceInfoList = instanceSpaceinfoMapper
				.selectByExample(instanceSpaceinfoCriteria);
		if (null != instanceSpaceInfoList) {
			this.rdsInstanceSpaceInfo = instanceSpaceInfoList.get(0);
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

		if(this.rdsInstanceBase.getInstanceimagebelonger() > 0){
			RdsImageResourceMapper imageResMapper = ServiceUtil.getMapper(RdsImageResourceMapper.class);
			RdsImageResource image = imageResMapper.selectByPrimaryKey(this.rdsInstanceBase.getInstanceimagebelonger());
			this.rdsImageResource = image;
		}
		if(this.rdsInstanceBase.getInstanceresourcebelonger() > 0){
			RdsResourcepoolMapper ResPoolMapper = ServiceUtil.getMapper(RdsResourcepoolMapper.class);
			RdsResourcepool rdsPool = ResPoolMapper.selectByPrimaryKey(this.rdsInstanceBase.getInstanceresourcebelonger());
			this.rdsResourcepool = rdsPool;
		}
		
		return this;
	}

	/**
	 * 通过传入RdsInstanceBase查询数据库获取完整obj
	 * @param rdsInstanceBase
	 * @return
	 */
	public InstanceBase getCompleteInstanceBase(RdsInstanceBase rdsInstanceBase) {
		this.rdsInstanceBase = rdsInstanceBase;
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
			this.rdsInstanceBaseConfig = instanceBaseconfigList.get(0);
		}

		RdsInstanceSpaceinfoMapper instanceSpaceinfoMapper = ServiceUtil.getMapper(RdsInstanceSpaceinfoMapper.class);
		RdsInstanceSpaceinfoCriteria instanceSpaceinfoCriteria = ServiceUtil
				.getMapper(RdsInstanceSpaceinfoCriteria.class);
		instanceSpaceinfoCriteria.createCriteria().andInstancespaceinfobelongerEqualTo(rdsInstanceBase.getInstanceid());
		List<RdsInstanceSpaceinfo> instanceSpaceInfoList = instanceSpaceinfoMapper
				.selectByExample(instanceSpaceinfoCriteria);
		if (null != instanceSpaceInfoList) {
			this.rdsInstanceSpaceInfo = instanceSpaceInfoList.get(0);
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
		if(this.rdsInstanceBase.getInstanceimagebelonger() > 0){
			RdsImageResourceMapper imageResMapper = ServiceUtil.getMapper(RdsImageResourceMapper.class);
			RdsImageResource image = imageResMapper.selectByPrimaryKey(this.rdsInstanceBase.getInstanceimagebelonger());
			this.rdsImageResource = image;
		}
		if(this.rdsInstanceBase.getInstanceresourcebelonger() > 0){
			RdsResourcepoolMapper ResPoolMapper = ServiceUtil.getMapper(RdsResourcepoolMapper.class);
			RdsResourcepool rdsPool = ResPoolMapper.selectByPrimaryKey(this.rdsInstanceBase.getInstanceresourcebelonger());
			this.rdsResourcepool = rdsPool;
		}

		return this;
	}

	public InstanceBase getCompleteInstanceBase(Long rdsInstanceBaseID) {
		RdsInstanceBaseMapper ibm = ServiceUtil.getMapper(RdsInstanceBaseMapper.class);
		RdsInstanceBase rdsInstanceBase = ibm.selectByPrimaryKey(rdsInstanceBaseID);
		this.rdsInstanceBase = rdsInstanceBase;
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
			this.rdsInstanceBaseConfig = instanceBaseconfigList.get(0);
		}

		RdsInstanceSpaceinfoMapper instanceSpaceinfoMapper = ServiceUtil.getMapper(RdsInstanceSpaceinfoMapper.class);
		RdsInstanceSpaceinfoCriteria instanceSpaceinfoCriteria = ServiceUtil
				.getMapper(RdsInstanceSpaceinfoCriteria.class);
		instanceSpaceinfoCriteria.createCriteria().andInstancespaceinfobelongerEqualTo(rdsInstanceBaseID);
		List<RdsInstanceSpaceinfo> instanceSpaceInfoList = instanceSpaceinfoMapper
				.selectByExample(instanceSpaceinfoCriteria);
		if (null != instanceSpaceInfoList) {
			this.rdsInstanceSpaceInfo = instanceSpaceInfoList.get(0);
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
		if(this.rdsInstanceBase.getInstanceimagebelonger() > 0){
			RdsImageResourceMapper imageResMapper = ServiceUtil.getMapper(RdsImageResourceMapper.class);
			RdsImageResource image = imageResMapper.selectByPrimaryKey(this.rdsInstanceBase.getInstanceimagebelonger());
			this.rdsImageResource = image;
		}
		if(this.rdsInstanceBase.getInstanceresourcebelonger() > 0){
			RdsResourcepoolMapper ResPoolMapper = ServiceUtil.getMapper(RdsResourcepoolMapper.class);
			RdsResourcepool rdsPool = ResPoolMapper.selectByPrimaryKey(this.rdsInstanceBase.getInstanceresourcebelonger());
			this.rdsResourcepool = rdsPool;
		}
		

		return this;
	}

	/**
	 * warning下策，只能把刚才存的通过多条件查一下
	 * 没有设置外键
	 * @return
	 */
	public InstanceBase insertCompleteInstanceBase() {
		if (null == rdsInstanceBase || null == rdsInstanceipport || null == rdsInstanceStatus
				|| null == rdsInstanceBaseConfig || null == rdsInstanceSpaceInfo || null == rdsInstanceRootAccount) {
			return null;
		}
		RdsInstanceBaseMapper instanceBaseMapper = ServiceUtil.getMapper(RdsInstanceBaseMapper.class);
		RdsInstanceipportMapper instanceIpPortMapper = ServiceUtil.getMapper(RdsInstanceipportMapper.class);
		RdsInstanceStatusMapper instanceStatusMapper = ServiceUtil.getMapper(RdsInstanceStatusMapper.class);
		RdsInstanceBaseconfigMapper instanceBaseconfigMapper = ServiceUtil.getMapper(RdsInstanceBaseconfigMapper.class);
		RdsInstanceSpaceinfoMapper instanceSpaceinfoMapper = ServiceUtil.getMapper(RdsInstanceSpaceinfoMapper.class);
		RdsInstanceRootaccountMapper instanceRootAccountMapper = ServiceUtil
				.getMapper(RdsInstanceRootaccountMapper.class);
		
		instanceBaseMapper.insertSelective(rdsInstanceBase);
		// warning下策，只能把刚才存的通过多条件查一下
		RdsInstanceBaseCriteria rdsIncBsCri = new RdsInstanceBaseCriteria();
		rdsIncBsCri.createCriteria().andInstancecreatetimeEqualTo(rdsInstanceBase.getInstancecreatetime())
			.andInstancenameEqualTo(rdsInstanceBase.getInstancename()).andUserIdEqualTo(rdsInstanceBase.getUserId());
		List<RdsInstanceBase> rdsIncBs = instanceBaseMapper.selectByExample(rdsIncBsCri);
		if(rdsIncBs.size() == 1){
			this.rdsInstanceBase = rdsIncBs.get(0);
			Long instanceid = this.rdsInstanceBase.getInstanceid();
			rdsInstanceipport.setInstanceipportbelonger(instanceid);
			rdsInstanceStatus.setInstancestatusbelonger(instanceid);
			rdsInstanceBaseConfig.setInstancebaseconfigbelonger(instanceid);
			rdsInstanceSpaceInfo.setInstancespaceinfobelonger(instanceid);
			rdsInstanceRootAccount.setInstancerootaccountbelonger(instanceid);
			
			instanceIpPortMapper.insertSelective(rdsInstanceipport);
			instanceStatusMapper.insertSelective(rdsInstanceStatus);
			instanceBaseconfigMapper.insertSelective(rdsInstanceBaseConfig);
			instanceSpaceinfoMapper.insertSelective(rdsInstanceSpaceInfo);
			instanceRootAccountMapper.insertSelective(rdsInstanceRootAccount);

			if (null != rdsInstanceSlaverList) {
				RdsInstanceSlaverMapper instanceSlaverMapper = ServiceUtil.getMapper(RdsInstanceSlaverMapper.class);
				for (RdsInstanceSlaver is : rdsInstanceSlaverList) {
					is.setInstanceslaverbelonger(instanceid);
					instanceSlaverMapper.insertSelective(is);
				}
			}
			if (null != rdsInstanceBatMaster) {
				RdsInstancebatmasterMapper instancebatmasterMapper = ServiceUtil
						.getMapper(RdsInstancebatmasterMapper.class);
				rdsInstanceBatMaster.setInstancebatmasterbelonger(instanceid);
				instancebatmasterMapper.insertSelective(rdsInstanceBatMaster);
			}

			return this;
		}else{
			return null;
		}
		

	}

	public RdsImageResource getRdsImageResource() {
		return rdsImageResource;
	}

	public void setRdsImageResource(RdsImageResource rdsImageResource) {
		this.rdsImageResource = rdsImageResource;
	}

	public RdsResourcepool getRdsResourcepool() {
		return rdsResourcepool;
	}

	public void setRdsResourcepool(RdsResourcepool rdsResourcepool) {
		this.rdsResourcepool = rdsResourcepool;
	}

	public RdsInstanceBase getRdsInstanceBase() {
		return rdsInstanceBase;
	}

	public void setRdsInstanceBase(RdsInstanceBase rdsInstanceBase) {
		this.rdsInstanceBase = rdsInstanceBase;
	}

	public RdsInstanceipport getRdsInstanceipport() {
		return rdsInstanceipport;
	}

	public void setRdsInstanceipport(RdsInstanceipport rdsInstanceipport) {
		this.rdsInstanceipport = rdsInstanceipport;
	}

	public RdsInstanceStatus getRdsInstanceStatus() {
		return rdsInstanceStatus;
	}

	public void setRdsInstanceStatus(RdsInstanceStatus rdsInstanceStatus) {
		this.rdsInstanceStatus = rdsInstanceStatus;
	}

	public RdsInstanceBaseconfig getRdsInstanceBaseConfig() {
		return this.rdsInstanceBaseConfig;
	}

	public void setRdsInstanceBaseConfig(RdsInstanceBaseconfig rdsInstanceBaseConfig) {
		this.rdsInstanceBaseConfig = rdsInstanceBaseConfig;
	}

	public RdsInstanceSpaceinfo getRdsInstanceSpaceInfo() {
		return rdsInstanceSpaceInfo;
	}

	public void setRdsInstanceSpaceInfo(RdsInstanceSpaceinfo rdsInstanceSpaceInfo) {
		this.rdsInstanceSpaceInfo = rdsInstanceSpaceInfo;
	}

	public RdsInstanceRootaccount getRdsInstanceRootAccount() {
		return rdsInstanceRootAccount;
	}

	public void setRdsInstanceRootAccount(RdsInstanceRootaccount rdsInstanceRootAccount) {
		this.rdsInstanceRootAccount = rdsInstanceRootAccount;
	}

	public List<RdsInstanceSlaver> getRdsInstanceSlaverList() {
		return rdsInstanceSlaverList;
	}

	public void setRdsInstanceSlaverList(List<RdsInstanceSlaver> rdsInstanceSlaverList) {
		this.rdsInstanceSlaverList = rdsInstanceSlaverList;
	}

	public RdsInstancebatmaster getRdsInstanceBatMaster() {
		return rdsInstanceBatMaster;
	}

	public void setRdsInstanceBatMaster(RdsInstancebatmaster rdsInstanceBatMaster) {
		this.rdsInstanceBatMaster = rdsInstanceBatMaster;
	}

	public InstanceBase(RdsInstanceBase rdsInstanceBase, RdsInstanceipport rdsInstanceipport,
			RdsInstanceStatus rdsInstanceStatus, RdsInstanceBaseconfig rdsInstanceBaseConfig,
			RdsInstanceSpaceinfo rdsInstanceSpaceInfo, RdsInstanceRootaccount rdsInstanceRootAccount,
			List<RdsInstanceSlaver> rdsInstanceSlaverList, RdsInstancebatmaster rdsInstanceBatMaster) {
		super();
		this.rdsInstanceBase = rdsInstanceBase;
		this.rdsInstanceipport = rdsInstanceipport;
		this.rdsInstanceStatus = rdsInstanceStatus;
		this.rdsInstanceBaseConfig = rdsInstanceBaseConfig;
		this.rdsInstanceSpaceInfo = rdsInstanceSpaceInfo;
		this.rdsInstanceRootAccount = rdsInstanceRootAccount;
		this.rdsInstanceSlaverList = rdsInstanceSlaverList;
		this.rdsInstanceBatMaster = rdsInstanceBatMaster;
	}

	public InstanceBase() {
		super();
	}
	
}
