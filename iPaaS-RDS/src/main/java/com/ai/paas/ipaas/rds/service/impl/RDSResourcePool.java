package com.ai.paas.ipaas.rds.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.rds.dao.ImageResourceRepo;
import com.ai.paas.ipaas.rds.dao.ResourcePoolRepo;
import com.ai.paas.ipaas.rds.dbmodel.ResourcePool;
import com.ai.paas.ipaas.rds.manage.rest.interfaces.IRDSResourcePool;
import com.ai.paas.ipaas.rds.utils.GsonSingleton;
import com.alibaba.dubbo.config.annotation.Service;

/** 
 * @author  作者 “WTF” E-mail: 1031248990@qq.com
 * @date 创建时间：2016年7月12日 下午2:43:47 
 * @version 
 * @since  
 */
//@Service("RDSResourcePool")
@Service
@Transactional(rollbackFor = Exception.class)
public class RDSResourcePool implements IRDSResourcePool {

	@Autowired
	GsonSingleton g;
	@Autowired
//	@Qualifier("ResourcePoolRepo")
	ResourcePoolRepo resourcePool;
	@Autowired
//	@Qualifier("ImageResourceRepo")
	ImageResourceRepo imageResourceRepo;
	
	public void printLog(String a){
		Logger log = Logger.getLogger(RDSResourcePool.class.getName());
		log.info(a);
	}
	@Override
	public String add(String getParam) {
		ResourcePool rp = g.getGson().fromJson(getParam, ResourcePool.class);
		resourcePool.save(rp);
		return "success";
	}

	@Override
	public String delete(String getParam) {
		ResourcePool rp = g.getGson().fromJson(getParam, ResourcePool.class);
		resourcePool.delete(rp.resourceid);
		return "success";
	}

	@Override
	public String get(String getParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addImage(String getParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteImage(String getParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImage(String getParam) {
		// TODO Auto-generated method stub
		return null;
	}

}
