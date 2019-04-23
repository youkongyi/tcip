package com.stech.tcip.offerws.dto;

import java.util.Date;

/**
 * 
 * @ClassName:  UsersQueryCondiation   
 * @Description:TODO(数据传输对象，用用户信息查询条件)   
 * @author: samuel 
 * @date:   2017年7月31日 上午9:06:21   
 *   
 *
 */
public class UsersQueryCondiation {
	private String useraddr;//	varchar2(50)	用户地址	y	
	private String useraddrdetail;//	varchar2(200)	用户地址明细	n	
	private String addrlvl;//	char(1)	地址级别	y	现阶段只支持小区、楼栋
	private String zy_addrinfo;//_addrlvl
	private String pageno;//	number(10)	页码	y	
	private String pagesize;//	number(10)	每页记录数	y	
	private String startdate;
	private String enddate;
	
	
	public String getUseraddr() {
		return useraddr;
	}
	public void setUseraddr(String useraddr) {
		this.useraddr = useraddr;
	}
	public String getUseraddrdetail() {
		return useraddrdetail;
	}
	public void setUseraddrdetail(String useraddrdetail) {
		this.useraddrdetail = useraddrdetail;
	}
	public String getAddrlvl() {
		return addrlvl;
	}
	public void setAddrlvl(String addrlvl) {
		this.addrlvl = addrlvl;
	}
	public String getZy_addrinfo() {
		return zy_addrinfo;
	}
	public void setZy_addrinfo(String zy_addrinfo) {
		this.zy_addrinfo = zy_addrinfo;
	}
	public String getPageno() {
		return pageno;
	}
	public void setPageno(String pageno) {
		this.pageno = pageno;
	}
	public String getPagesize() {
		return pagesize;
	}
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}
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
}
