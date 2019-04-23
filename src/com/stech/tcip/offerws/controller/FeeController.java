package com.stech.tcip.offerws.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stech.tcip.offerws.services.FeeService;
import com.stech.tcip.sys.pojo.RequestInfo;

/**
 * 
 * @ClassName:  FeeController   
 * @Description:TODO(缴费类业务)   
 * @author: samuel 
 * @date:   2017年7月31日 上午8:59:15   
 *
 */
@Controller
public class FeeController {
	
	private static final Logger logger = LogManager.getLogger(FeeController.class);
	
	//缴费类业务服务提供类
	@Autowired
	private FeeService feeService;
	
	//请求信息
	@Autowired
	private RequestInfo requestInfo;

	/**
	 * 
	 * @Title: feeIcrecharge   
	 * @Description: TODO(IC卡充值)   
	 * @param icRecharge
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "fee_icrecharge", consumes = "application/json",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String feeIcrecharge(@RequestBody String icRecharge, HttpServletRequest request) throws JsonProcessingException{
		
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/fee_icrecharge");
		return feeService.feeIcrecharge(icRecharge, requestInfo);
	}
	

	/**
	 * 
	 * @Title: feePay   
	 * @Description: TODO(气费、营业费缴费)   
	 * @param feeCondition
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "fee_pay", consumes = "application/json",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String feePay(@RequestBody String feeCondition, HttpServletRequest request) throws JsonProcessingException{
		
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/fee_pay");
		return feeService.feePay(feeCondition, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busiDiytryfee   
	 * @Description: TODO(自报读数试算)   
	 * @param diyFeeCondition
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value="/busi_diytryfee", consumes = "application/json",produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String busiDiytryfee(@RequestBody String diyFeeCondition,HttpServletRequest request) throws JsonProcessingException{
		//获取请求头
		requestInfo = (RequestInfo)request.getAttribute("requestInfo");
		logger.info("/busi_diytryfee");
		return feeService.busiDiytryfee(diyFeeCondition,requestInfo);				
	}
	
	/**
	 * 
	 * @Title: busiDiytryfee   
	 * @Description: TODO(自报读数)   
	 * @param diyFeeCondition
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value="/busi_diyreading", consumes = "application/json",produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String busiDiyreading(@RequestBody String diyFeeCondition,HttpServletRequest request) throws JsonProcessingException{
		//获取请求头
		requestInfo = (RequestInfo)request.getAttribute("requestInfo");
		logger.info("/busi_diyreading");
		return feeService.busiDiyreading(diyFeeCondition,requestInfo);				
	}
	
	/**
	 * 
	 * @Title: busiIndustryreading   
	 * @Description: TODO(工商户抄表)   
	 * @param industryreading
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value="/busi_industryreading", consumes = "application/json",produces = "application/json;charset=UTF-8")
	@ResponseBody		
	public String busiIndustryreading(@RequestBody String industryreading,HttpServletRequest request) throws JsonProcessingException{
		//获取请求头
		requestInfo = (RequestInfo)request.getAttribute("requestInfo");
		logger.info("/busi_industryreading");
		return feeService.busiIndustryreading(industryreading,requestInfo);			
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
	@RequestMapping(value="/fee_checkreq", consumes = "application/json",produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String feeCheckreq(@RequestBody
							  String fileinfo,
							  HttpServletRequest request)throws JsonProcessingException{
		//获取请求头
		requestInfo = (RequestInfo)request.getAttribute("requestInfo");
		logger.info("/fee_checkreq");
		return feeService.feeCheckreq(fileinfo,requestInfo);				
	}
	
	/**
	 * 
	 * @Title: queryVccpayrec   
	 * @Description: TODO(查询对应的vcc缴费记录是否在TCIS中已存在)   
	 * @param pkid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value="/query_vccpayrec/{pkid}",produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String queryVccpayrec(@PathVariable("pkid") 
								String pkid,
								HttpServletRequest request)throws JsonProcessingException{
		//获取请求头
		requestInfo = (RequestInfo)request.getAttribute("requestInfo");
		logger.info("/query_vccpayrec");
		return feeService.queryVccpayrec(pkid,requestInfo);				
	}

	
	/**
	 * 
	 * @Title: busiOnwayorder   
	 * @Description: TODO(在途工单查询)   
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value="/busi_onwayorder/{userid}",produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String busiOnwayorder(@PathVariable("userid") 
								String userid,
								HttpServletRequest request)throws JsonProcessingException{
		//获取请求头
		requestInfo = (RequestInfo)request.getAttribute("requestInfo");
		logger.info("/busi_onwayorder");
		return feeService.busiOnwayorder(userid,requestInfo);				
	}
	
	
	/**
	 * 
	 * @Title: busiMakebusifee   
	 * @Description: TODO(制定营业费)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_makebusifee", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiMakebusifee(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busiMakebusifee");
		return feeService.busiMakebusifee(jsonStr, requestInfo);
	}
    
}
