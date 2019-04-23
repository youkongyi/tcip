package com.stech.tcip.sys.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.stech.tcip.sys.dao.AppInterfaceMapper;
import com.stech.tcip.sys.dao.AppMapper;
import com.stech.tcip.sys.dto.AppAuthorizes;
import com.stech.tcip.sys.pojo.App;
import com.stech.tcip.sys.pojo.AppInterfaceKey;
import com.stech.tcip.sys.services.AppService;
import com.stech.tcip.sys.util.PageBeanUtil;
import com.stech.tcip.sys.util.PagedResult;

@Service("appService")
public class AppServiceImpl implements AppService {

	private static final Logger logger = LogManager.getLogger(AppServiceImpl.class);
	
	//accesstoken数据库处理对象
	@Autowired
	private AppMapper appMapper;
	
	@Autowired
	private AppInterfaceMapper appInterfaceMapper;
	
	@Override
	public void addApp(App app) {
		int flag =  appMapper.insert(app);
		logger.info(flag);
	}

	@Override
	public void delApp(String appid) {
		int flag = appMapper.deleteByPrimaryKey(appid);
		logger.info(flag);
	}

	@Override
	public void updateApp(App app) {
		int flag = appMapper.updateByPrimaryKey(app);
		logger.info(flag);

	}

	@Override
	public PagedResult<App> selectApps(App app,int pageNum,int pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		
		List<App> list = appMapper.selectAllApps(app);

		return PageBeanUtil.toPagedResult(list);
	}

	@Override
	public int appAuthorize(AppInterfaceKey appInterfaceKey) {
		return appInterfaceMapper.insert(appInterfaceKey);
	}
	
	@Override
	public int appdeAuthorize(AppInterfaceKey appInterfaceKey) {
		return appInterfaceMapper.deleteByPrimaryKey(appInterfaceKey);
	}
	
	

	/**
	 * 
	 * @Title: appAuthorizes   
	 * @Description: TODO(查询用户接口授权情况)   
	 * @param appid
	 * @return:PagedResult<InterfaceService>
	 */
	@Override
	public PagedResult<AppAuthorizes> appAuthorizes(AppAuthorizes appAuthorizes,int pageNum, int pageSize) {
	
		PageHelper.startPage(pageNum, pageSize);
		
		List<AppAuthorizes> datas = appMapper.selectAppAuthorizes(appAuthorizes);
		
		return PageBeanUtil.toPagedResult(datas);
	}

	/**
	 * 
	 * @Title: validateAuthorize   
	 * @Description: TODO(验证应用是否有指定地址的访问权限)   
	 * @param appId
	 * @param tcipCode
	 * @return:boolean
	 */
	public boolean validateAuthorize(String appId,String tcipCode){
		
		AppAuthorizes appAuthorizes = new AppAuthorizes();
		appAuthorizes.setAppId(appId);
		appAuthorizes.setTcipcode(tcipCode);
		
		int hasFlag = appInterfaceMapper.hasAccessFlag(appAuthorizes);
		
		//如果有对应记录则返回正确
		if (hasFlag>0){
			return true;
		}
		return false;
		
	}
	
	
	

}
