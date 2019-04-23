package com.stech.tcip.sys.dao;

import com.stech.tcip.sys.dto.AppAuthorizes;
import com.stech.tcip.sys.pojo.AppInterfaceKey;

public interface AppInterfaceMapper {
    int deleteByPrimaryKey(AppInterfaceKey key);

    int insert(AppInterfaceKey record);

    int insertSelective(AppInterfaceKey record);
    
    /**
     * 
     * @Title: hasAccessFlag   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @return:int
     */
    public int hasAccessFlag(AppAuthorizes appAuthorizes);
}