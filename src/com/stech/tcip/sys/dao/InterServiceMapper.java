package com.stech.tcip.sys.dao;

import java.util.List;

import com.stech.tcip.sys.pojo.InterService;

public interface InterServiceMapper {
    int insert(InterService record);

    int insertSelective(InterService record);
    
    public List<InterService> selectInterServices(InterService interService);
}