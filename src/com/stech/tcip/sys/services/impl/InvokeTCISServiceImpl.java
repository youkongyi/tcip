package com.stech.tcip.sys.services.impl;


import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeton.tcisapiwebserviceservice.TcisApiWebServiceService;
import com.stech.tcip.sys.cache.AccessTokenCache;
import com.stech.tcip.sys.services.InvokeTCISService;

@Service("invokeTCISService")
public class InvokeTCISServiceImpl implements InvokeTCISService{
	
	//访问token缓存对象
	@Autowired
	private AccessTokenCache accessTokenCache;

	@Override
	public String invokeWS(String msg,String dataorgid) {
		//获取分公司请求地址
		String url = accessTokenCache.getURL(dataorgid);
		
	   	//使用JaxWsProxyFactoryBean调用soap服务，但是这种方式需要需要生成接口文件
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(TcisApiWebServiceService.class);
        factory.setAddress(url);
        TcisApiWebServiceService userServiceJaxBean = (TcisApiWebServiceService)factory.create();

        String retMsg = userServiceJaxBean.tcisApiWebService(msg);
        
		return retMsg;
	}
}
