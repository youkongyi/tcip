package com.stech.tcip.event.dao;

import java.util.List;

import com.stech.tcip.event.pojo.Eventreg;

public interface EventregMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Eventreg record);

    int insertSelective(Eventreg record);

    Eventreg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Eventreg record);

    int updateByPrimaryKey(Eventreg record);
    
    int eventCancel(Eventreg record);
    
	/**
	 * 
	 * @Title: pusheventList   
	 * @Description: TODO(查询所有的注册事件)   
	 * @param eventreg
	 * @return:PagedResult<Eventreg>
	 */
    public List<Eventreg> pusheventList(Eventreg eventreg);
    
}