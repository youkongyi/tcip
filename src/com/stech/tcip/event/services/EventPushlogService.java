package com.stech.tcip.event.services;

import com.stech.tcip.event.pojo.Eventpushlog;
import com.stech.tcip.sys.util.PagedResult;

public interface EventPushlogService {

	/**
	 * 
	 * @Title: insertlog   
	 * @Description: TODO(写操作日志)   
	 * @param eventpushlog
	 * @return:int
	 */
	public int insertlog(Eventpushlog eventpushlog);
	
	/**
	 * 
	 * @Title: selectPushLogs   
	 * @Description: TODO(查询推送日志)   
	 * @param eventpushlog
	 * @param pageNo
	 * @param pageSize
	 * @return:PagedResult<Eventpushlog>
	 */
	public PagedResult<Eventpushlog> selectPushLogs(Eventpushlog eventpushlog,int pageNo,int pageSize);

	
	/**
	 * 
	 * @Title: viewMessage   
	 * @Description: TODO(查看推送日志明细)   
	 * @param id
	 * @return:String
	 */
	public String viewMessage(int id);
}
