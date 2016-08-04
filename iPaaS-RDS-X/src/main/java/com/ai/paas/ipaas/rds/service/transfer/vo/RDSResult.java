package com.ai.paas.ipaas.rds.service.transfer.vo;

import com.ai.paas.ipaas.rds.service.constant.ResponseResultMark;

/** 
 * @author  作者 “WTF” E-mail: 1031248990@qq.com
 * @date 创建时间：2016年7月12日 下午3:09:36 
 * @version 
 * @since  
 */
public class RDSResult implements RDSResultInterface{
	public int status = ResponseResultMark.WARN_INIT_STATUS;
	public String discribe;
	public String content;
	public String ExceptionTrace;
	public RDSResult(int status) {
		super();
		this.status = status;
	}
	public RDSResult(int status, String discribe, String content, String exceptionTrace) {
		super();
		this.status = status;
		this.discribe = discribe;
		this.content = content;
		ExceptionTrace = exceptionTrace;
	}
	public void setStatus(int status){
		this.status = status;
	}
	public RDSResult() {
		super();
	}

}
