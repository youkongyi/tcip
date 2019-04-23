package com.stech.tcip.offerws.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stech.tcip.sys.pojo.RequestInfo;

public interface BusiService {

	/**
	 * 
	 * @Title: busi_modifycontinfo
	 * @Description: TODO(联系人信息变更 )
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String busModifycontinfo(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	/**
	 * 
	 * @Title: busi_modifycontinfo
	 * @Description: TODO(联系人信息变更 )
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String busiApply(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	/**
	 * 
	 * @Title: busi_modifycontinfo
	 * @Description: TODO(业务工单发起)
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String busiBusiapply(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	/**
	 * 
	 * @Title: busiBusiapply
	 * @Description: TODO(业务工单取消)
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String busiCancelorder(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	/**
	 * 
	 * @Title: busiInhouseinstall
	 * @Description: TODO(内购燃气具安装 )
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String busiInhouseinstall(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	/**
	 * 
	 * @Title: busiInhouserepair
	 * @Description: TODO(内购燃气具维修)
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String busiInhouserepair(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	public String busiBackwrite(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	public String busiOpenaccent(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	public String busiReminder(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	/**
	 * 
	 * @Title: busiTransferstate
	 * @Description: TODO(圈存状态变更)
	 * @param jsonStr
	 * @param requestInfo
	 * @return:String
	 */
	public String busiTransferstate(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	/**
	 * 
	 * @Title: cancelbusiorder
	 * @Description: TODO(取消业务工单)
	 * @param jsonStr
	 * @param requestInfo
	 * @return
	 * @throws JsonProcessingException:String
	 */
	public String cancelbusiorder(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	public String busiGasresrepair(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	public String busiIcrepair(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	public String busiGasresinstall(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	public String busiFixmeterandopenfire(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	public String busiFixmeter(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	public String busiOpenfire(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	public String busiDelmeter(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

	public String busiChangresid(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;
	
	public String busiGasressend(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;
	
	public String busiStopuser(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;
	
	public String busiValidatemeter(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;
	
	public String busiBackgas(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;
	
	public String busiIndoortube(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;
	
	public String busiIndoorcorrect(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;
	
	public String busiInstallgscontract(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;
	
	public String busiGssecurityrecord(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;
	
	public String busiGsappliance(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;
	
	public String busiGsopenfire(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;
	
	public String busiGsfixmeter(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException;

}
