package com.stech.tcip.offerws.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stech.tcip.offerws.dto.UsersQueryCondiation;
import com.stech.tcip.offerws.services.QueryService;
import com.stech.tcip.sys.pojo.RequestInfo;
import com.stech.tcip.sys.pojo.ReturnInfo;
import com.stech.tcip.sys.pojo.UserInfo;
import com.stech.tcip.sys.services.InvokeTCISService;
import com.stech.tcip.sys.util.Utils;

/**
 * 
 * @ClassName: UserInfoService
 * @Description:TODO(客户信息查询服务类)
 * @author: samuel
 * @date: 2017年7月11日 下午3:23:59
 * 
 *
 */
@Service("queryService")
public class QueryServiceImpl implements QueryService {

	private static final Logger logger = LogManager.getLogger(QueryServiceImpl.class);

	@Autowired
	private InvokeTCISService invokeTCISService;

	// 请求返回信息
	@Autowired
	private ReturnInfo returnInfo;

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
	public String queryDict(String typeId, RequestInfo requestInfo) throws JsonProcessingException {
		// 获取请求头
		requestInfo.setMessageid("1001");

		// 获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("typeid", typeId);
		requestInfo.setBody(reqBody);

		// 将请求信息转成json
		String reqMsg = Utils.ObectToJson(requestInfo);

		logger.info("reqMsg" + reqMsg);
		// 获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
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
	public String queryContact(String userid, RequestInfo requestInfo) throws JsonProcessingException {

		// 获取请求头
		requestInfo.setMessageid("1002");

		// 获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("userid", userid);
		requestInfo.setBody(reqBody);

		// 将请求信息转成json
		String reqMsg = Utils.ObectToJson(requestInfo);

		logger.info("reqMsg" + reqMsg);
		// 获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
	}

	/**
	 * 
	 * @Title: queryUser @Description: TODO(精确查询用户) @param: @return:
	 * String @throws
	 */
	@Override
	public String queryUser(UserInfo userInfo, RequestInfo requestInfo) throws JsonProcessingException {

		// 设置请求码
		requestInfo.setMessageid("1003");

		// 验证是否有入参
		// if((userInfo.getCardid()==null) && (userInfo.getCertnum() == null) &&
		// (userInfo.getCerttype() == null )
		// && (userInfo.getMobile() == null)&& (userInfo.getUserid() ==
		// null)&&(userInfo.getStartdate()==null)&&(userInfo.getEnddate()
		// ==null)){
		// returnInfo.setResult("4004");
		// returnInfo.setMsg("至少有一个业务数据入参");
		// return Utils.ObectToJson(returnInfo);
		// }

		// 证件类型不为空时，证件号码是必须的
		if (userInfo.getCerttype() != null) {
			if (userInfo.getCertnum() == null) {
				returnInfo.setResult("4_1003_01");
				returnInfo.setMsg("证件类型不为空时，证件号码是必须的");
				return Utils.ObectToJson(returnInfo);
			}
		}

		String bodyString = Utils.ObectToJson(userInfo);

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParamForQuery(requestInfo, bodyString);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	/**
	 * 
	 * @Title: queryUsers
	 * @Description: TODO(批量查询用户信息)
	 * @param userInfo
	 * @param requestInfo
	 * @return:String
	 * @throws JsonProcessingException
	 */
	@Override
	public String queryUsers(UsersQueryCondiation usersQueryCondiation, RequestInfo requestInfo) throws JsonProcessingException {
		// 设置请求码
		requestInfo.setMessageid("1004");
		// if (usersQueryCondiation.getUseraddr() =="" ||
		// usersQueryCondiation.getUseraddr() == null){
		// returnInfo.setResult("4_1004_01");
		// returnInfo.setMsg("批量查询用户信息，地址ID是必须的");
		// return Utils.ObectToJson(returnInfo);
		// }

		// 分页单页大于500条 设置为500条
		if (Integer.parseInt(usersQueryCondiation.getPagesize()) > 500) {
			usersQueryCondiation.setPagesize("500");
		}

		String bodyStr = Utils.ObectToJson(usersQueryCondiation);

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, bodyStr);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	@Override
	public String queryUsermeter(String userid,String lastdate,String state, RequestInfo requestInfo) throws JsonProcessingException {
		// 获取请求头
		requestInfo.setMessageid("1005");

		// 获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("userid", userid);
		reqBody.put("lastdate", lastdate);
		reqBody.put("state", state);
		requestInfo.setBody(reqBody);

		// 将请求信息转成json
		String reqMsg = Utils.ObectToJson(requestInfo);

		logger.info("reqMsg" + reqMsg);
		// 获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
	}

	@Override
	public String queryIcinfo(String userid, String resid, RequestInfo requestInfo) throws JsonProcessingException {
		// 获取请求头
		requestInfo.setMessageid("1006");

		// 获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("userid", userid);
		if (resid != null && !"".equals(resid)) {
			reqBody.put("resid", resid);
		}
		requestInfo.setBody(reqBody);

		// 将请求信息转成json
		String reqMsg = Utils.ObectToJson(requestInfo);

		logger.info("reqMsg" + reqMsg);
		// 获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
	}

	@Override
	public String queryIcinfo(String userid, RequestInfo requestInfo) throws JsonProcessingException {
		return queryIcinfo(userid, null, requestInfo);
	}

	@Override
	public String queryUserprice(String userid, RequestInfo requestInfo) throws JsonProcessingException {
		// 获取请求头
		requestInfo.setMessageid("1007");

		// 获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("userid", userid);
		requestInfo.setBody(reqBody);

		// 将请求信息转成json
		String reqMsg = Utils.ObectToJson(requestInfo);

		logger.info("reqMsg" + reqMsg);
		// 获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
	}

	@Override
	public String queryUseamount(String userid, RequestInfo requestInfo) throws JsonProcessingException {
		// 获取请求头
		requestInfo.setMessageid("1008");

		// 获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("userid", userid);
		requestInfo.setBody(reqBody);

		// 将请求信息转成json
		String reqMsg = Utils.ObectToJson(requestInfo);

		logger.info("reqMsg" + reqMsg);
		// 获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
	}

	@Override
	public String queryUserpresavingc(String userid, RequestInfo requestInfo) throws JsonProcessingException {
		// 获取请求头
		requestInfo.setMessageid("1009");

		// 获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("userid", userid);
		requestInfo.setBody(reqBody);

		// 将请求信息转成json
		String reqMsg = Utils.ObectToJson(requestInfo);

		logger.info("reqMsg" + reqMsg);
		// 获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
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
	@Override
	public String queryBills(String userid, int pageno, int pagesize,String feetype, String batchid, String yrmonth, RequestInfo requestInfo) throws JsonProcessingException {
		// 获取请求头
		requestInfo.setMessageid("1010");

		// 分页单页大于100条 设置为100条
		if (pagesize > 100) {
			pagesize = 100;
		}

		// 获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("userid", userid);
		reqBody.put("pageno", pageno + "");
		reqBody.put("pagesize", pagesize + "");
		reqBody.put("feetype", feetype);
		reqBody.put("batchid", batchid);
		reqBody.put("yrmonth", yrmonth);
		requestInfo.setBody(reqBody);

		// 将请求信息转成json
		String reqMsg = Utils.ObectToJson(requestInfo);

		logger.info("reqMsg" + reqMsg);
		// 获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
	}

	@Override
	public String queryArrearage(String userid, int pageno, int pagesize, String yrmonth, RequestInfo requestInfo) throws JsonProcessingException {

		// 获取请求头
		requestInfo.setMessageid("1011");

		// 获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("userid", userid);
		reqBody.put("pageno", pageno + "");
		reqBody.put("pagesize", pagesize + "");
		reqBody.put("yrmonth", yrmonth);
		requestInfo.setBody(reqBody);

		// 将请求信息转成json
		String reqMsg = Utils.ObectToJson(requestInfo);

		logger.info("reqMsg" + reqMsg);
		// 获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
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
	@Override
	public String queryIcpayrec(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		// 获取请求头
		requestInfo.setMessageid("1012");

		String reqMsg = Utils.postJosnParam(requestInfo, jsonStr);
		logger.info(reqMsg);

		logger.info("reqMsg" + reqMsg);
		// 获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
	}

	@Override
	public String queryPayrec(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		// 获取请求头
		requestInfo.setMessageid("1013");

		String reqMsg = Utils.postJosnParam(requestInfo, jsonStr);
		logger.info(reqMsg);

		logger.info("reqMsg" + reqMsg);
		// 获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
	}

	@Override
	public String queryIcvalidate(String icvalidate, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("queryIcvalidate");
		// 设置请求码
		requestInfo.setMessageid("1014");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, icvalidate);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	@Override
	public String queryRecorddata(String userid, RequestInfo requestInfo, int pageno, int pagesize) throws JsonProcessingException {
		// 获取请求头
		requestInfo.setMessageid("1015");

		// 分页单页大于100条 设置为100条
		if (pagesize > 100) {
			pagesize = 100;
		}

		// 获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("userid", userid);
		reqBody.put("pageno", pageno + "");
		reqBody.put("pagesize", pagesize + "");
		requestInfo.setBody(reqBody);

		// 将请求信息转成json
		String reqMsg = Utils.ObectToJson(requestInfo);

		logger.info("reqMsg" + reqMsg);
		// 获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
	}

	@Override
	public String queryValidaterecordcycle(String userid, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("queryValidaterecordcycle");
		// 设置请求码
		requestInfo.setMessageid("1016");
		// 获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("userid", userid);
		requestInfo.setBody(reqBody);

		// 将请求信息转成json
		String reqMsg = Utils.ObectToJson(requestInfo);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	@Override
	public String queryLastreading(String userid, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("queryLastreading");
		// 设置请求码
		requestInfo.setMessageid("1017");
		// 获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("userid", userid);
		requestInfo.setBody(reqBody);

		// 将请求信息转成json
		String reqMsg = Utils.ObectToJson(requestInfo);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
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
	 * @param requestInfo
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@Override
	public String queryOrders(String userid, RequestInfo requestInfo, int pageno, int pagesize) throws JsonProcessingException {
		// 设置请求码
		requestInfo.setMessageid("1020");

		// 分页单页大于100条 设置为100条
		if (pagesize > 100) {
			pagesize = 100;
		}

		Map<String, String> body = new HashMap<String, String>();
		body.put("userid", userid);
		body.put("pageno", pageno + "");
		body.put("pagesize", pagesize + "");
		requestInfo.setBody(body);

		// 获取完整请求报文
		String reqMsg = Utils.ObectToJson(requestInfo);

		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	/**
	 * 
	 * @Title: queryOuthouseappliance
	 * @Description: TODO(内购燃气具信息查询)
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@Override
	public String queryInhouseappliance(String userid,String orderid, RequestInfo requestInfo) throws JsonProcessingException {

		// 获取请求头
		requestInfo.setMessageid("1021");

		Map<String, String> body = new HashMap<String, String>();
		body.put("userid", userid);
		
		if((!"".equals(orderid))&&orderid!=null){
			body.put("orderid", orderid);
		}
		
		requestInfo.setBody(body);

		// 获取完整请求报文
		String reqMsg = Utils.ObectToJson(requestInfo);

		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;

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
	@Override
	public String queryOuthouseappliance(String userid, RequestInfo requestInfo) throws JsonProcessingException {
		// 获取请求头
		requestInfo.setMessageid("1022");

		// 获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("userid", userid);
		requestInfo.setBody(reqBody);

		// 将请求信息转成json
		String reqMsg = Utils.ObectToJson(requestInfo);

		logger.info("reqMsg" + reqMsg);
		// 获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
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
	@Override
	public String querySecurity(String userid, RequestInfo requestInfo) throws JsonProcessingException {
		// 获取请求头
		requestInfo.setMessageid("1023");

		// 获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("userid", userid);
		requestInfo.setBody(reqBody);

		// 将请求信息转成json
		String reqMsg = Utils.ObectToJson(requestInfo);

		logger.info("reqMsg" + reqMsg);
		// 获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
	}

	public String queryHidden(String pkid, RequestInfo requestInfo) throws JsonProcessingException {
		// 获取请求头
		requestInfo.setMessageid("1024");

		// 获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("pkid", pkid);
		requestInfo.setBody(reqBody);

		// 将请求信息转成json
		String reqMsg = Utils.ObectToJson(requestInfo);

		logger.info("reqMsg" + reqMsg);
		// 获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
	}

	@Override
	public String busiOnwayorder(String userid, String busitype, RequestInfo requestInfo) throws JsonProcessingException {
		// 获取请求头
		requestInfo.setMessageid("1019");

		// 获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("userid", userid);
		reqBody.put("busitype", busitype);
		requestInfo.setBody(reqBody);

		// 将请求信息转成json
		String reqMsg = Utils.ObectToJson(requestInfo);

		logger.info("reqMsg" + reqMsg);
		// 获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
	}

	@Override
	public String queryStationusers(String stationcode, RequestInfo requestInfo) throws JsonProcessingException {
		// 设置请求码
		requestInfo.setMessageid("1026");

		// logger.info(contactInfo);

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, stationcode);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	@Override
	public String queryOperator(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("queryOperator");
		// 设置请求码
		requestInfo.setMessageid("1030");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, jsonStr);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	@Override
	public String queryMaterial(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("queryMaterial");
		// 设置请求码
		requestInfo.setMessageid("1029");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, jsonStr);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	@Override
	public String queryFactory(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("queryOperator");
		// 设置请求码
		requestInfo.setMessageid("1028");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, jsonStr);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	@Override
	public String queryFirefail(String pid, RequestInfo requestInfo) throws JsonProcessingException {
		// 获取请求头
		requestInfo.setMessageid("1027");

		// 获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("pid", pid);
		requestInfo.setBody(reqBody);

		// 将请求信息转成json
		String reqMsg = Utils.ObectToJson(requestInfo);

		logger.info("reqMsg" + reqMsg);
		// 获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
	}

	@Override
	public String queryBusirec(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("queryBusirec");
		// 设置请求码
		requestInfo.setMessageid("1031");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, jsonStr);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg,requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	@Override
	public String queryDetailorder(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("queryDetailorder");
		// 设置请求码
		requestInfo.setMessageid("1032");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, jsonStr);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg,requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;	}

	
	@Override
	public String queryAddr(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("queryAddr");
		// 设置请求码
		requestInfo.setMessageid("1033");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, jsonStr);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg,requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}
	
	@Override
	public String queryGspayrec(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("queryGspayrec");
		// 设置请求码
		requestInfo.setMessageid("1034");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, jsonStr);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}
	
	@Override
	public String queryYrmonth(RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("queryYrmonth");
		// 设置请求码
		requestInfo.setMessageid("1035");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.ObectToJson(requestInfo);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}
	
	@Override
	public String queryBankinfo(RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("queryBankinfo");
		// 设置请求码
		requestInfo.setMessageid("1036");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.ObectToJson(requestInfo);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg, requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}
}