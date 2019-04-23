package com.stech.tcip.sys.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.stech.tcip.sys.dao.InterServiceMapper;
import com.stech.tcip.sys.pojo.InterService;
import com.stech.tcip.sys.services.InterfaceService;
import com.stech.tcip.sys.util.PageBeanUtil;
import com.stech.tcip.sys.util.PagedResult;

@Service("interfaceService")
public class InterfaceServiceImpl implements InterfaceService {
	
	@Autowired
	private InterServiceMapper interServiceMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(InterService record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(InterService record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public InterService selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(InterService record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(InterService record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PagedResult<InterService> selectInterServices(InterService interService, int pageNo, int pageSize) {
		
		PageHelper.startPage(pageNo, pageSize);
		
		List<InterService> datas = interServiceMapper.selectInterServices(interService); 
		
		return PageBeanUtil.toPagedResult(datas);
	}

}
