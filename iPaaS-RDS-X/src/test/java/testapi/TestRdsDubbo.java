package testapi;

import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsIncBase;
import com.ai.paas.ipaas.rds.manage.rest.interfaces.IRDSInstanceManager;
import com.ai.paas.ipaas.rds.manage.rest.interfaces.IRDSResourcePool;
import com.ai.paas.ipaas.rds.service.transfer.vo.CreateRDS;
import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/dubbo/consumer/rds-consumer.xml" })

public class TestRdsDubbo {
	@Reference
	private IRDSInstanceManager incManager;
	@Reference
	private IRDSResourcePool resMananger;
	
	Gson g = new Gson();
	/**
	 * passed
	 */
//	@Test
//	public void getFuncList() {
//		String funcList = incManager.getFuncList();
//		System.out.println(funcList);
//	}
	
	/**
	 * passed
	 * 解析方法:不用解析，为字符串
	 */
//	@Test
//	public void addRes(){
//		
//		Timestamp time = new Timestamp(System.currentTimeMillis()); 
////		RdsResourcePool rdsRes = new  RdsResourcePool("192.168.1.125",50000,5000,5001,1,"hbhb123","hbhb123",1,2000000,20,"/home",time,time);
//		RdsResourcePool rdsRes = new  RdsResourcePool("10.1.245.226",50000,5000,5001,1,"root","123456",1,2000000,20,"percona_volumn/data",time,time);
//		String request = g.toJson(rdsRes);
//		System.out.println(request);
//		String result = resMananger.add(request);
//		System.out.println(result);
//	}

	/**
	 * passed
	 * 解析方法:不用解析，为字符串
	 */
//	@Test
//	public void deleteRes(){
//		
//		RdsResourcePool rdsRes = new  RdsResourcePool();
//		rdsRes.setResourceid(1);
//		String request = g.toJson(rdsRes);
//		System.out.println(request);
//		String result = resMananger.delete(request);
//		System.out.println(result);
//	}

	/**
	 * passed
	 * 解析方法:CreateRDSResult ct = g.fromGson(obj,CreateRDSResult.class)
	 * 主要是status值有用
	 */
	@Test
	public void create(){
		Timestamp time = new Timestamp(System.currentTimeMillis()); 
		CreateRDS creatObject = new CreateRDS();
		creatObject.createSlaverNum = 1;
		creatObject.createBatmasterNum = 0;
		creatObject.token = "2FJ3847FQ23UH923RHJDSFH";
		// user_id对应ccs_user_config中的用户
		creatObject.instanceBase = new RdsIncBase("6C4F4DBA96294DDCBC5DBBF2CAD442B5", 
				"testmysql", "BIU", 5, 100, "","",
				"mysql6", "", 0, 1, "BIU,MYSQL,TEST",
				"BEIJING", 1, "no describe", "/aifs01", 
				"/aifs01/mysqldata","", "192.168.*.*", 
				"root", "root", "containerName",
				"1234", 50000, 2000, 123, 500,time,time);
		String request = g.toJson(creatObject);
		System.out.println(request);
		String result = incManager.create(request);
		System.out.println(result);
	}
	
	/**
	 * 
	 */
//	@Test
//	public void createslobm(){
//		Timestamp time = new Timestamp(System.currentTimeMillis());
//		CreateSRDS createObject = new CreateSRDS();
//		createObject.masterinstanceid = 58;
//		createObject.thisInstanceType = 2;
//		String request = g.toJson(createObject);
//		System.out.println(request);
//		String result = incManager.createslobm(request);
//		System.out.println(result);
//	}

	/**
	 * passed
	 * 解析方法:CancelRDSResult ct = g.fromGson(obj,CancelRDSResult.class)
	 * 主要是status值有用
	 */
//	@Test
//	public void cancel(){
//		CancelRDS cancelObject = new CancelRDS();
//		cancelObject.user_id = "X";
//		cancelObject.token = "X";
//		cancelObject.instanceid = 73;
//		String request = g.toJson(cancelObject);
//		System.out.println(request);
//		String result = incManager.cancel(request);
//		System.out.println(result);
//	}
	
	/**
	 * passed
	 * 解析方法:StopRDSResult ct = g.fromGson(obj,StopRDSResult.class)
	 * 主要是status值有用
	 */
//	@Test
//	public void stop(){
//		StopRDS stopObject = new StopRDS();
//		stopObject.user_id = 123123;
//		stopObject.instanceid = 49;
//		stopObject.token = 123123;
//		String request = g.toJson(stopObject);
//		System.out.println(request);
//		String result = incManager.stop(request);
//		System.out.println(result);
//	}
	
	/**
	 * passed
	 * 解析方法:StartRDSResult ct = g.fromGson(obj,StartRDSResult.class)
	 * 主要是status值有用
	 */
//	@Test
//	public void start(){
//		StartRDS startObject = new StartRDS();
//		startObject.user_id = 123123;
//		startObject.instanceid = 49;
//		startObject.token = 123123;
//		String request = g.toJson(startObject);
//		System.out.println(request);
//		String result = incManager.start(request);
//		System.out.println(result);
//	}
	
}
