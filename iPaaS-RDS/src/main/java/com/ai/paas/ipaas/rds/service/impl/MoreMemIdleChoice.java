package com.ai.paas.ipaas.rds.service.impl;

import java.util.List;

import com.ai.paas.ipaas.rds.dao.wo.ResourcePool;


/** 
 * @author  作者 “WTF” E-mail: 1031248990@qq.com
 * @date 创建时间：2016年7月13日 下午2:31:10 
 * @version 
 * @since  
 */
public class MoreMemIdleChoice implements ChoiceRes{

	@Override
	public ResourcePool choiceOne(List<ResourcePool> canUseResList) {
		ResourcePool maxMemRes = canUseResList.get(0);
		for(int i = 0; i < canUseResList.size(); i++){
			if((maxMemRes.totalmemory-maxMemRes.usedmemory) < (canUseResList.get(i).totalmemory-canUseResList.get(i).usedmemory)){
				maxMemRes = canUseResList.get(i);
			}
		}
		return maxMemRes;
	}
	public ResourcePool choiceOne(List<ResourcePool> canUseResList, List<ResourcePool> exceptList) {
		canUseResList.removeAll(exceptList);
		if(canUseResList.size() < 0){
			return null;
		}
		ResourcePool maxMemRes = canUseResList.get(0);
		for(int i = 0; i < canUseResList.size(); i++){
			if((maxMemRes.totalmemory-maxMemRes.usedmemory) < (canUseResList.get(i).totalmemory-canUseResList.get(i).usedmemory)){
				maxMemRes = canUseResList.get(i);
			}
		}
		return maxMemRes;
	}

}
