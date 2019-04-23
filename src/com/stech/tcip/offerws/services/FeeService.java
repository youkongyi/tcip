package com.stech.tcip.offerws.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stech.tcip.sys.pojo.RequestInfo;

/**
 * 
 * @ClassName:  FeeService   
 * @Description:TODO(缴费类业务服务类)   
 * @author: samuel 
 * @date:   2017年7月31日 上午9:11:41   
 *   
 *
 */
public interface FeeService {

	/**
	 * 
	 * @Title: feeIcrecharge   
	 * @Description: TODO(IC卡充值)   
	 * @param icRecharge
	 * @param requestInfo
	 * @return
	 * @throws JsonProcessingException:ReturnInfo
	 */
	public String feeIcrecharge(String icRecharge,RequestInfo requestInfo)  throws JsonProcessingException;

	
	/**
	 * 
	 * @Title: busiDiytryfee   
	 * @Description: TODO(抄表读数试算)   
	 * @param diyFeeCondition
	 * @param requestInfo
	 * @return
	 * @throws JsonProcessingException:String
	 */
	String busiDiytryfee(String diyFeeCondition, RequestInfo requestInfo) throws JsonProcessingException;


	/**
	 * 
	 * @Title: feePay   
	 * @Description: TODO(气费、营业费缴费)   
	 * @param feeCondition
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String feePay(String feeCondition, RequestInfo requestInfo)  throws JsonProcessingException;

	/**
	 * 
	 * @Title: busiDiytryfee   
	 * @Description: TODO(自报读数)   
	 * @param diyFeeCondition
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String busiDiyreading(String diyFeeCondition, RequestInfo requestInfo)  throws JsonProcessingException;


	/**
	 * 
	 * @Title: busiIndustryreading   
	 * @Description: TODO(工商户抄表)   
	 * @param industryreading
	 * @param requestInfo
	 * @return:String
	 */
	public String busiIndustryreading(String industryreading, RequestInfo requestInfo)  throws JsonProcessingException;

	/**
	 * 
	 * @Title: fee_checkreq   
	 * @Description: TODO(对账请求)   
	 * @param fileinfo
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String feeCheckreq(String fileinfo, RequestInfo requestInfo)  throws JsonProcessingException;

	
	/**
	 * 
	 * @Title: queryVccpayrec   
	 * @Description: TODO(查询对应的vcc缴费记录是否在TCIS中已存在)   
	 * @param pkid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String queryVccpayrec(String pkid, RequestInfo requestInfo)  throws JsonProcessingException;


	/**
	 * 
	 * @Title: busiOnwayorder   
	 * @Description: TODO(在途工单查询)   
	 * @param userid
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String busiOnwayorder(String userid, RequestInfo requestInfo)  throws JsonProcessingException;


	public String busiMakebusifee(String jsonStr, RequestInfo requestInfo)  throws JsonProcessingException;
	
}
