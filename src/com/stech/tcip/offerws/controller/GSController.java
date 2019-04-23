package com.stech.tcip.offerws.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stech.tcip.offerws.services.GSService;
import com.stech.tcip.sys.pojo.RequestInfo;

@Controller
public class GSController {
	
	private static Logger logger = LogManager.getLogger(GSController.class);
	
	@Autowired
	private GSService gsService;

	// 请求报文
	@Autowired
	private RequestInfo requestInfo;
	
	/**
	 * 
	 * @Title: queryHidden
	 * @Description: TODO(查询用户最后一笔充值记录及购总)
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/ib/user/icbuyinfo/{userid}",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryIcbuyinfo(@PathVariable("userid") String userid, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/ib/user/icbuyinfo/" + userid);
		return gsService.queryIcbuyinfo(userid, requestInfo);
	}	
}
