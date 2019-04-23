package com.stech.tcip.offerws.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stech.tcip.offerws.services.BusiService;
import com.stech.tcip.sys.pojo.RequestInfo;

@Controller
public class BusiController {

	private static final Logger logger = LogManager.getLogger(BusiController.class);

	// 请求业务受理服务类
	@Autowired
	private BusiService busiService;

	// 请求报文
	@Autowired
	private RequestInfo requestInfo;

	/**
	 * 
	 * @Title: busi_apply
	 * @Description: TODO(诉求工单发起 )
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_apply", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiApply(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busi_apply");
		return busiService.busiApply(jsonStr, requestInfo);
	}

	/**
	 * 
	 * @Title: busi_modifycontinfo
	 * @Description: TODO(联系人信息变更 )
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_modifycontinfo", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busi_modifycontinfo(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busi_modifycontinfo");
		return busiService.busModifycontinfo(jsonStr, requestInfo);
	}

	/**
	 * 
	 * @Title: busiBusiapply
	 * @Description: TODO(业务工单发起)
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_busiapply", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiBusiapply(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busi_busiapply");
		return busiService.busiBusiapply(jsonStr, requestInfo);
	}

	/**
	 * 
	 * @Title: busiBusiapply
	 * @Description: TODO(业务工单取消)
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_cancelorder", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiCancelorder(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busi_cancelorder");
		return busiService.busiCancelorder(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busiCancelbusiorder
	 * @Description: TODO(业务工单取消)
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_cancelbusiorder", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiCancelbusiorder(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busi_cancelbusiorder");
		return busiService.cancelbusiorder(jsonStr, requestInfo);
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
	@RequestMapping(value = "/busi_inhouseinstall", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiInhouseinstall(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busi_inhouseinstall");
		return busiService.busiInhouseinstall(jsonStr, requestInfo);
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
	@RequestMapping(value = "/busi_inhouserepair", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiInhouserepair(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busi_inhouserepair");
		return busiService.busiInhouserepair(jsonStr, requestInfo);
	}

	@RequestMapping(value = "/busi_backwrite", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiBackwrite(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busi_backwrite");
		return busiService.busiBackwrite(jsonStr, requestInfo);
	}

	@RequestMapping(value = "/busi_openaccent", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiOpenaccent(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busi_openaccent");
		return busiService.busiOpenaccent(jsonStr, requestInfo);
	}
	
	@RequestMapping(value = "/busi_reminder", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiReminder(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busiReminder");
		return busiService.busiReminder(jsonStr, requestInfo);
	}
	
	
	@RequestMapping(value = "/busi_transferstate", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiTransferstate(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busiTransferstate");
		return busiService.busiTransferstate(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busiDelmeter   
	 * @Description: TODO(表处理)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_delmeter", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiDelmeter(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busiDelmeter");
		return busiService.busiDelmeter(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busiOpenfire   
	 * @Description: TODO(点火)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_openfire", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiOpenfire(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busiOpenfire");
		return busiService.busiOpenfire(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busi_fixmeter   
	 * @Description: TODO(挂表)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_fixmeter", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiFixmeter(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busi_fixmeter");
		return busiService.busiFixmeter(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busiDelmeter   
	 * @Description: TODO(点火挂表)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_fixmeterandopenfire", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiFixmeterandopenfire(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busi_fixmeterandopenfire");
		return busiService.busiFixmeterandopenfire(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busi_gasresinstall   
	 * @Description: TODO(燃气具安装)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_gasresinstall", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiGasresinstall(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busiGasresinstall");
		return busiService.busiGasresinstall(jsonStr, requestInfo);
	}
	
	
	/**
	 * 
	 * @Title: busiGasresrepair   
	 * @Description: TODO(燃气具维修)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_gasresrepair", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiGasresrepair(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busiGasresrepair");
		return busiService.busiGasresrepair(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busiIcrepair   
	 * @Description: TODO(IC卡无卡维修)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_icrepair", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiIcrepair(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busiIcrepair");
		return busiService.busiIcrepair(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busiChangresid   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_changresid", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiChangresid(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/busi_changresid");
		return busiService.busiChangresid(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busiGasressend   
	 * @Description: TODO(燃气具送货)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_gasressend", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiGasressend(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/gasressend");
		return busiService.busiGasressend(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busiStopuser   
	 * @Description: TODO(报停)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_stopuser", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiStopuser(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/stopuser");
		return busiService.busiStopuser(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busiValidatemeter   
	 * @Description: TODO(校表)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_validatemeter", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiValidatemeter(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/validatemeter");
		return busiService.busiValidatemeter(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busiBackgas   
	 * @Description: TODO(恢复用气)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_backgas", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiBackgas(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/backgas");
		return busiService.busiBackgas(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busiIndoortube   
	 * @Description: TODO(户内改管)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_indoortube", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiIndoortube(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/indoortube");
		return busiService.busiIndoortube(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busiIndoorcorrect   
	 * @Description: TODO(户内整改)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_indoorcorrect", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiIndoorcorrect(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/indoorcorrect");
		return busiService.busiIndoorcorrect(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busiInstallgscontract   
	 * @Description: TODO(工商供气合同)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_installgscontract", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiInstallgscontract(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/installgscontract");
		return busiService.busiInstallgscontract(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busiGssecurityrecord   
	 * @Description: TODO(工商安检记录)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_gssecurityrecord", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiGssecurityrecord(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/gssecurityrecord");
		return busiService.busiGssecurityrecord(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busiGsappliance   
	 * @Description: TODO(工商用气设备)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_gsappliance", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiGsappliance(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/gsappliance");
		return busiService.busiGsappliance(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busiGsopenfire   
	 * @Description: TODO(工商户点火)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_gsopenfire", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiGsopenfire(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/gsopenfire");
		return busiService.busiGsopenfire(jsonStr, requestInfo);
	}
	
	/**
	 * 
	 * @Title: busiGsfixmeter   
	 * @Description: TODO(工商户挂表)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@RequestMapping(value = "/busi_gsfixmeter", consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String busiGsfixmeter(@RequestBody String jsonStr, HttpServletRequest request) throws JsonProcessingException {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		logger.info("/gsfixmeter");
		return busiService.busiGsfixmeter(jsonStr, requestInfo);
	}
}
