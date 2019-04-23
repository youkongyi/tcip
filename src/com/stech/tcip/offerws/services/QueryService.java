package com.stech.tcip.offerws.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stech.tcip.offerws.dto.UsersQueryCondiation;
import com.stech.tcip.sys.pojo.RequestInfo;
import com.stech.tcip.sys.pojo.UserInfo;

/**
 * 
 * @ClassName:  UserInfoService   
 * @Description:TODO(客户信息查询服务类)   
 * @author: samuel 
 * @date:   2017年7月11日 下午3:23:59   
 *   
 *
 */
public interface QueryService {

	
	/**
	 * 
	 * @Title: queryUser   
	 * @Description: TODO(精确查询用户)   
	 * @param:       
	 * @return: String      
	 * @throws
	 */
	public String queryUser(UserInfo userInfo,RequestInfo info) throws JsonProcessingException;
	
	
	/**
	 * 
	 * @Title: queryDict   
	 * @Description: TODO(查询字典信息)   
	 * @param typeId
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String queryDict(String typeId,RequestInfo requestInfo) throws JsonProcessingException;
	
	/**
	 * 
	 * @Title: queryContact   
	 * @Description: TODO(根据用户ID查询用户信息)   
	 * @param: @param userid
	 * @param: @param request
	 * @param: @return
	 * @param: @throws JsonProcessingException      
	 * @return: String      
	 */
	public String queryContact(String userid,RequestInfo requestInfo) throws JsonProcessingException;


	/**
	 * 
	 * @Title: queryUsers   
	 * @Description: TODO(批量查询用户信息)   
	 * @param userInfo
	 * @param requestInfo
	 * @return:String
	 * @throws JsonProcessingException 
	 */
	public String queryUsers(UsersQueryCondiation usersQueryCondiation, RequestInfo requestInfo) throws JsonProcessingException;


	/**
	 * 
	 * @Title: queryUsermeter   
	 * @Description: TODO(根据用户ID查询用户表具信息)   
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String queryUsermeter(String userid,String lastdate,String state, RequestInfo requestInfo) throws JsonProcessingException;

	/**
	 * 
	 * @Title: queryIcinfo   
	 * @Description: TODO(查询用户IC卡信息)   
	 * @param userid
	 * @param resid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String queryIcinfo(String userid, String resid, RequestInfo requestInfo) throws JsonProcessingException;

	/**
	 * 
	 * @Title: queryIcinfo   
	 * @Description: TODO(查询用户IC卡信息)   
	 * @param userid
	 * @param resid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String queryIcinfo(String userid, RequestInfo requestInfo) throws JsonProcessingException;
	
	/**
	 * 
	 * @Title: queryUserprice   
	 * @Description: TODO(查询用户气价信息)   
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String queryUserprice(String userid, RequestInfo requestInfo) throws JsonProcessingException;

	

	/**
	 * 
	 * @Title: queryUseamount   
	 * @Description: TODO(查询用户当前阶梯使用量)   
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String queryUseamount(String userid, RequestInfo requestInfo) throws JsonProcessingException;

	/**
	 * 
	 * @Title: queryUserpresavingc   
	 * @Description: TODO(查询用户预存)   
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String queryUserpresavingc(String userid, RequestInfo requestInfo) throws JsonProcessingException;

	/**
	 * 
	 * @Title: queryBills   
	 * @Description: TODO(气费账单查询)   
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String queryBills(String userid, int pageno, int pagesize,String feetype, String batchid, String yrmonth, RequestInfo requestInfo) throws JsonProcessingException;


	/**
	 * 
	 * @Title: queryArrearage   
	 * @Description: TODO(查询用户欠费信息)   
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String queryArrearage(String userid, int pageno, int pagesize, String yrmonth, RequestInfo requestInfo) throws JsonProcessingException;


	/**
	 * 
	 * @Title: queryIcpayrec   
	 * @Description: TODO(查询用户IC卡充值历史 )   
	 * @param userid
	 * @param pageno
	 * @param pagesize
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String queryIcpayrec(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;


	/**
	 * 
	 * @Title: queryIcpayrec   
	 * @Description: TODO(查询用户缴费历史 )   
	 * @param userid
	 * @param pageno
	 * @param pagesize
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String queryPayrec(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	/**
	 * 
	 * @Title: queryUser
	 * @Description: TODO(IC卡充值前校验)
	 * @param userInfo
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String queryIcvalidate(String icvalidate, RequestInfo requestInfo) throws JsonProcessingException;


	/**
	 * 
	 * @Title: queryRecorddata   
	 * @Description: TODO(查询用户抄表历史 )   
	 * @param userid
	 * @param requestInfo
	 * @return:String
	 */
	public String queryRecorddata(String userid, RequestInfo requestInfo,int pageno,int pagesize) throws JsonProcessingException;



	/**
	 * 
	 * @Title: queryValidaterecordcycle   
	 * @Description: TODO(查询用户是否在抄表周期内)   
	 * @param userid 用户ID
	 * @param request 请求信息
	 * @return:String
	 */
	public String queryValidaterecordcycle(String userid, RequestInfo requestInfo) throws JsonProcessingException;

	/**
	 * 
	 * @Title: queryLastreading   
	 * @Description: TODO(自报上期止码查询)   
	 * @param userid 用户ID
	 * @param request 请求信息
	 * @return:String
	 */
	public String queryLastreading(String userid, RequestInfo requestInfo) throws JsonProcessingException;


	/**
	 * 
	 * @Title: queryOrders   
	 * @Description: TODO(查询用户工单信息)   
	 * @param userid 用户ID
	 * @param pageno 当前页
	 * @param pagesize 页面大小
	 * @param requestInfo
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String queryOrders(String userid, RequestInfo requestInfo, int pageno, int pagesize)  throws JsonProcessingException ;


	/**
	 * 
	 * @Title: queryInhouseappliance   
	 * @Description: TODO(内购燃气具信息查询)   
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String queryInhouseappliance(String userid,String ordierid, RequestInfo requestInfo) throws JsonProcessingException ;

	/**
	 * 
	 * @Title: queryOuthouseappliance   
	 * @Description: TODO(外网燃气具信息查询)   
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String queryOuthouseappliance(String userid, RequestInfo requestInfo) throws JsonProcessingException ;


	/**
	 * 
	 * @Title: querySecurity   
	 * @Description: TODO(查询用户最后一次安检情况)   
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String querySecurity(String userid, RequestInfo requestInfo)  throws JsonProcessingException;

	/**
	 * 
	 * @Title: queryHidden   
	 * @Description: TODO(查询安检隐患情况)   
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String queryHidden(String userid, RequestInfo requestInfo)  throws JsonProcessingException;


	/**
	 * 
	 * @Title: busiOnwayorder   
	 * @Description: TODO(在途工单查询)   
	 * @param userid 用户ID
	 * @param request 请求信息
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String busiOnwayorder(String userid, String busitype,RequestInfo requestInfo)  throws JsonProcessingException;


	/**
	 * 
	 * @Title: queryStationusers   
	 * @Description: TODO(查询站箱用户信息)   
	 * @param stationcode
	 * @param requestInfo
	 * @return:String
	 */
	public String queryStationusers(String stationcode, RequestInfo requestInfo) throws JsonProcessingException;


	public String queryOperator(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;


	public String queryMaterial(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;


	public String queryFactory(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;


	public String queryFirefail(String pid, RequestInfo requestInfo) throws JsonProcessingException;


	public String queryBusirec(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;


	public String queryDetailorder(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;
	
	public String queryAddr(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;
	
	public String queryGspayrec(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;
	
	public String queryYrmonth(RequestInfo requestInfo) throws JsonProcessingException;
	
	public String queryBankinfo(RequestInfo requestInfo) throws JsonProcessingException;
	 
}
