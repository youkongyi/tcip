package com.stech.tcip.schedule.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.stech.tcip.schedule.dao.WithholdScheduleMapper;
import com.stech.tcip.schedule.dto.BankSchedule;
import com.stech.tcip.schedule.dto.ScheduleDTO;
import com.stech.tcip.schedule.dto.SeqGID;
import com.stech.tcip.schedule.dto.WithholdSchedule;
import com.stech.tcip.schedule.services.WithholdScheduleService;
import com.stech.tcip.schedule.util.BusinessException;
import com.stech.tcip.schedule.util.StringUtils;
import com.stech.tcip.sys.pojo.RequestInfo;
import com.stech.tcip.sys.services.InvokeTCISService;
import com.stech.tcip.sys.util.Utils;

@Component
public class WithholdScheduleServiceImpl implements WithholdScheduleService{
	
	private static final Logger logger = LogManager.getLogger(WithholdScheduleServiceImpl.class);
	
	// 调用TCIS3.0接口
	@Autowired
	private InvokeTCISService invokeTCISService;
	
	@Autowired
	private WithholdScheduleMapper withholdScheduleMapper;
	
	
	/**
	 * 
	 * @Title: createWithHold   
	 * @Description: TODO(生成银行批扣文件)   
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws JsonProcessingException:String
	 */
	@Override
	public String createWithHold(ScheduleDTO task) {
		String retMsg = null;
		try {
			String jsonStr = JSONObject.toJSONString(task);
			RequestInfo requestInfo = new RequestInfo();
			
			WithholdSchedule withholdSchedule = withholdScheduleMapper.queryWithholdScheduleTask(task);
			if(StringUtils.isNull(withholdSchedule)) {
			    throw new BusinessException(null,"找不到对应接口服务!");
			}
			requestInfo.setAppid(withholdSchedule.getAppid());
			requestInfo.setOrgcode(task.getOrgCode());
			// 设置请求码
			requestInfo.setMessageid(task.getTcisCode());
			//获取请求包体
	        Map<String, String> reqBody = new HashMap<String, String>();
	        reqBody.put("dataorgid", task.getDataorgid());
	        reqBody.put("bankNo", task.getBankCode());
	        requestInfo.setBody(reqBody);
			// 获取完整请求报文
			String reqMsg = Utils.postJosnParam(requestInfo, jsonStr);
			logger.info("请求报文: " + reqMsg);
			// 获取返回报文
			retMsg = invokeTCISService.invokeWS(reqMsg,task.getDataorgid());
			logger.info("返回报文: " + retMsg);
			JSONObject json = JSONObject.parseObject(retMsg,JSONObject.class);
			String retcode = json.getString("retcode");
            String msg =  json.getString("msg");
            // 成功则插入文件任务表
            if("0".equals(retcode) && "success".equals(msg)) {
                BankSchedule bankSchedule = JSONObject.parseObject(retMsg,BankSchedule.class);
                bankSchedule.setId(SeqGID.next());
                bankSchedule.setScheduleId(task.getId());
                bankSchedule.setDataorgid(task.getDataorgid());
                bankSchedule.setOrgCode(task.getOrgCode());
                bankSchedule.setBankCode(task.getBankCode());
                withholdScheduleMapper.insertBankSchedule(bankSchedule);
            }
		} catch (Exception e) {
			logger.error(e);
			JSONObject json = new JSONObject();
			json.put("retcode", "1");
			json.put("msg", e.getMessage());
			return json.toJSONString();
		}
		return retMsg;
	}

	/**
	 * 
	 * @description：解析银行回盘文件
	 * @see com.stech.tcip.schedule.services.WithholdScheduleService#readBackFile(com.stech.tcip.schedule.dto.ScheduleDTO)
	 * @author："geHanBiao"
	 * @crateDate：2018年12月16日下午2:12:51
	 */
	@Override
	public String readBackFile(ScheduleDTO task) {
	    String retMsg = null;
        try {
            String jsonStr = JSONObject.toJSONString(task);
            RequestInfo requestInfo = new RequestInfo();
            WithholdSchedule withholdSchedule = withholdScheduleMapper.queryWithholdScheduleTask(task);
            if(StringUtils.isNull(withholdSchedule)) {
                return "找不到对应接口服务!";
            }
            List<BankSchedule> bankSchedules = withholdScheduleMapper.queryBankFileName(task);
            if(StringUtils.isNull(bankSchedules)) {
                return "找不到对应的返回文件!";
            }
            requestInfo.setAppid(withholdSchedule.getAppid());
            requestInfo.setOrgcode(task.getOrgCode());
            // 设置请求码
            requestInfo.setMessageid(task.getTcisCode());
            //获取请求包体
            Map<String, String> reqBody = new HashMap<String, String>();
            reqBody.put("bankNo", task.getBankCode());
            reqBody.put("fileName", bankSchedules.get(0).getFileNameBack());
            requestInfo.setBody(reqBody);
            // 获取完整请求报文
            String reqMsg = Utils.postJosnParam(requestInfo, jsonStr);
            logger.info("请求报文: " + reqMsg);
            // 获取返回报文
            retMsg = invokeTCISService.invokeWS(reqMsg,task.getDataorgid());
            logger.info("返回报文: " + retMsg);
            if(StringUtils.isNull(retMsg)) {
                return "请求失败!";
            } 
            JSONObject json = JSONObject.parseObject(retMsg,JSONObject.class);
            String retcode = json.getString("retcode");
            String msg =  json.getString("msg");
            if("0".equals(retcode) && "success".equals(msg)) {
                withholdScheduleMapper.updateBankSchedule(bankSchedules.get(0));
            }
        } catch (Exception e) {
            logger.error(e);
            JSONObject json = new JSONObject();
            json.put("retcode", "1");
            json.put("msg", e.getMessage());
            return json.toJSONString();
        }
        return retMsg;
	}
	
}
