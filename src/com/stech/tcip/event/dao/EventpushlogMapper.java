package com.stech.tcip.event.dao;

import java.util.List;

import com.stech.tcip.event.pojo.Eventpushlog;

public interface EventpushlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Eventpushlog record);

    int insertSelective(Eventpushlog record);

    Eventpushlog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Eventpushlog record);

    int updateByPrimaryKey(Eventpushlog record);
    
    /**
     * 
     * @Title: selectEventpushlogs   
     * @Description: TODO(查询事件推送日志)   
     * @param eventpushlog
     * @return:List<Eventpushlog>
     */
    public List<Eventpushlog> selectEventpushlogs(Eventpushlog eventpushlog);

    
	/**
	 * 
	 * @Title: viewMessage   
	 * @Description: TODO(查看推送日志明细)   
	 * @param id
	 * @return:String
	 */
	public String selectMessageByPrimaryKey(int id);
}