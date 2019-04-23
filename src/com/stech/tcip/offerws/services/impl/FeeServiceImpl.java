package com.stech.tcip.offerws.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stech.tcip.offerws.services.FeeService;
import com.stech.tcip.sys.pojo.RequestInfo;
import com.stech.tcip.sys.services.InvokeTCISService;
import com.stech.tcip.sys.util.Utils;

@Service("feeService")
public class FeeServiceImpl implements FeeService {

	private static final Logger logger = LogManager.getLogger(FeeServiceImpl.class);

	// 调用TCIS3.0接口
	@Autowired
	private InvokeTCISService invokeTCISService;

	@Override
	public String feeIcrecharge(String icRecharge, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("feeIcrecharge");
		// 设置请求码
		requestInfo.setMessageid("2001");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, icRecharge);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg,requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	@Override
	public String feePay(String feeCondition, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("feePay");
		// 设置请求码
		requestInfo.setMessageid("2002");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, feeCondition);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg,requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	@Override
	public String busiDiytryfee(String diyFeeCondition, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiDiytryfee");
		// 设置请求码
		requestInfo.setMessageid("2003");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, diyFeeCondition);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg,requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	@Override
	public String busiDiyreading(String diyFeeCondition, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiDiyreading");
		// 设置请求码
		requestInfo.setMessageid("2004");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, diyFeeCondition);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg,requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	@Override
	public String busiIndustryreading(String industryreading, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiDiyreading");
		// 设置请求码
		requestInfo.setMessageid("2005");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, industryreading);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg,requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	@Override
	public String feeCheckreq(String fileinfo, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("feeCheckreq");
		// 设置请求码
		requestInfo.setMessageid("1018");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, fileinfo);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg,requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	
	/**
	 * 
	 * @Title: fee_checkreq   
	 * @Description: TODO(对账请求)   
	 * @param fileinfo
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@Override
	public String queryVccpayrec(String pkid, RequestInfo requestInfo) throws JsonProcessingException {
		//获取请求头
		requestInfo.setMessageid("1025");
		
		//获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("pkid", pkid);
		requestInfo.setBody(reqBody);
		
		//将请求信息转成json
		String reqMsg  = Utils.ObectToJson(requestInfo);
		 
		logger.info("reqMsg" + reqMsg);
		//获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg,requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
	}

	@Override
	public String busiOnwayorder(String userid, RequestInfo requestInfo) throws JsonProcessingException {
		//获取请求头
		requestInfo.setMessageid("1019");
		
		//获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("userid", userid);
		requestInfo.setBody(reqBody);
		
		//将请求信息转成json
		String reqMsg  = Utils.ObectToJson(requestInfo);
		 
		logger.info("reqMsg" + reqMsg);
		//获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg,requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
	}

	@Override
	public String busiMakebusifee(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiMakebusifee");
		// 设置请求码
		requestInfo.setMessageid("2007");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, jsonStr);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg,requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

}
