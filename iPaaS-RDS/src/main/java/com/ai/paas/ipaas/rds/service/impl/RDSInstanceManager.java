package com.ai.paas.ipaas.rds.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.ServiceUtil;
import com.ai.paas.ipaas.agent.util.AgentUtil;
import com.ai.paas.ipaas.agent.util.AidUtil;
import com.ai.paas.ipaas.ccs.constants.ConfigCenterDubboConstants.PathType;
import com.ai.paas.ipaas.ccs.service.ICCSComponentManageSv;
import com.ai.paas.ipaas.ccs.service.dto.CCSComponentOperationParam;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsInstanceBaseMapper;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsInstanceStatusMapper;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsInstanceipportMapper;
import com.ai.paas.ipaas.rds.dao.interfaces.RdsResourcepoolMapper;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceBase;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceSlaver;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceStatus;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstancebatmaster;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsInstanceipport;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsResourcepool;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsResourcepoolCriteria;
import com.ai.paas.ipaas.rds.dao.wo.InstanceBase;
import com.ai.paas.ipaas.rds.dao.wo.ResourcePool;
import com.ai.paas.ipaas.rds.manage.rest.interfaces.IRDSInstanceManager;
import com.ai.paas.ipaas.rds.service.constant.InstanceType;
import com.ai.paas.ipaas.rds.service.constant.RDSCommonConstant;
import com.ai.paas.ipaas.rds.service.constant.ResponseResultMark;
import com.ai.paas.ipaas.rds.service.transfer.vo.CancelRDS;
import com.ai.paas.ipaas.rds.service.transfer.vo.CancelRDSResult;
import com.ai.paas.ipaas.rds.service.transfer.vo.CreateRDS;
import com.ai.paas.ipaas.rds.service.transfer.vo.CreateRDSResult;
import com.ai.paas.ipaas.rds.service.transfer.vo.CreateSRDS;
import com.ai.paas.ipaas.rds.service.transfer.vo.GetInstanceInfoRDS;
import com.ai.paas.ipaas.rds.service.transfer.vo.RDSResourcePlan;
import com.ai.paas.ipaas.rds.service.transfer.vo.ResIncPlan;
import com.ai.paas.ipaas.rds.service.transfer.vo.RestartRDS;
import com.ai.paas.ipaas.rds.service.transfer.vo.StartRDS;
import com.ai.paas.ipaas.rds.service.transfer.vo.StopRDS;
import com.ai.paas.ipaas.rds.service.util.EntityToWhere;
import com.ai.paas.ipaas.rds.service.util.GsonSingleton;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;

import com.google.gson.reflect.TypeToken;

/**
 * 传输对象命名规则就是对应方法名
 * 拓扑结构可以随意更改 
 * 空间是通过修改mysql配置和扩充磁盘阵列实现 
 * @author 作者 “WTF” E-mail: 1031248990@qq.com
 * @date 创建时间：2016年7月11日 下午4:48:55
 * @version
 * @since
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RDSInstanceManager implements IRDSInstanceManager {

	@Autowired
	GsonSingleton g;

	@Autowired
	ICCSComponentManageSv iCCSComponentManageSv;

	/**
	 * 注销实例
	 * 可以是单个，也可以是多个
	 */
	@Override
	public String cancel(String cancel) {
		// 解析JSON对象
		CancelRDS cancelObject = g.getGson().fromJson(cancel, CancelRDS.class);
		CancelRDSResult cancelResult = new CancelRDSResult();
		Stack<InstanceBase> instanceStack ;
		// 检查用户权限
		if(!CheckCancelLegal(cancelObject)){
			cancelResult.setStatus(ResponseResultMark.ERROR_ILLEGAL_AUTHORITY);
			return g.getGson().toJson(cancelResult);
		}

		// 检查数据完整性
		if(!CheckCancelDataLegal(cancelObject)){
			cancelResult.setStatus(ResponseResultMark.ERROR_LESS_IMP_PARAM);
			return g.getGson().toJson(cancelResult);
		}
		
		// 查询实例情况
		instanceStack = getInstanceStack(cancelObject.instanceid);
		
		if(instanceStack.isEmpty()){
			cancelResult.setStatus(ResponseResultMark.WARNING_INSTANCE_STACK_EMPTY);
			return g.getGson().toJson(cancelResult);
		}
		
		while(!instanceStack.isEmpty()){
			InstanceBase instance = instanceStack.pop();
			instance.getRdsInstanceStatus().setInstancestatus(RDSCommonConstant.INS_FREEZE);
			RdsInstanceStatusMapper statusMapper = ServiceUtil.getMapper(RdsInstanceStatusMapper.class);
			statusMapper.updateByPrimaryKeySelective(instance.getRdsInstanceStatus());
			dealCancelInstanceDevided(instance);
			deleteZK(instance);
		};

		cancelResult.setStatus(ResponseResultMark.SUCCESS);
		return g.getGson().toJson(cancelResult);
	}

	/**
	 * 删除相应ZK节点
	 * @param instanceRDS
	 */
	private void deleteZK(InstanceBase instanceRDS) {
		CCSComponentOperationParam op = new CCSComponentOperationParam();
		op.setUserId(instanceRDS.getRdsInstanceBase().getUserId());
		op.setPath(RDSCommonConstant.RDS_ZK_PATH + instanceRDS.getRdsInstanceBase().getInstanceid());
		op.setPathType(PathType.READONLY);

		try {
			iCCSComponentManageSv.delete(op);
		} catch (PaasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 通过一个实例id查询到实例和实例的主备、主从实例
	 * @param instanceid
	 * @return
	 */
	private Stack<InstanceBase> getInstanceStack(long instanceid) {
		Stack<InstanceBase> instanceStack = new Stack<InstanceBase>();
//		RdsInstanceBaseMapper ibm = ServiceUtil.getMapper(RdsInstanceBaseMapper.class);
//		RdsInstanceBase instanceInfo = ibm.selectByPrimaryKey(instanceid);
		InstanceBase ibTool = new InstanceBase();
		InstanceBase instanceInfo = ibTool.getCompleteInstanceBase(instanceid);
		if(null != instanceInfo)
			instanceStack.push(instanceInfo);
		if(1 == instanceInfo.getRdsInstanceBase().getInstancenetworktype()){
			if(null != instanceInfo.getRdsInstanceBatMaster()){
				InstanceBase instanceBMInfo = ibTool.getCompleteInstanceBase(instanceInfo.getRdsInstanceBatMaster().getInstancebatmasterid());
				instanceStack.push(instanceBMInfo);
			}
			if(null != instanceInfo.getRdsInstanceSlaverList()){
				for(RdsInstanceSlaver is : instanceInfo.getRdsInstanceSlaverList()){
					instanceStack.push(ibTool.getCompleteInstanceBase(is.getInstanceslaverid()));
				}
			}
		}
		
		return instanceStack;
	}

	/**
	 * 数据库已经添加了触发器trigger
	 * 从表将与主表一同删除
	 * @param instanceBase
	 */
	private void dealCancelInstanceDevided(InstanceBase instanceBase) {
		// 停止运行实例，并移除相关镜像、配置、数据
		stopInstance(instanceBase);
		// 删除InstanceBase表中的信息
		RdsInstanceBaseMapper instanceBaseMapper = ServiceUtil.getMapper(RdsInstanceBaseMapper.class);
		instanceBaseMapper.deleteByPrimaryKey(instanceBase.getRdsInstanceBase().getInstanceid());
//		instanceBaseRepo.delete(instanceBase);
		// 资源恢复更新
		RdsResourcepoolMapper resPoolMapper = ServiceUtil.getMapper(RdsResourcepoolMapper.class);
		RdsResourcepool rdsres = resPoolMapper.selectByPrimaryKey(instanceBase.getRdsInstanceBase().getInstanceresourcebelonger());
		rdsres.setUsedmemory(rdsres.getUsedmemory().intValue() - instanceBase.getRdsInstanceSpaceInfo().getExternalstorage().intValue());
		resPoolMapper.updateByPrimaryKey(rdsres);
//		instanceBase.getInstanceresourcebelonger().setUsedmemory(instanceBase.getInstanceresourcebelonger().getUsedmemory() - instanceBase.getInstancespaceinfo().getExternalStorage());
//		resourcePoolRepo.saveAndFlush(instanceBase.getInstanceresourcebelonger());
	}

	/**
	 * 停止单个实例
	 * 通过ansible执行脚本停止docker中mysql实例的运行
	 * @param instanceBase
	 */
	private void stopInstance(InstanceBase instanceBase) {
		// TODO Auto-generated method stub
	}

	private boolean CheckCancelDataLegal(CancelRDS cancelObject) {
		if((0 < cancelObject.instanceid) && null == cancelObject.token && null == cancelObject.user_id)
			return false;
		return true;
	}

	private boolean CheckCancelLegal(CancelRDS cancelObject) {
		return true;
	}

	// @ExceptionHandler(Exception.class)
	// private void exception(Exception e){
	// e.printStackTrace();
	// }

	/**
	 * 创建实例 
	 * 这里主要是创建一个主实例，并创建相应的主备、主从实例
	 * 单独创建备、从实例是在其他方法当中
	 * create中必须存在的字段
	 * －－－－
	 * token/
	 * instanceName/
	 * user_id/
	 * serial_number/
	 * instancenetworktype/
	 * instancespaceinfo/
	 * instancebaseconfig/
	 * instanceimagebelonger/
	 * instancerootaccount/
	 * 可选字段（延时生成字段）
	 * instanceslaver/
	 * instancebatmaster/
	 * 生成字段-RDSResourcePlan
	 * instanceipport/
	 * instancestatus/
	 * instanceresourcebelonger/
	 */
	@Override
	public String create(String create) {
		// 解析JSON对象
		CreateRDS createObject = g.getGson().fromJson(create, CreateRDS.class);
		CreateRDSResult createResult = new CreateRDSResult(ResponseResultMark.WARN_INIT_STATUS);
		// 检查用户操作权限是否合法
		if (false == CheckLegal(createObject.instanceBase.getRdsInstanceBase().getUserId(), createObject.instanceBase.getRdsInstanceBase().getSerialNumber(),
				createObject.token)) {
			createResult.setStatus(ResponseResultMark.ERROR_ILLEGAL_AUTHORITY);
			return g.getGson().toJson(createResult);
		}
		// 检查数据是否合法
		if (false == CheckData(createObject)) {
			createResult.setStatus(ResponseResultMark.ERROR_LESS_IMP_PARAM);
			return g.getGson().toJson(createResult);
		}
		
		// 查询资源情况，根据请求情况与资源情况获取分配计划
		RdsResourcepoolMapper rdsResPoolMapper =  ServiceUtil.getMapper(RdsResourcepoolMapper.class);
		RdsResourcepoolCriteria rdsResPoolCri = new RdsResourcepoolCriteria();
		rdsResPoolCri.createCriteria().andCurrentportLessThan(65000);
		List<RdsResourcepool> allResource = rdsResPoolMapper.selectByExample(rdsResPoolCri);
		RDSResourcePlan resourcePlan = getResourcePlan(createObject, allResource);
		if(null == resourcePlan.instanceresourcebelonger){
			createResult.setStatus(ResponseResultMark.ERROR_LESS_MEMORY_SPACE);
			return g.getGson().toJson(createResult);
		}
		
		// 对资源分配后的情况保存到数据库，修改资源池的情况，插入实例信息
		InstanceBase savedInstanceBase = savePlan(resourcePlan, createObject.instanceBase, InstanceType.MASTER);

		// 对实例进行配置 master/slaver/batmaster 通过AgentClient
		boolean isRightConfig = false;
		try {
			isRightConfig = InstanceConfig(savedInstanceBase);
		} catch (IOException | PaasException e) {
			// 处理。。。
			e.printStackTrace();
		}

		boolean instanceRun = false;
		if (true == isRightConfig) {
			// 如果实例配置成功则启动实例
//			instanceRun = startInstance(savedInstanceBase);
//			InstanceBase instance = instanceStack.pop();
			savedInstanceBase.instancestatus.instanceStatus = RDSCommonConstant.INS_STARTING;
			instanceBaseRepo.saveAndFlush(savedInstanceBase);
			// 启动mysql服务
			startInstance(savedInstanceBase);
			// 修改数据库中服务器状态
			savedInstanceBase.instancestatus.instanceStatus = RDSCommonConstant.INS_STARTED;
			instanceBaseRepo.saveAndFlush(savedInstanceBase);
			
			// 将拓扑结构保存至注册中心（zk）,由于数据不全则将延迟保存到ZK
//			save2ZK(savedInstanceBase);
			
		}

		// 根据可选字段创建mysql从服务器、创建mysql主备服务器，存储在InstanceBase表中
		if ((createObject.instanceBase.instanceNetworkType == InstanceType.MASTER) && (true == isRightConfig)) {
			InstanceBase batMasterInstance = null;
			RdsInstancebatmaster savedBatmasterInstance = null;
			List<InstanceBase> slaverInstanceList = new LinkedList<InstanceBase>();
			List<RdsInstanceSlaver> slaverForMasterInstance = new LinkedList<RdsInstanceSlaver>();
			if (1 == createObject.createBatmasterNum) {
				// 包装一个创建主备实例的类，并保存到数据库
//				batMasterInstance = createBatmaster(createObject, savedInstanceBase, batMasterInstance, slaverInstanceList);
				// 查询资源情况，根据请求情况与资源情况获取分配计划
				RDSResourcePlan resourceBatMasterPlan = getExpectResourcePlan(createObject, allResource,
						savedInstanceBase, batMasterInstance, slaverInstanceList);
				if(null == resourceBatMasterPlan.instanceresourcebelonger){
					createResult.setStatus(ResponseResultMark.ERROR_NOT_EXIST_USEFUL_RESOURCE);
					return g.getGson().toJson(createResult);
				}
				// 对资源分配后的情况保存到数据库，修改资源池的情况，插入实例信息
				batMasterInstance = savePlan(resourceBatMasterPlan, createObject.instanceBase, InstanceType.BATMASTER);

				// 对需要外键延期保存的数据，单独进行保存（instanceslaver、instancebatmaster）
				savedBatmasterInstance = instanceBatmasterRepo
						.save(new RdsInstanceBatMaster(createObject.instanceBase, batMasterInstance.instanceid,
								Calendar.getInstance().getTime(), Calendar.getInstance().getTime()));
				// 保存信息到实例
				savedInstanceBase.instancebatmaster = savedBatmasterInstance;
				// 对实例进行远程配置
				boolean isRightBatMasterConfig = false;
				try {
					isRightBatMasterConfig = InstanceConfig(batMasterInstance);
				} catch (IOException | PaasException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (true == isRightBatMasterConfig) {
					// 如果实例配置成功则启动实例
//					boolean batMasterInstanceRun = startInstance(batMasterInstance);
					batMasterInstance.instancestatus.instanceStatus = RDSCommonConstant.INS_STARTING;
					instanceBaseRepo.saveAndFlush(batMasterInstance);
					// 启动mysql服务
					startInstance(batMasterInstance);
					// 修改数据库中服务器状态
					batMasterInstance.instancestatus.instanceStatus = RDSCommonConstant.INS_STARTED;
					instanceBaseRepo.saveAndFlush(batMasterInstance);
					
					// 将拓扑结构保存至注册中心（zk）
					save2ZK(batMasterInstance);
				}
			}

			if (0 < createObject.createSlaverNum) {
				for (int i = 1; i < createObject.createSlaverNum; i++) {
					// 包装多个创建从服务器实例的类，并保存到数据库
					RDSResourcePlan resourceSlaverPlan = getExpectResourcePlan(createObject, allResource,
							savedInstanceBase, batMasterInstance, slaverInstanceList);
					if(null == resourceSlaverPlan.instanceresourcebelonger){
						createResult.setStatus(ResponseResultMark.ERROR_NOT_EXIST_USEFUL_RESOURCE);
						return g.getGson().toJson(createResult);
					}
					// 对资源分配后的情况保存到数据库，修改资源池的情况，插入实例信息
					InstanceBase ib = savePlan(resourceSlaverPlan, createObject.instanceBase, InstanceType.SLAVER);
					
					slaverInstanceList.add(ib);
					// 对需要外键延期保存的数据，单独进行保存（instanceslaver、instancebatmaster）
					RdsInstanceSlaver savedSlaverInstance = instanceSlaverRepo
							.save(new InstanceSlaver(createObject.instanceBase, ib.instanceid,
									Calendar.getInstance().getTime(), Calendar.getInstance().getTime()));
					slaverForMasterInstance.add(savedSlaverInstance);
					// 对实例进行远程配置
					boolean isRightSlaverConfig = false;
					try {
						isRightSlaverConfig = InstanceConfig(ib);
					} catch (IOException | PaasException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (true == isRightSlaverConfig) {
						// 如果实例配置成功则启动实例
//						boolean slaverInstanceRun = startInstance(ib);
						ib.instancestatus.instanceStatus = RDSCommonConstant.INS_STARTING;
						instanceBaseRepo.saveAndFlush(ib);
						// 启动mysql服务
						startInstance(ib);
						// 修改数据库中服务器状态
						ib.instancestatus.instanceStatus = RDSCommonConstant.INS_STARTED;
						instanceBaseRepo.saveAndFlush(ib);
						
						// 将拓扑结构保存至注册中心（zk）
						save2ZK(ib);
					}
				}
				savedInstanceBase.instanceslaver = slaverForMasterInstance;
			}
		}

		// 将拓扑结构保存至注册中心（zk）
		save2ZK(savedInstanceBase);
		
		createResult.isInstanceConfig = isRightConfig;
		createResult.isInstanceRun = instanceRun;
		createResult.Instance = savedInstanceBase;

		createResult.setStatus(ResponseResultMark.SUCCESS);
		return g.getGson().toJson(createResult);
	}
	
	
	@Override
	public String createslobm(String create) {
		CreateSRDS createObject = g.getGson().fromJson(create, CreateSRDS.class);
		CreateSRDSResult createResult = new CreateSRDSResult(ResponseResultMark.WARN_INIT_STATUS);
		InstanceBase masterInstance = instanceBaseRepo.findOne(createObject.masterinstanceid);
		// 查询实例情况
		Stack<InstanceBase> instanceStack = getInstanceStack(createObject.masterinstanceid);
		List<ResourcePool> exceptResourceResourceList = new ArrayList<ResourcePool>();
		for(int i = 0; i < instanceStack.size(); i++){
			exceptResourceResourceList.add(instanceStack.get(i).instanceresourcebelonger);
		}
		List<ResourcePool> allRes = resourcePoolRepo.findAll();
		// 查询资源情况，根据请求情况与资源情况获取分配计划
		RDSResourcePlan resourceBatMasterPlan = getExpectResourcePlan(masterInstance, allRes, exceptResourceResourceList);
		if(null == resourceBatMasterPlan.instanceresourcebelonger){
			createResult.setStatus(ResponseResultMark.ERROR_NOT_EXIST_USEFUL_RESOURCE);
			return g.getGson().toJson(createResult);
		}
		// 对资源分配后的情况保存到数据库，修改资源池的情况，插入实例信息
		InstanceBase saveInstanceBase = savePlan(resourceBatMasterPlan, masterInstance, createObject.thisInstanceType);

		// 对需要外键延期保存的数据，单独进行保存（instanceslaver、instancebatmaster）
		switch(saveInstanceBase.instanceNetworkType){
		case InstanceType.MASTER:
			createResult.setStatus(ResponseResultMark.ERROR_CANNOT__CREATE_MASTER_IN_THIS_METHOD);
			return g.getGson().toJson(createResult);
		case InstanceType.BATMASTER:
			instanceBatmasterRepo
				.save(new InstanceBatMaster(masterInstance, saveInstanceBase.instanceid,
					Calendar.getInstance().getTime(), Calendar.getInstance().getTime()));
			break;
		case InstanceType.SLAVER:
			instanceSlaverRepo
				.save(new InstanceSlaver(masterInstance, saveInstanceBase.instanceid,
					Calendar.getInstance().getTime(), Calendar.getInstance().getTime()));
			break;
		default:
			createResult.setStatus(ResponseResultMark.ERROR_UNKNOW_INSTANCE_TYPE);
			return g.getGson().toJson(createResult);
		}
			
		// 保存信息到实例
//		savedInstanceBase.instancebatmaster = savedBatmasterInstance;
		// 对实例进行远程配置
		boolean isRightBatMasterConfig = false;
		try {
			isRightBatMasterConfig = InstanceConfig(saveInstanceBase);
		} catch (IOException | PaasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (true == isRightBatMasterConfig) {
			// 如果实例配置成功则启动实例
//			boolean batMasterInstanceRun = startInstance(batMasterInstance);
			saveInstanceBase.instancestatus.instanceStatus = RDSCommonConstant.INS_STARTING;
			instanceBaseRepo.saveAndFlush(saveInstanceBase);
			// 启动mysql服务
			startInstance(saveInstanceBase);
			// 修改数据库中服务器状态
			saveInstanceBase.instancestatus.instanceStatus = RDSCommonConstant.INS_STARTED;
			instanceBaseRepo.saveAndFlush(saveInstanceBase);
			
			// 将拓扑结构保存至注册中心（zk）
			save2ZK(saveInstanceBase);
		}
		createResult.setStatus(ResponseResultMark.SUCCESS);
		return g.getGson().toJson(createResult);
	}

	

	private void save2ZK(InstanceBase instanceRDS) {
		CCSComponentOperationParam op = new CCSComponentOperationParam();
		op.setUserId(instanceRDS.user_id);
		op.setPath(RDSCommonConstant.RDS_ZK_PATH + instanceRDS.instanceid);
		op.setPathType(PathType.READONLY);

		try {
			iCCSComponentManageSv.add(op, g.getGson().toJson(instanceRDS));
		} catch (PaasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 未完成
	 * 配置MySQL
	 * Master\Slaver\BatMaster
	 * 
	 * @param savedInstanceBase
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws PaasException
	 */
	private boolean InstanceConfig(InstanceBase savedInstanceBase)
			throws ClientProtocolException, IOException, PaasException {
		switch(savedInstanceBase.instanceNetworkType){
		case InstanceType.MASTER:
			break;
		case InstanceType.SLAVER:
			break;
		case InstanceType.BATMASTER:
			break;
		}
		
		
		
		String basePath = AgentUtil.getAgentFilePath(AidUtil.getAid());
		// 1.先将需要执行镜像命令的机器配置文件上传上去。
		InputStream in = RDSInstanceManager.class.getResourceAsStream("/playbook/rds/init_ansible_ssh_hosts.sh");
		String[] cnt = AgentUtil.readFileLines(in);
		in.close();
		AgentUtil.uploadFile("rds/init_ansible_ssh_hosts.sh", cnt, AidUtil.getAid());
		AgentUtil.executeCommand("chmod +x " + basePath + "rds/init_ansible_ssh_hosts.sh", AidUtil.getAid());

		// 2.执行这个初始化命令
		String mkSshHosts = fillStringByArgs(CREATE_ANSIBLE_HOSTS,
				new String[] { basePath + "rds", savedInstanceBase.instanceipport.instanceIp.replace(".", ""),
						savedInstanceBase.instanceipport.instanceIp });
		// LOG.debug("---------mkSshHosts {}----------", mkSshHosts);
		AgentUtil.executeCommand(basePath + mkSshHosts, AidUtil.getAid());

		in = RDSInstanceManager.class.getResourceAsStream("/playbook/rds/rdsimage.yml");
		cnt = AgentUtil.readFileLines(in);
		in.close();
		AgentUtil.uploadFile("rds/rdsimage.yml", cnt, AidUtil.getAid());

		// 还得上传文件
		in = RDSInstanceManager.class.getResourceAsStream("/playbook/rds/ansible_run_image.sh");
		cnt = AgentUtil.readFileLines(in);
		in.close();
		AgentUtil.uploadFile("rds/ansible_run_image.sh", cnt, AidUtil.getAid());
		AgentUtil.executeCommand("chmod +x " + basePath + "rds/ansible_run_image.sh", AidUtil.getAid());
		// 开始执行
		String runImage = fillStringByArgs(DOCKER_4_GM_AND_TOMCAT,
				new String[] { "", savedInstanceBase.instanceipport.instanceIp.replace(".", ""),
						savedInstanceBase.instanceresourcebelonger.getSshUser(),
						savedInstanceBase.instanceresourcebelonger.getSshPassword(),
						savedInstanceBase.instanceipport.getInstanceIp(),
						savedInstanceBase.instanceimagebelonger.image_repository + "/"
								+ savedInstanceBase.instanceimagebelonger.image_name,
						savedInstanceBase.instanceipport.getPort() + "",
						savedInstanceBase.instancebaseconfig.instanceDataPath,
						savedInstanceBase.instancebaseconfig.instanceHomePath, basePath + "rds" });

		// LOG.debug("---------runImage {}----------", runImage);
		AgentUtil.executeCommand(basePath + runImage, AidUtil.getAid());

		return false;
	}

	/** ansible hosts */
	public static final String CREATE_ANSIBLE_HOSTS = "rds/init_ansible_ssh_hosts.sh {0} {1} {2}";
	/** 图片服务器 */
	public static final String DOCKER_4_GM_AND_TOMCAT = "rds/ansible_run_image.sh {1} {2} "
			+ "{3} {4} {5} {6} {7} {8} {9} ";

	public static String fillStringByArgs(String str, String[] arr) {
		Matcher m = Pattern.compile("\\{(\\d+)\\}").matcher(str);
		while (m.find()) {
			str = str.replace(m.group(), arr[Integer.parseInt(m.group(1))]);
		}
		return str;
	}

	private RDSResourcePlan getExpectResourcePlan(CreateRDS createObject, List<ResourcePool> resourceList,
			InstanceBase masterInstance, InstanceBase batMasterInstance, List<InstanceBase> slaverInstanceList) {
		RDSResourcePlan resourcePlan = new RDSResourcePlan();
		// 根据需求找到可用资源列表
		List<ResourcePool> usableResourceList = getMasterUsableResource(createObject, resourceList);

		ChoiceResStrategy crs = new ChoiceResStrategy(new MoreMemIdleChoice());
		List<ResourcePool> exceptList = new LinkedList<ResourcePool>();
		exceptList.add(masterInstance.instanceresourcebelonger);
		if (null != masterInstance) {
			exceptList.add(masterInstance.instanceresourcebelonger);
		}
		if (slaverInstanceList.size() > 0) {
			for (int i = 0; i < slaverInstanceList.size(); i++) {
				exceptList.add(slaverInstanceList.get(i).instanceresourcebelonger);
			}
		}
		ResourcePool decidedRes = crs.makeDecision(usableResourceList, exceptList);

		if (null == decidedRes) {
			return null;
		}
		// 生成资源分配信息
		decidedRes.currentport = decidedRes.currentport + 1;
		decidedRes.usedmemory = decidedRes.usedmemory + createObject.instanceBase.instancespaceinfo.externalStorage;
		resourcePlan.instanceresourcebelonger = decidedRes;

		InstanceIpPort instanceIpPort = new InstanceIpPort(decidedRes.hostip, decidedRes.currentport,
				Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
		instanceIpPort.setInstanceipportbelonger(createObject.instanceBase);
		resourcePlan.instanceIpPort = instanceIpPort;

		InstanceStatus instanceStatus = new InstanceStatus(RDSCommonConstant.INS_ACTIVATION,
				Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
		instanceStatus.setInstancestatusbelonger(createObject.instanceBase);
		resourcePlan.instanceStatus = instanceStatus;
		return resourcePlan;
	}
	
	private RDSResourcePlan getExpectResourcePlan(InstanceBase masterInstance, List<ResourcePool> resourceList,
			List<ResourcePool> exceptInstanceList) {
		
		RDSResourcePlan resourcePlan = new RDSResourcePlan();
		// 根据需求找到可用资源列表
		List<ResourcePool> usableResourceList = getMasterUsableResource(masterInstance.instancespaceinfo.externalStorage, resourceList);

		ChoiceResStrategy crs = new ChoiceResStrategy(new MoreMemIdleChoice());
		List<ResourcePool> exceptList = new LinkedList<ResourcePool>();
		exceptList.addAll(exceptInstanceList);
		ResourcePool decidedRes = crs.makeDecision(usableResourceList, exceptList);

		if (null == decidedRes) {
			return null;
		}
		// 生成资源分配信息
		decidedRes.currentport = decidedRes.currentport + 1;
		decidedRes.usedmemory = decidedRes.usedmemory + masterInstance.instancespaceinfo.externalStorage;
		resourcePlan.instanceresourcebelonger = decidedRes;

		InstanceIpPort instanceIpPort = new InstanceIpPort(decidedRes.hostip, decidedRes.currentport,
				Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
		instanceIpPort.setInstanceipportbelonger(masterInstance);
		resourcePlan.instanceIpPort = instanceIpPort;

		InstanceStatus instanceStatus = new InstanceStatus(RDSCommonConstant.INS_ACTIVATION,
				Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
		instanceStatus.setInstancestatusbelonger(masterInstance);
		resourcePlan.instanceStatus = instanceStatus;
		return resourcePlan;
	}

	private boolean CheckData(CreateRDS createObject) {
		// TODO Auto-generated method stub
		if ((null == createObject.token) && (null == createObject.instanceBase.getRdsInstanceBase().getInstancename())
				&& (null == createObject.instanceBase.getRdsInstanceBase().getUserId()) 
				&& (null == createObject.instanceBase.getRdsInstanceBase().getSerialNumber())
				&& (1 > createObject.instanceBase.getRdsInstanceBase().getInstancenetworktype())
				&& (null == createObject.instanceBase.getRdsInstanceSpaceInfo())
				&& (null == createObject.instanceBase.getRdsInstanceBaseConfig())
				&& (null == createObject.instanceBase.getRdsImageResource())
				&& (null == createObject.instanceBase.getRdsInstanceRootAccount())) {
			return false;
		} else {
			return true;
		}
	}

	private RDSResourcePlan getResourcePlan(CreateRDS createObject, List<RdsResourcepool> resourceList) {
		
		// 根据需求找到可用资源列表
		List<RdsResourcepool> usableResourceList = getMasterUsableResource(createObject, resourceList);
		switch (createObject.instanceBase.getRdsInstanceBase().getInstancenetworktype()) {
		case InstanceType.MASTER:
			RDSResourcePlan resourcePlan = new RDSResourcePlan();
			// 选择适当的主机进行分配资源
			ChoiceResStrategy crs = new ChoiceResStrategy(new MoreMemIdleChoice());
			RdsResourcepool decidedRes = crs.makeDecision(usableResourceList);
			if (null == decidedRes) {
				return null;
			}
			// 生成资源分配信息
			decidedRes.setCurrentport(decidedRes.getCurrentport() + 1);
			decidedRes.setUsedmemory(decidedRes.getUsedmemory().intValue() + createObject.instanceBase.getRdsInstanceSpaceInfo().getExternalstorage().intValue());
			resourcePlan.instanceresourcebelonger = decidedRes;

			RdsInstanceipport instanceIpPort = new RdsInstanceipport(decidedRes.getHostip(), decidedRes.getCurrentport());
			// instanceIpPort.setInstanceipportbelonger(createObject.instanceBase);
			resourcePlan.instanceIpPort = instanceIpPort;

			RdsInstanceStatus instanceStatus = new RdsInstanceStatus(RDSCommonConstant.INS_ACTIVATION);
			// instanceStatus.setInstancestatusbelonger(createObject.instanceBase);
			resourcePlan.instanceStatus = instanceStatus;
			return resourcePlan;
		case InstanceType.BATMASTER:
		case InstanceType.SLAVER:
		default:
		}
		return null;
	}

	/**
	 * 获取可用资源 空间满足需求，状态满足需求，端口满足需求
	 * 
	 * @param createObject
	 * @param resourceList
	 * @return
	 */
	private List<RdsResourcepool> getMasterUsableResource(CreateRDS createObject, List<RdsResourcepool> resourceList) {
		// for(int i = 0; i < resourceList.size(); i++){
		List<RdsResourcepool> canUseRes = new LinkedList<RdsResourcepool>();
		for (RdsResourcepool rp : resourceList) {
			int canUseExtMemSize = rp.getTotalmemory() - rp.getUsedmemory();
			if ((RDSCommonConstant.RES_STATUS_USABLE == rp.getStatus()) && (RDSCommonConstant.RES_CYCLE_USABLE == rp.getCycle())
					&& (canUseExtMemSize > createObject.instanceBase.getRdsInstanceSpaceInfo().getExternalstorage())
					&& ((rp.getCurrentport() + 1) < rp.getMaxport())) {
				// if((decidedRes.currentport+1) < decidedRes.maxport){
				canUseRes.add(rp);
			}
		}
		return canUseRes;
	}
	/**
	 * 获取可用资源 空间满足需求，状态满足需求，端口满足需求
	 * 
	 * @param createObject
	 * @param resourceList
	 * @return
	 */
	private List<ResourcePool> getMasterUsableResource(int externalStorage, List<ResourcePool> resourceList) {
		// for(int i = 0; i < resourceList.size(); i++){
		List<ResourcePool> canUseRes = new LinkedList<ResourcePool>();
		for (ResourcePool rp : resourceList) {
			int canUseExtMemSize = rp.totalmemory - rp.usedmemory;
			if ((RDSCommonConstant.RES_STATUS_USABLE == rp.status) && (RDSCommonConstant.RES_CYCLE_USABLE == rp.cycle)
					&& (canUseExtMemSize > externalStorage)
					&& ((rp.currentport + 1) < rp.maxport)) {
				// if((decidedRes.currentport+1) < decidedRes.maxport){
				canUseRes.add(rp);
			}
		}
		return canUseRes;
	}

	/**
	 * 启动单实例
	 *  通过ansible启动
	 * @param instanceRDS
	 * @return
	 */
	private boolean startInstance(InstanceBase instanceRDS) {
		// 
		
		return false;
	}

	/**
	 * 当前存储字段有
	 * 
	 * @param resourcePlan
	 * @param createObject
	 * @return 返回当前账户的ID
	 * 
	 */
	private InstanceBase savePlan(RDSResourcePlan resourcePlan, InstanceBase instanceBase,int InstanceBaseNetworkType) {
//		InstanceBase instanceBase = createObject.instanceBase;
		instanceBase.getRdsInstanceBase().setInstancenetworktype(InstanceBaseNetworkType);
		if(InstanceBaseNetworkType == InstanceType.BATMASTER){
			instanceBase.getRdsInstanceBase().setInstancename(instanceBase.getRdsInstanceBase().getInstancename() + "-BATMASTER-" + Math.random());
		}
		if(InstanceBaseNetworkType == InstanceType.SLAVER){
			instanceBase.getRdsInstanceBase().setInstancename(instanceBase.getRdsInstanceBase().getInstancename() + "-SLAVER-" + Math.random());
		}
		
		// InstanceBase作为子表时的指针指向ImageResource和ResourcePool，但因为ImageResource已经存在，不需要关联
		instanceBase.getRdsInstanceBase().setInstanceresourcebelonger(resourcePlan.instanceresourcebelonger.getResourceid());
		// 将生成信息保存到InstanceBase
		instanceBase.setRdsInstanceipport(resourcePlan.instanceIpPort);
		
//		instanceBase.setInstanceipport(resourcePlan.instanceIpPort);
//		instanceBase.setInstancestatus(resourcePlan.instanceStatus);

		// 已经存在的数据，子表的对象指针指向主表
//		instanceBase.getInstancebaseconfig().setInstancebaseconfigbelonger(instanceBase);
//		instanceBase.getInstanceipport().setInstanceipportbelonger(instanceBase);
//		instanceBase.getInstancespaceinfo().setInstancespaceinfobelonger(instanceBase);
//		instanceBase.getInstancerootaccount().setInstancerootaccountbelonger(instanceBase);
//		instanceBase.getInstancestatus().setInstancestatusbelonger(instanceBase);

		// 保存实例
		InstanceBase savedInstanceBase = instanceBaseRepo.save(instanceBase);
		// 更新资源
		ResourcePool savedResource = resourcePoolRepo.saveAndFlush(resourcePlan.instanceresourcebelonger);

		return savedInstanceBase;
	}

	private boolean CheckLegal(String user_id, String serial_number, String token) {
		return true;
	}

	/**
	 * master修改后关联slaver和batmaster也要修改 但是无法直接修改slaver和batmaster
	 * 这里主要是指修改instancespaceinfo即空间信息
	 * modify中只能扩充容量无法缩小容量
	 * http://www.linuxidc.com/Linux/2015-01/112245.htm
	 */
	@Override
	public String modify(String modify) {
		ModifyRDS modifyRDSObject = g.getGson().fromJson(modify, ModifyRDS.class);
		Stack<InstanceBase> instanceStack ;
		Stack<InstanceBase> instanceStackBack = new Stack<InstanceBase>();
//		ModifyRDSResult modifyRDSResult = new ModifyRDSResult();
		// 只接受修改主mysql
		InstanceBase instanceCheck = instanceBaseRepo.findOne(modifyRDSObject.instanceid);
		if(instanceCheck.instanceNetworkType == InstanceType.MASTER){
			// 暂停所有服务
			instanceStack = getInstanceStack(modifyRDSObject.instanceid);
			if(!instanceStack.isEmpty()){
				while(!instanceStack.isEmpty()){
					InstanceBase instance = instanceStack.pop();
					instance.instancestatus.instanceStatus = RDSCommonConstant.INS_STOPPING;
					instanceBaseRepo.saveAndFlush(instance);
					// 启动mysql服务
					stopInstance(instance);
					// 修改数据库中服务器状态
					instance.instancestatus.instanceStatus = RDSCommonConstant.INS_STOPPED;
					instanceBaseRepo.saveAndFlush(instance);
					instanceStackBack.add(instance);
				};
			}else{
				StopRDSResult stopRDSResult = new StopRDSResult(ResponseResultMark.WARNING_INSTANCE_STACK_EMPTY);
				return g.getGson().toJson(stopRDSResult);
			}
			// 对master、batmaster、slaver选择进行扩充，数据库修改空间配置
			ResIncPlan resIncPlan = ResIncPlanSchemer(instanceStackBack,modifyRDSObject.argmentedExternalStorage);
			if(resIncPlan.increaseList.size() > 0 && resIncPlan.unincreaseList.size() == 0 ){
				for(InstanceBase ib : resIncPlan.increaseList){
					ib.instanceresourcebelonger.usedmemory = ib.instanceresourcebelonger.getUsedmemory() 
							- ib.instancespaceinfo.externalStorage + modifyRDSObject.argmentedExternalStorage;
					ib.instancespaceinfo.externalStorage = modifyRDSObject.argmentedExternalStorage;
					instanceBaseRepo.saveAndFlush(ib);
					configModify(ib,modifyRDSObject.argmentedExternalStorage);
				}
			} else {
				ModifyRDSResult modifyRDSResult = new ModifyRDSResult(ResponseResultMark.ERROR_NOT_EXIST_USEFUL_RESOURCE);
				return g.getGson().toJson(modifyRDSResult);
			}
			// 如果修改成功则启动所用相关服务
			ModifyRDSResult modifyRDSResult = new ModifyRDSResult(ResponseResultMark.SUCCESS);
			return g.getGson().toJson(modifyRDSResult);
		}else {
			ModifyRDSResult modifyRDSResult = new ModifyRDSResult(ResponseResultMark.ERROR_NOT_MASTER_CANNOT_MODIFY);
			return g.getGson().toJson(modifyRDSResult);
		}
	}

	private void configModify(InstanceBase ib, int argmentedExternalStorage) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 传入的栈顶必须是master
	 * @param instanceStackBack
	 * @param argmentedExternalStorage 
	 * @return
	 */
	private ResIncPlan ResIncPlanSchemer(Stack<InstanceBase> instanceStackBack, int argmentedExternalStorage) {
		ResIncPlan resIncPlan = new ResIncPlan();
		List<InstanceBase> increaseList = new ArrayList<InstanceBase>();
		List<InstanceBase> unincreaseList = new ArrayList<InstanceBase>();
		// 判断master、slaver、batslaver所在的资源是否支持扩容，如资源不足则列为不支持扩容并返回不支持列表，将不支持扩容工作生成工单手工操作
		for(InstanceBase ib : instanceStackBack){
			if((ib.instanceresourcebelonger.getTotalmemory() - ib.instanceresourcebelonger.getUsedmemory() 
					+ ib.instancespaceinfo.externalStorage - argmentedExternalStorage) < RDSCommonConstant.LIMIT_IDLE_USEABLE_EXTERNAL_STORAGE){
				increaseList.add(ib);
			} else {
				unincreaseList.add(ib);
			}
		}
		resIncPlan.increaseList = increaseList;
		resIncPlan.unincreaseList = unincreaseList;
		
		return resIncPlan;
	}

	/**
	 * 获取全部公有方法
	 */
	@Override
	public String getFuncList() {
		
		Method[] methodList = RDSInstanceManager.class.getMethods();
		return g.getGson().toJson(methodList);
	}

	@Override
	public String start(String startApply) {
		StartRDS startRDSObject = g.getGson().fromJson(startApply, StartRDS.class);
		Stack<InstanceBase> instanceStack ;
		// 判断用户权限
		// 判断服务器状态
		instanceStack = getInstanceStack(startRDSObject.instanceid);
		if(!instanceStack.isEmpty()){
			while(!instanceStack.isEmpty()){
				InstanceBase instance = instanceStack.pop();
				instance.instancestatus.instanceStatus = RDSCommonConstant.INS_STARTING;
				instanceBaseRepo.saveAndFlush(instance);
				// 启动mysql服务
				startInstance(instance);
				// 修改数据库中服务器状态
				instance.instancestatus.instanceStatus = RDSCommonConstant.INS_STARTED;
				instanceBaseRepo.saveAndFlush(instance);
			};
		}else{
			StartRDSResult startRDSResult = new StartRDSResult(ResponseResultMark.WARNING_INSTANCE_STACK_EMPTY);
			return g.getGson().toJson(startRDSResult);
		}
		

		StartRDSResult startRDSResult = new StartRDSResult(ResponseResultMark.SUCCESS);
		return g.getGson().toJson(startRDSResult);
	}

	@Override
	public String stop(String stopApply) {
		StopRDS stopRDSObject = g.getGson().fromJson(stopApply, StopRDS.class);
		Stack<InstanceBase> instanceStack;
		// 判断用户权限
		// 判断服务器状态
		instanceStack = getInstanceStack(stopRDSObject.instanceid);
		if(!instanceStack.isEmpty()){
			while(!instanceStack.isEmpty()){
				InstanceBase instance = instanceStack.pop();
				instance.instancestatus.instanceStatus = RDSCommonConstant.INS_STOPPING;
				instanceBaseRepo.saveAndFlush(instance);
				// 启动mysql服务
				stopInstance(instance);
				// 修改数据库中服务器状态
				instance.instancestatus.instanceStatus = RDSCommonConstant.INS_STOPPED;
				instanceBaseRepo.saveAndFlush(instance);
			};
		}else{
			StopRDSResult stopRDSResult = new StopRDSResult(ResponseResultMark.WARNING_INSTANCE_STACK_EMPTY);
			return g.getGson().toJson(stopRDSResult);
		}
		// 修改数据库中服务器状态

		StopRDSResult stopRDSResult = new StopRDSResult(ResponseResultMark.SUCCESS);
		return g.getGson().toJson(stopRDSResult);
	}
	
	
	/**
	 * 
	 */
	@Override
	public String restart(String restartApply) {
		RestartRDS restartObject = g.getGson().fromJson(restartApply, RestartRDS.class);
		Stack<InstanceBase> instanceStack;
		Stack<InstanceBase> instanceStackBack = new Stack<InstanceBase>();

		instanceStack = getInstanceStack(restartObject.instanceid);
		if(!instanceStack.isEmpty()){
			while(!instanceStack.isEmpty()){
				InstanceBase instance = instanceStack.pop();
				instance.instancestatus.instanceStatus = RDSCommonConstant.INS_STOPPING;
				instanceBaseRepo.saveAndFlush(instance);
				// 启动mysql服务
				stopInstance(instance);
				// 修改数据库中服务器状态
				instance.instancestatus.instanceStatus = RDSCommonConstant.INS_STOPPED;
				instanceBaseRepo.saveAndFlush(instance);
				instanceStackBack.push(instance);
			};
			
			while(!instanceStackBack.isEmpty()){
				InstanceBase instance = instanceStackBack.pop();
				instance.instancestatus.instanceStatus = RDSCommonConstant.INS_STARTING;
				instanceBaseRepo.saveAndFlush(instance);
				// 启动mysql服务
				startInstance(instance);
				// 修改数据库中服务器状态
				instance.instancestatus.instanceStatus = RDSCommonConstant.INS_STARTED;
				instanceBaseRepo.saveAndFlush(instance);
			};
		}else{
			RestartResult restartRDSResult = new RestartResult(ResponseResultMark.WARNING_INSTANCE_STACK_EMPTY);
			return g.getGson().toJson(restartRDSResult);
		}
		
		RestartResult restartRDSResult = new RestartResult(ResponseResultMark.SUCCESS);
		return g.getGson().toJson(restartRDSResult);
	}

	@Override
	public String getinstanceinfo(String getinstanceinfo) {
		GetInstanceInfoRDS getStatusObject = g.getGson().fromJson(getinstanceinfo, GetInstanceInfoRDS.class);
		List<InstanceBase> instanceList = new ArrayList<InstanceBase>();
		EntityToWhere<InstanceBase> e2Where = new EntityToWhere<InstanceBase>();
		// 获取mysql服务状态
		if(null != getStatusObject.sort){
			try {
				instanceList = SpecialQueryRepo.findByInstanceParam(e2Where.entity2WhereSort(getStatusObject.instancebase,getStatusObject.sort));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		} else {
			try {
				instanceList = SpecialQueryRepo.findByInstanceParam(e2Where.entity2Where(getStatusObject.instancebase));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return g.getGson().toJson(instanceList);
	}

}
