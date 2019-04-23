package com.stech.tcip.event.services;

import com.stech.tcip.event.pojo.Eventreg;
import com.stech.tcip.sys.pojo.RequestInfo;
import com.stech.tcip.sys.pojo.ReturnInfo;
import com.stech.tcip.sys.util.PagedResult;

public interface EventService {

	/**
	 * 
	 * @Title: evenReg   
	 * @Description: TODO(推送消息注册)   
	 * @param eventreg
	 * @return:int
	 */
	public ReturnInfo eventReg(Eventreg eventreg,RequestInfo requestInfo); 
	
	
	/**
	 * 
	 * @Title: eventCancel   
	 * @Description: TODO(事件取消)   
	 * @param appid 第三方应用ID
	 * @param messagecode 事件编码
	 * @param type 事件推送类型
	 * @return:int
	 */
	public ReturnInfo eventCancel(Eventreg eventreg);
	
	/**
	 * 
	 * @Title: eventPush   
	 * @Description: TODO(事件推送)  
	 * @return :void
	 */
	public void eventPush();
	
	/**
	 * 
	 * @Title: pusheventList   
	 * @Description: TODO(查询所有的注册事件)   
	 * @param eventreg
	 * @return:PagedResult<Eventreg>
	 */
	public PagedResult<Eventreg> pusheventList(Eventreg eventreg,int pageNo,int pageSize);
}
