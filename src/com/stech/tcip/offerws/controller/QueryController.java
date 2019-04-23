package com.stech.tcip.offerws.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stech.tcip.offerws.dto.UsersQueryCondiation;
import com.stech.tcip.offerws.services.QueryService;
import com.stech.tcip.sys.pojo.RequestInfo;
import com.stech.tcip.sys.pojo.UserInfo;

/**
 * 
 * @ClassName: QueryController
 * @Description:TODO(查询类接口控制类)
 * @author: samuel
 * @date: 2017年7月31日 下午3:17:34
 * 
 *
 */
@Controller
public class QueryController {

	private static Logger logger = LogManager.getLogger(BusiController.class);

	// 用户信息服务类
	@Autowired
	private QueryService queryService;

	// 请求报文
	@Autowired
	private RequestInfo requestInfo;

	/**
	 * @Title: queryDict
	 * @Description: TODO(查询字典信息)
	 * @param: @param
	 *             typeId
	 * @param: @param
	 *             request
	 * @param: @return
	 * @return: String
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/query_dict/{typeId}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryDict(@PathVariable("typeId") String typeId, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_dict/" + typeId);
		return queryService.queryDict(typeId, requestInfo);
	}

	/**
	 * 
	 * @Title: queryContact
	 * @Description: TODO(根据用户ID查询客户ID)
	 * @param: @param
	 *             userid
	 * @param: @param
	 *             request
	 * @param: @return
	 * @param: @throws
	 *             JsonProcessingException
	 * @return: String
	 */
	@RequestMapping(value ="query_contact/{userid}",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryContact(@PathVariable("userid") String userid, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/queryContact/" + userid);
		return queryService.queryContact(userid, requestInfo);
	}

	/**
	 * 
	 * @Title: queryUser
	 * @Description: TODO(精确查询用户)
	 * @param userInfo
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_user", consumes = "application/json",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryUser(@RequestBody UserInfo userInfo, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_user");
		return queryService.queryUser(userInfo, requestInfo);
	}

	/**
	 * 
	 * @Title: queryUsers
	 * @Description: TODO(批量查询用户)
	 * @param usersQueryCondiation
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_users", consumes = "application/json",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryUsers(@RequestBody UsersQueryCondiation usersQueryCondiation, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_users");
		return queryService.queryUsers(usersQueryCondiation, requestInfo);
	}

	/**
	 * 
	 * @Title: queryUsermeter
	 * @Description: TODO(根据用户ID查询用户表具信息)
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_usermeter",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryUsermeter(String userid,String lastdate,String state,HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		return queryService.queryUsermeter(userid,lastdate,state, requestInfo);
	}

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
	@RequestMapping(value = "/query_icinfo/{userid}",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String query_icinfoNoResid(@PathVariable("userid") String userid, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_icinfo/" + userid) ;
		return queryService.queryIcinfo(userid, requestInfo);
	}
	
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
	@RequestMapping(value = "/query_icinfo/{userid}/{resid}",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryIcinfo(@PathVariable("userid") String userid, @PathVariable("resid") String resid, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_icinfo/" + userid + "/" + resid);
		return queryService.queryIcinfo(userid, resid, requestInfo);
	}
	

	/**
	 * 
	 * @Title: queryUserprice
	 * @Description: TODO(查询用户气价信息)
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_userprice/{userid}",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryUserprice(@PathVariable("userid") String userid, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_userprice/" + userid);
		return queryService.queryUserprice(userid, requestInfo);
	}

	/**
	 * 
	 * @Title: queryUseamount
	 * @Description: TODO(查询用户当前阶梯使用量)
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_useamount/{userid}",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryUseamount(@PathVariable("userid") String userid, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_useamount/" + userid);
		return queryService.queryUseamount(userid, requestInfo);
	}

	/**
	 * 
	 * @Title: queryUserpresavingc
	 * @Description: TODO(查询用户预存)
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_userpresavingc/{userid}",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryUserpresavingc(@PathVariable("userid") String userid, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_userpresavingc/" + userid);
		return queryService.queryUserpresavingc(userid, requestInfo);
	}

	/**
	 * 
	 * @Title: queryBills
	 * @Description: TODO(气费账单查询)
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_bills",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryBills(String userid, int pageno, int pagesize,String feetype, String batchid, String yrmonth, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_bills" );
		return queryService.queryBills(userid,pageno,pagesize,feetype,batchid,yrmonth,requestInfo);
	}

	/**
	 * 
	 * @Title: queryArrearage
	 * @Description: TODO(查询用户欠费信息)
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_arrearage",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryArrearage(String userid, int pageno, int pagesize, String yrmonth, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_arrearage/" + userid);
		return queryService.queryArrearage(userid, pageno, pagesize, yrmonth, requestInfo);
	}

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
	@RequestMapping(value = "/query_icpayrec",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryIcpayrec(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_icpayrec");
		return queryService.queryIcpayrec(jsonStr, requestInfo);
	}

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
	@RequestMapping(value = "/query_payrec",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryPayrec(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_payrec");
		return queryService.queryPayrec(jsonStr, requestInfo);
	}

	/**
	 * 
	 * @Title: queryUser
	 * @Description: TODO(IC卡充值前校验)
	 * @param userInfo
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_icvalidate", consumes = "application/json",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryIcvalidate(@RequestBody String icvalidate, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_icvalidate");
		return queryService.queryIcvalidate(icvalidate, requestInfo);
	}

	/**
	 * 
	 * @Title: queryRecorddata
	 * @Description: TODO(查询用户抄表历史)
	 * @param userid
	 * @param pageno
	 * @param pagesize
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_recorddata/{userid}",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryRecorddata(@PathVariable("userid")

	String userid, int pageno, int pagesize, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_recorddata/" + userid);
		return queryService.queryRecorddata(userid, requestInfo, pageno, pagesize);
	}

	/**
	 * 
	 * @Title: queryValidaterecordcycle
	 * @Description: TODO(查询用户是否在抄表周期内)
	 * @param userid
	 *            用户ID
	 * @param request
	 *            请求信息
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_validaterecordcycle/{userid}",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryValidaterecordcycle(@PathVariable("userid") String userid, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_validaterecordcycle/" + userid);
		return queryService.queryValidaterecordcycle(userid, requestInfo);
	}

	/**
	 * 
	 * @Title: busiOnwayorder
	 * @Description: TODO(在途工单查询)
	 * @param userid
	 *            用户ID
	 * @param request
	 *            请求信息
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_onwayorder/{userid}/{busitype}",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiOnwayorder(@PathVariable("userid")

	String userid, @PathVariable("busitype") String busitype, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busi_onwayorder/" + userid);
		return queryService.busiOnwayorder(userid, busitype, requestInfo);
	}

	@RequestMapping(value = "/query_lastreading/{userid}",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryLastreading(@PathVariable("userid") String userid, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_lastreading/" + userid);
		return queryService.queryLastreading(userid, requestInfo);
	}

	/**
	 * 
	 * @Title: queryOrders
	 * @Description: TODO(查询用户工单信息)
	 * @param userid
	 *            用户ID
	 * @param pageno
	 *            当前页
	 * @param pagesize
	 *            页面大小
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_orders/{userid}",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryOrders(@PathVariable("userid") String userid, int pageno, int pagesize, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_orders/" + userid);
		return queryService.queryOrders(userid, requestInfo, pageno, pagesize);
	}

	/**
	 * 
	 * @Title: queryInhouseappliance
	 * @Description: TODO(内购燃气具信息查询)
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_inhouseappliance",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryInhouseappliance(String userid,String orderid, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_inhouseappliance");
		return queryService.queryInhouseappliance(userid,orderid, requestInfo);
	}

	/**
	 * 
	 * @Title: queryOuthouseappliance
	 * @Description: TODO(外网燃气具信息查询)
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_outhouseappliance/{userid}",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryOuthouseappliance(@PathVariable("userid") String userid, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_outhouseappliance/" + userid);
		return queryService.queryOuthouseappliance(userid, requestInfo);
	}

	/**
	 * 
	 * @Title: querySecurity
	 * @Description: TODO(查询用户最后一次安检情况)
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_security/{userid}",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String querySecurity(@PathVariable("userid") String userid, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");

		logger.info("/query_security/" + userid);
		return queryService.querySecurity(userid, requestInfo);
	}

	/**
	 * 
	 * @Title: queryHidden
	 * @Description: TODO(查询安检隐患情况)
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_hidden/{pkid}",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryHidden(@PathVariable("pkid") String pkid, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_hidden/" + pkid);
		return queryService.queryHidden(pkid, requestInfo);
	}
	
	/**
	 * 
	 * @Title: queryHidden
	 * @Description: TODO(查询安检隐患情况)
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_stationusers",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryStationusers(@RequestBody String stationcode, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_stationusers/" + stationcode);
		return queryService.queryStationusers(stationcode, requestInfo);
	}
	
	/**
	 * 
	 * @Title: query_firefail
	 * @Description: TODO(查询点火失败配置信息)
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_firefail/{pid}",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryFirefail(@PathVariable("pid") String pid, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/queryFirefail/" + pid);
		return queryService.queryFirefail(pid, requestInfo);
	}
	
	/**
	 * 
	 * @Title: query_factory
	 * @Description: TODO(查询厂商信息)
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_factory",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryFactory(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_factory");
		return queryService.queryFactory(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: query_material
	 * @Description: TODO(查询材料)
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_material",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryMaterial(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/queryMaterial");
		return queryService.queryMaterial(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: query_operator
	 * @Description: TODO(查询材料)
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_operator",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryOperator(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/queryOperator");
		return queryService.queryOperator(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: queryBusirec   
	 * @Description: TODO(查询业务记录)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_busirec",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryBusirec(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_busirec");
		return queryService.queryBusirec(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: queryDetailorder   
	 * @Description: TODO(查询工单详情)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_detailorder",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryDetailorder(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_detailorder");
		return queryService.queryDetailorder(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: queryDetailorder   
	 * @Description: TODO(查询实时地址)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_addr",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryAddr(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_addr");
		return queryService.queryAddr(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: queryIcpayrec
	 * @Description: TODO(查询燃气具缴费历史 )
	 * @param userid
	 * @param pageno
	 * @param pagesize
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_gspayrec",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryGspayrec(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_gspayrec");
		return queryService.queryGspayrec(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: queryYrmonth
	 * @Description: TODO(查询系统账期 )
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_yrmonth",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryYrmonth(HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_yrmonth");
		return queryService.queryYrmonth(requestInfo);
	}
	
	/**
	 * 
	 * @Title: queryBankinfo
	 * @Description: TODO(查询银行信息 )
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/query_bankinfo",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryBankinfo(HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/query_bankinfo");
		return queryService.queryBankinfo(requestInfo);
	}	
	
}
