package com.stech.tcip.event.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.stech.tcip.event.dao.EventregMapper;
import com.stech.tcip.event.pojo.Eventreg;
import com.stech.tcip.event.services.EventService;
import com.stech.tcip.sys.enums.PushCodeEnum;
import com.stech.tcip.sys.pojo.RequestInfo;
import com.stech.tcip.sys.pojo.ReturnInfo;
import com.stech.tcip.sys.util.PageBeanUtil;
import com.stech.tcip.sys.util.PagedResult;

@Service("eventService")
public class EventServiceImpl implements EventService{

	@Autowired
	private EventregMapper eventregMapper;
	
	@Autowired
	private ReturnInfo returnInfo;

	/**
	 * 
	 * @Title: evenReg   
	 * @Description: TODO(推送消息注册)   
	 * @param eventreg
	 * @return:ReturnInfo
	 */
	public ReturnInfo eventReg(Eventreg eventreg,RequestInfo requestInfo){
		
		//判断是否是可用的推送类型
		String messsageCode = eventreg.getMessagecode();
		if (!PushCodeEnum.contains(messsageCode)){
			returnInfo.setResult("4_4001_02");
			returnInfo.setMsg("消息编码:["+ messsageCode +"]" + "不支持的推送类型");
			return returnInfo;
		}
		
		//
		eventreg.setCancelflag(0);
		if(eventregMapper.pusheventList(eventreg).size()>0){
			returnInfo.setResult("4_4001_03");
			returnInfo.setMsg("消息编码:["+ messsageCode +"],应用ID:[" +requestInfo.getAppid()+ "] 已注册该事件，请勿重复注册");
			return returnInfo;
		}
		
		eventreg.setCancelflag(0);
		eventreg.setAppid(requestInfo.getAppid());
		
		int regflag = eventregMapper.insert(eventreg);
		if(regflag == 0){
			returnInfo.setResult("4008");
			returnInfo.setMsg("写入或者更新数据失败，没有要写入或者更新的数据");
		}else {
			returnInfo.setResult("0");
			returnInfo.setMsg("事件注册成功");
		}
		return returnInfo;
	} 
	
	
	/**
	 * 
	 * @Title: eventCancel   
	 * @Description: TODO(事件取消)   
	 * @param appid 第三方应用ID
	 * @param messagecode 事件编码
	 * @param type 事件推送类型
	 * @return:ReturnInfo
	 */
	public ReturnInfo eventCancel(Eventreg eventreg){
		//设置已经注册的事件为失效状态
		eventreg.setCancelflag(1);
		
		int cancelflag = eventregMapper.eventCancel(eventreg);
		
		if(cancelflag == 0){
			returnInfo.setResult("4008");
			returnInfo.setMsg("写入或者更新数据失败，有没有要写入或者更新的数据");
		}else {
			returnInfo.setResult("0");
			returnInfo.setMsg("事件取消成功");
		}		
		return returnInfo;
	}
	
	/**
	 * 
	 * @Title: eventPush   
	 * @Description: TODO(事件推送)  
	 * @return :void
	 */
	public void eventPush(){
		
	}

	/**
	 * 
	 * @Title: pusheventList   
	 * @Description: TODO(查询所有的注册事件)   
	 * @param eventreg
	 * @return:PagedResult<Eventreg>
	 */
	@Override
	public PagedResult<Eventreg> pusheventList(Eventreg eventreg, int pageNo, int pageSize) {

		PageHelper.startPage(pageNo, pageSize);
		
		List<Eventreg> datas = eventregMapper.pusheventList(eventreg);
		
		return PageBeanUtil.toPagedResult(datas);
	}
	
}
