package com.stech.tcip.sys.dto;

/**
 * 
 * @ClassName:  AppAuthorizes   
 * @Description:TODO(数据传输对象，应用的授权情况)   
 * @author: samuel 
 * @date:   2017年7月21日 下午4:28:27   
 *   
 *
 */
public class AppAuthorizes {
	
	private String appId;
	
	private String appName;
	
    private String interServiceId;

    private String tciscode;

    private String tcipcode;

    private String type;

    private String name;

    private String desc;
    
    //是否有权限
    private String authorizeFlag;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getInterServiceId() {
		return interServiceId;
	}

	public void setInterServiceId(String interServiceId) {
		this.interServiceId = interServiceId;
	}

	public String getAuthorizeFlag() {
		return authorizeFlag;
	}

	public void setAuthorizeFlag(String authorizeFlag) {
		this.authorizeFlag = authorizeFlag;
	}

	public String getTciscode() {
		return tciscode;
	}

	public void setTciscode(String tciscode) {
		this.tciscode = tciscode;
	}

	public String getTcipcode() {
		return tcipcode;
	}

	public void setTcipcode(String tcipcode) {
		this.tcipcode = tcipcode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
    
    

}
