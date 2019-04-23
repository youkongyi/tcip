package com.stech.tcip.sys.services;

import com.stech.tcip.sys.pojo.InterService;
import com.stech.tcip.sys.util.PagedResult;

public interface InterfaceService {

    public int deleteByPrimaryKey(Integer id);

    public int insert(InterService record);

    public int insertSelective(InterService record);

    public InterService selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(InterService record);

    public int updateByPrimaryKey(InterService record);
    
    public PagedResult<InterService> selectInterServices(InterService interService,int pageNo,int pageSize);
}
