package com.stech.tcip.offerws.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stech.tcip.offerws.services.GSService;
import com.stech.tcip.sys.pojo.RequestInfo;
import com.stech.tcip.sys.services.InvokeTCISService;
import com.stech.tcip.sys.util.Utils;

@Service("gsService")
public class GSServiceImpl implements GSService {
	private static final Logger logger = LogManager.getLogger(BusiServiceImpl.class);

	@Autowired
	private InvokeTCISService invokeTCISService;

	@Override
	public String queryIcbuyinfo(String userid, RequestInfo requestInfo) throws JsonProcessingException {
		//获取请求头
		requestInfo.setMessageid("1101");
		
		//获取请求包体
		Map<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("userid", userid);
		requestInfo.setBody(reqBody);
		
		//将请求信息转成json
		String reqMsg   = Utils.ObectToJson(requestInfo);

		logger.info("reqMsg" + reqMsg);
		//获取请求信息
		String retMsg = invokeTCISService.invokeWS(reqMsg,requestInfo.getDataorgid());
		logger.info("retMsg" + retMsg);
		return retMsg;
	}

}
