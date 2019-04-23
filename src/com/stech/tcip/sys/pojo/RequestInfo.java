package com.stech.tcip.sys.pojo;

import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName:  RequestInfo   
 * @Description:TODO(报文请求头)   
 * @author: samuel 
 * @date:   2017年7月10日 下午2:17:28   
 *   
 *
 */
@Component
public class RequestInfo {

	private String appid;		//CHAR(20)	请求系统	第三方应用名 VCC
	private String requestid;	//CHAR(50)	服务代码	参考3.2服务清单
	private String messageid;	//CHAR(4)	业务代码	
	private String orgcode;		//CHAR(10)	机构代码	
	private String dataorgid;	//NUMBER(10)	分公司ID	

	//消息体
	private Map<String,String> body;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}

	public String getMessageid() {
		return messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public String getDataorgid() {
		return dataorgid;
	}

	public void setDataorgid(String dataorgid) {
		this.dataorgid = dataorgid;
	}

	public Map<String, String> getBody() {
		return body;
	}

	public void setBody(Map<String, String> body) {
		this.body = body;
	}
	
	
}
