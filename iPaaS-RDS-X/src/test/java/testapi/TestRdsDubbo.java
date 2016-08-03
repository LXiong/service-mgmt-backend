package testapi;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsIncBase;
import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsResourcePool;
import com.ai.paas.ipaas.rds.manage.rest.interfaces.IRDSInstanceManager;
import com.ai.paas.ipaas.rds.manage.rest.interfaces.IRDSResourcePool;
import com.ai.paas.ipaas.rds.service.transfer.vo.CancelRDS;
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
//	@Test
//	public void getFuncList() {
//		String funcList = incManager.getFuncList();
//		System.out.println(funcList);
//	}
	
//	pass
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

//	pass
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

//	pass
	@Test
	public void create(){
		Timestamp time = new Timestamp(System.currentTimeMillis()); 
		CreateRDS creatObject = new CreateRDS();
		creatObject.createSlaverNum = 0;
		creatObject.createBatmasterNum = 0;
		creatObject.token = "2FJ3847FQ23UH923RHJDSFH";
		// user_id对应ccs_user_config中的用户
		creatObject.instanceBase = new RdsIncBase("6C4F4DBA96294DDCBC5DBBF2CAD442B5", 
				"mysql_for_docker", "BIU", 5, 100, "","",
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

//	pass
//	@Test
//	public void cancel(){
//		CancelRDS cancelObject = new CancelRDS();
//		cancelObject.user_id = "X";
//		cancelObject.token = "X";
//		cancelObject.instanceid = 21;
//		String request = g.toJson(cancelObject);
//		System.out.println(request);
//		String result = incManager.cancel(request);
//		System.out.println(result);
//	}
	

	
}
