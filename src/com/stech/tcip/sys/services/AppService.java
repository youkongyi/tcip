package com.stech.tcip.sys.services;

import com.stech.tcip.sys.dto.AppAuthorizes;
import com.stech.tcip.sys.pojo.App;
import com.stech.tcip.sys.pojo.AppInterfaceKey;
import com.stech.tcip.sys.util.PagedResult;

/**
 * 
 * 
 * @ClassName:  AppService   
 * @Description:TODO(第三方应用管理)   
 * @author: samuel 
 * @date:   2017年7月18日 下午2:39:59   
 *
 */
public interface AppService {

	/**
	 * 
	 * @Title: addApp   
	 * @Description: TODO(添加应用)   
	 * @param app:void
	 */
	public void addApp(App app);
	
	/**
	 * 
	 * @Title: delApp   
	 * @Description: TODO(根据主键删除应用)   
	 * @param appid:void
	 */
	public void delApp(String appid);
	
	/**
	 * 
	 * @Title: updateApp   
	 * @Description: TODO(修改应用)   
	 * @param app:void
	 */
	public void updateApp(App app);
	
	
	/**
	 * 
	 * @Title: selectApps   
	 * @Description: TODO(查询所有应用)   
	 * @param app
	 * @return:PagedResult<App>
	 */
	public PagedResult<App> selectApps(App app,int pageNum,int pageSize);
	
	
	/**
	 * 
	 * @Title: appAuthorizes   
	 * @Description: TODO(查询用户接口授权情况)   
	 * @param appid
	 * @return:PagedResult<InterfaceService>
	 */
	public PagedResult<AppAuthorizes> appAuthorizes(AppAuthorizes appAuthorizes,int pageNum,int pageSize);
	
	/**
	 * 
	 * @Title: appAuthorize   
	 * @Description: TODO(针对应用授权)   
	 * @param appInterfaceKey:void
	 */
	public int appAuthorize(AppInterfaceKey appInterfaceKey);
	
	
	
	/**
	 * 
	 * @Title: appdeAuthorize   
	 * @Description: TODO(应用取消授权)   
	 * @param appInterfaceKey
	 * @return:int
	 */
	public int appdeAuthorize(AppInterfaceKey appInterfaceKey);
	
	/**
	 * 
	 * @Title: validateAuthorize   
	 * @Description: TODO(验证应用是否有指定地址的访问权限)   
	 * @param appId
	 * @param tcipCode
	 * @return:boolean
	 */
	public boolean validateAuthorize(String appId,String tcipCode);
	
	
}
