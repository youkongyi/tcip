package com.stech.tcip.offerws.dto;

public class FeeCondition {
	private String userid;//	varchar2(20)	用户id	y	
	private String outbusisn;//	varchar2(20)	vcc业务流水号	y	vcc平台缴费业务流水号，供对帐使用。
	private String outdate;//	char(8)	缴费日期	y	yyyymmdd
	private String acctshtids;//	varchar2(500)	缴费的帐单信息、多笔账单用竖线分隔开	n/y	当没账单直接缴纳预存时或者预收气费该字段不需要传值
	private String feetype;//	varchar2(5)	费用类型	y	字典类型：zw_feetype。
	private String paytype;//	char(1)	支付类型	y	字典：kh_acctinfo_paytype
	private String paymode;//	char(1)	支付方式	y	字典：zw_feemedium
	private String paysum;//	number(18)	缴费金额	y
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOutbusisn() {
		return outbusisn;
	}
	public void setOutbusisn(String outbusisn) {
		this.outbusisn = outbusisn;
	}
	public String getOutdate() {
		return outdate;
	}
	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}
	public String getAcctshtids() {
		return acctshtids;
	}
	public void setAcctshtids(String acctshtids) {
		this.acctshtids = acctshtids;
	}
	public String getFeetype() {
		return feetype;
	}
	public void setFeetype(String feetype) {
		this.feetype = feetype;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String getPaymode() {
		return paymode;
	}
	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}
	public String getPaysum() {
		return paysum;
	}
	public void setPaysum(String paysum) {
		this.paysum = paysum;
	}
}
