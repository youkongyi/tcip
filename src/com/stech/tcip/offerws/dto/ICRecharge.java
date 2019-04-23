package com.stech.tcip.offerws.dto;//

public class ICRecharge {
	private String outbusisn;//	varchar2(20)	vcc业务流水号	y	vcc平台缴费业务流水号，供对帐使用。
	private String outdate;//	char(8)	缴费日期	y	yyyymmdd
	private String cardid;//	varchar2(20)	ic卡号	y	
	private String userid;//	varchar2(20)	用户id	y	
	private String paymode;//	char(1)	支付方式	y	字典：zw_feemedium;//
	private String amount;//	number(20,5)	气量	y	
	private String chrgsum;//	varchar2(20)	气费总额	y
	
	
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
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPaymode() {
		return paymode;
	}
	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getChrgsum() {
		return chrgsum;
	}
	public void setChrgsum(String chrgsum) {
		this.chrgsum = chrgsum;
	}
	
	

}
