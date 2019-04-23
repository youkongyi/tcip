package com.stech.tcip.offerws.services.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stech.tcip.offerws.services.BusiService;
import com.stech.tcip.sys.pojo.RequestInfo;
import com.stech.tcip.sys.services.InvokeTCISService;
import com.stech.tcip.sys.util.Utils;

@Service("busiService")
public class BusiServiceImpl implements BusiService {

	private static final Logger logger = LogManager.getLogger(BusiServiceImpl.class);
	
	@Autowired
	private InvokeTCISService invokeTCISService;

	/**
	 * 
	 * @Title: busi_modifycontinfo   
	 * @Description: TODO(联系人信息变更 )   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@Override
	public String busModifycontinfo(String contactInfo, RequestInfo requestInfo) throws JsonProcessingException {
		
		//设置请求码
		requestInfo.setMessageid("3001");
		
		//logger.info(contactInfo);
		
		//获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, contactInfo); 
		logger.info(reqMsg);
		
		//获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg,requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	/**
	 * 
	 * @Title: busiApply   
	 * @Description: TODO(诉求工单发起 )   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@Override
	public String busiApply(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiApply");
		// 设置请求码
		requestInfo.setMessageid("3002");
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
	public String busiBusiapply(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiBusiapply");
		// 设置请求码
		requestInfo.setMessageid("3002");
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
	public String busiCancelorder(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiCancelorder");
		// 设置请求码
		requestInfo.setMessageid("3003");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, jsonStr);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg,requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	/**
	 * 
	 * @Title: busiInhouseinstall   
	 * @Description: TODO(内购燃气具安装 )   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@Override
	public String busiInhouseinstall(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiInhouseinstall");
		// 设置请求码
		requestInfo.setMessageid("3004");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, jsonStr);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg,requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}
	
	/**
	 * 
	 * @Title: busiInhouserepair   
	 * @Description: TODO(内购燃气具维修)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@Override
	public String busiInhouserepair(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiInhouserepair");
		// 设置请求码
		requestInfo.setMessageid("3005");
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
	public String busiBackwrite(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("backwriteBusirec");
		// 设置请求码
		requestInfo.setMessageid("3006");
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
	public String busiReminder(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiReminder");
		// 设置请求码
		requestInfo.setMessageid("3008");
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
	public String busiOpenaccent(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiOpenaccent");
		// 设置请求码
		requestInfo.setMessageid("3009");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParam(requestInfo, jsonStr);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg,requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	/**
	 * 
	 * @Title: busiTransferstate   
	 * @Description: TODO(圈存状态变更)   
	 * @param jsonStr
	 * @param requestInfo
	 * @return:String
	 */
	public String busiTransferstate(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiTransferstate");
		// 设置请求码
		requestInfo.setMessageid("2006");
		// 获取请求体

		// 获取完整请求报文
		String reqMsg = Utils.postJosnParamForQuery(requestInfo, jsonStr);
		logger.info(reqMsg);

		// 获取返回报文
		String retMsg = invokeTCISService.invokeWS(reqMsg,requestInfo.getDataorgid());
		logger.info(retMsg);
		return retMsg;
	}

	/**
	 * 
	 * @Title: cancelbusiorder   
	 * @Description: TODO(业务工单取消)   
	 * @param jsonStr
	 * @param requestInfo
	 * @return:String
	 */
	@Override
	public String cancelbusiorder(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("cancelbusiorder");
		// 设置请求码
		requestInfo.setMessageid("3010");
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
	public String busiGasresrepair(String jsonStr, RequestInfo requestInfo)  throws JsonProcessingException {
		logger.info("busiGasresrepair");
		// 设置请求码
		requestInfo.setMessageid("5006");
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
	public String busiIcrepair(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiIcrepair");
		// 设置请求码
		requestInfo.setMessageid("5007");
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
	public String busiGasresinstall(String jsonStr, RequestInfo requestInfo)  throws JsonProcessingException {
		logger.info("busiGasresinstall");
		// 设置请求码
		requestInfo.setMessageid("5005");
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
	public String busiFixmeterandopenfire(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiFixmeterandopenfire");
		// 设置请求码
		requestInfo.setMessageid("5004");
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
	public String busiFixmeter(String jsonStr, RequestInfo requestInfo)throws JsonProcessingException {
		logger.info("busiFixmeter");
		// 设置请求码
		requestInfo.setMessageid("5003");
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
	public String busiOpenfire(String jsonStr, RequestInfo requestInfo)throws JsonProcessingException {
		logger.info("busiOpenfire");
		// 设置请求码
		requestInfo.setMessageid("5002");
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
	public String busiDelmeter(String jsonStr, RequestInfo requestInfo)throws JsonProcessingException {
		logger.info("busiOpenfire");
		// 设置请求码
		requestInfo.setMessageid("5001");
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
	public String busiChangresid(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiChangresid");
		// 设置请求码
		requestInfo.setMessageid("3011");
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
	public String busiGasressend(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiGasressend");
		// 设置请求码
		requestInfo.setMessageid("5008");
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
	public String busiStopuser(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiStopuser");
		// 设置请求码
		requestInfo.setMessageid("5009");
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
	public String busiValidatemeter(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiValidatemeter");
		// 设置请求码
		requestInfo.setMessageid("5010");
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
	public String busiBackgas(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiBackgas");
		// 设置请求码
		requestInfo.setMessageid("5011");
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
	public String busiIndoortube(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiIndoortube");
		// 设置请求码
		requestInfo.setMessageid("5012");
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
	public String busiIndoorcorrect(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiIndoorcorrect");
		// 设置请求码
		requestInfo.setMessageid("5013");
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
	public String busiInstallgscontract(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiInstallgscontract");
		// 设置请求码
		requestInfo.setMessageid("5014");
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
	public String busiGssecurityrecord(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiGssecurityrecord");
		// 设置请求码
		requestInfo.setMessageid("5015");
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
	public String busiGsappliance(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiGsappliance");
		// 设置请求码
		requestInfo.setMessageid("5016");
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
	public String busiGsopenfire(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiGsopenfire");
		// 设置请求码
		requestInfo.setMessageid("5017");
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
	public String busiGsfixmeter(String jsonStr, RequestInfo requestInfo) throws JsonProcessingException {
		logger.info("busiGsfixmeter");
		// 设置请求码
		requestInfo.setMessageid("5018");
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
