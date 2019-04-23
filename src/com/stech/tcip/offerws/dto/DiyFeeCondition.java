package com.stech.tcip.offerws.dto;

public class DiyFeeCondition {

	private String userid;//	varchar2(20)	用户id	y	
	private String meterinfopkid;//	varchar2(25)	表具主键	y	
	private String resid;//	varchar2(20)	表具编号	y	
	private String lastreading;//	number(15,5)	上期读数	y	
	private String currreading;//	number(15,5)	本期读数	y	
	private String recordamount;//	number(18,5)	抄表气量	y	
	private String datasource;//	char(1)	数据来源	y	‘a’ : 微信‘c’: 网厅
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getMeterinfopkid() {
		return meterinfopkid;
	}
	public void setMeterinfopkid(String meterinfopkid) {
		this.meterinfopkid = meterinfopkid;
	}
	public String getResid() {
		return resid;
	}
	public void setResid(String resid) {
		this.resid = resid;
	}
	public String getLastreading() {
		return lastreading;
	}
	public void setLastreading(String lastreading) {
		this.lastreading = lastreading;
	}
	public String getCurrreading() {
		return currreading;
	}
	public void setCurrreading(String currreading) {
		this.currreading = currreading;
	}
	public String getRecordamount() {
		return recordamount;
	}
	public void setRecordamount(String recordamount) {
		this.recordamount = recordamount;
	}
	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
	
}
