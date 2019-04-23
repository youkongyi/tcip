package com.stech.tcip.offerws.dto;

/**
 * 
 * @ClassName:  ContactInfo   
 * @Description:TODO(联系人传输对象)   
 * @author: samuel 
 * @date:   2017年7月28日 下午3:23:04   
 *   
 *
 */
public class ContactInfo {
	private String pkid;// varchar2(20) 业务流水号 n/y
						// 新增用户不需要传入该值，修改、删除用户该字段必需要，数据来源联系人信息同步接口busisn 字段
	private String ownid;// varchar2(20) 联系人归属用户id y 用户id跟用户信息同步接口中的userid对应
	private String name;// varchar2(60) 联系人姓名 y
	private String position;// varchar2(60) 职位 n
	private String contactphone;// varchar2(20) 联系电话 n
	private String mobile;// char(11) 手机 n
	private String fax;// varchar2(20) 传真 n
	private String contactaddr;// varchar2(100) 联系地址 n
	private String zipcode;// char(6) 邮政编码 n
	private String email;// varchar2(60) 电子邮箱 n
	private String newflag;// char(1) y 默认为1
	private String orgcode;// varchar2(20) 组织机构代码 y
	private String dataorgid;// number(10) 分公司id y
	public String getPkid() {
		return pkid;
	}
	public void setPkid(String pkid) {
		this.pkid = pkid;
	}
	public String getOwnid() {
		return ownid;
	}
	public void setOwnid(String ownid) {
		this.ownid = ownid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getContactphone() {
		return contactphone;
	}
	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getContactaddr() {
		return contactaddr;
	}
	public void setContactaddr(String contactaddr) {
		this.contactaddr = contactaddr;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNewflag() {
		return newflag;
	}
	public void setNewflag(String newflag) {
		this.newflag = newflag;
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
	
	

}
