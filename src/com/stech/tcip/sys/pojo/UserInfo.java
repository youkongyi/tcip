package com.stech.tcip.sys.pojo;

/**
 * 
 * @ClassName:  UserInfo   
 * @Description:TODO(用户信息，用于查询)   
 * @author: samuel 
 * @date:   2017年7月10日 下午5:22:11   
 *   
 *
 */
public class UserInfo {
	//用户iD
	private String  userid;
	//证件类型
	private String  certtype;
	//证件号码
	private String  certnum;
	//手机
	private String mobile;
	//IC卡号
	private String cardid;
	
	
	private String startdate;
	
	
	private String enddate;

	
	private String extra;
	
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCerttype() {
		return certtype;
	}
	public void setCerttype(String certtype) {
		this.certtype = certtype;
	}
	public String getCertnum() {
		return certnum;
	}
	public void setCertnum(String certnum) {
		this.certnum = certnum;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
}
