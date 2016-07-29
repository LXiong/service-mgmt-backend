package com.ai.paas.ipaas.rds.service.impl;

import java.util.List;

import com.ai.paas.ipaas.rds.dao.mapper.bo.RdsResourcepool;



/** 
 * @author  作者 “WTF” E-mail: 1031248990@qq.com
 * @date 创建时间：2016年7月13日 下午2:31:10 
 * @version 
 * @since  
 */
public class MoreMemIdleChoice implements ChoiceRes{

	@Override
	public RdsResourcepool choiceOne(List<RdsResourcepool> canUseResList) {
		RdsResourcepool maxMemRes = canUseResList.get(0);
		for(int i = 0; i < canUseResList.size(); i++){
			if((maxMemRes.getTotalmemory()-maxMemRes.getUsedmemory()) < (canUseResList.get(i).getTotalmemory()-canUseResList.get(i).getUsedmemory())){
				maxMemRes = canUseResList.get(i);
			}
		}
		return maxMemRes;
	}
	public RdsResourcepool choiceOne(List<RdsResourcepool> canUseResList, List<RdsResourcepool> exceptList) {
		canUseResList.removeAll(exceptList);
		if(canUseResList.size() < 0){
			return null;
		}
		RdsResourcepool maxMemRes = canUseResList.get(0);
		for(int i = 0; i < canUseResList.size(); i++){
			if((maxMemRes.getTotalmemory()-maxMemRes.getUsedmemory()) < (canUseResList.get(i).getTotalmemory()-canUseResList.get(i).getUsedmemory())){
				maxMemRes = canUseResList.get(i);
			}
		}
		return maxMemRes;
	}

}
