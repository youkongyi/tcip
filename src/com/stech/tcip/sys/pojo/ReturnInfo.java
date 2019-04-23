package com.stech.tcip.sys.pojo;

import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName:  ReturnInfo   
 * @Description:TODO(服务请求返回对象)   
 * @author: samuel 
 * @date:   2017年7月10日 上午10:57:49   
 *
 */
@Component
public class ReturnInfo {

	//返回结果码
	private String result;
	
	//返回结果信息
	private String msg;

	
	public ReturnInfo() {

	}
	
	public ReturnInfo(String result) {
		super();
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
