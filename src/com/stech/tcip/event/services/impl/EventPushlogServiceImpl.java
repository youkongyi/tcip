package com.stech.tcip.event.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.stech.tcip.event.dao.EventpushlogMapper;
import com.stech.tcip.event.pojo.Eventpushlog;
import com.stech.tcip.event.services.EventPushlogService;
import com.stech.tcip.sys.util.PageBeanUtil;
import com.stech.tcip.sys.util.PagedResult;

@Service("eventPushlogService")
public class EventPushlogServiceImpl implements EventPushlogService{
	
	@Autowired
	private EventpushlogMapper eventpushlogMapper;

	@Override
	public int insertlog(Eventpushlog eventpushlog) {
		
		return 0;
	}

    /**
     * 
     * @Title: selectEventpushlogs   
     * @Description: TODO(查询事件推送日志)   
     * @param eventpushlog
     * @return:List<Eventpushlog>
     */
	@Override
	public PagedResult<Eventpushlog> selectPushLogs(Eventpushlog eventpushlog, int pageNo, int pageSize) {
		
		PageHelper.startPage(pageNo, pageSize);
		
		List<Eventpushlog> datas = eventpushlogMapper.selectEventpushlogs(eventpushlog);
		
		return PageBeanUtil.toPagedResult(datas);	
		
	}

	/**
	 * 
	 * @Title: viewMessage   
	 * @Description: TODO(查看推送日志明细)   
	 * @param id
	 * @return:String
	 */
	public String viewMessage(int id) {
		Eventpushlog eventpushlog = eventpushlogMapper.selectByPrimaryKey(id);
		String message = "";
			message= new String(eventpushlog.getMessage());

		return message;
	}

}
