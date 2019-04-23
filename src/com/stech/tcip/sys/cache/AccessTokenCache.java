package com.stech.tcip.sys.cache;

import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stech.tcip.sys.dao.AccesstokenMapper;
import com.stech.tcip.sys.pojo.Accesstoken;

import net.rubyeye.xmemcached.exception.MemcachedException;

@Component
public class AccessTokenCache extends MemcachedBasis {
	
   
	//token缓存前缀
	protected String prefix = "token::";

	@Autowired
	private AccesstokenMapper accesstokenMapper;
	
	/**
	 * 
	 * @Title: set   
	 * @Description: TODO(设置缓存)   
	 * @param accesstoken
	 * @return:Boolean
	 */
	public Boolean set(Accesstoken accesstoken){
		 Boolean result = false;
		 try {
			 result = memcachedClient.set(getCacheKey(accesstoken.getAccesstoken()), exptime, accesstoken);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			e.printStackTrace();
		}
		 return result;
	}
	
	
	/**
	 * 
	 * @Title: set   
	 * @Description: TODO(设置缓存)   
	 * @param dataorgid
	 * @param url
	 * @return:Boolean
	 */
	public Boolean set(String dataorgid,String url){
		 Boolean result = false;
		 try {
			 result = memcachedClient.set(getCacheKey(dataorgid), exptime, url);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			e.printStackTrace();
		}
		 return result;		
	}
	

	/**
	 * 
	 * @Title: get   
	 * @Description: TODO(获取缓存)   
	 * @param accessToken
	 * @return:Accesstoken
	 */
	public Accesstoken get(String accessToken){
		Accesstoken token = null;
		try {
			
			token = memcachedClient.get(getCacheKey(accessToken));
			if(token == null){
				token = accesstokenMapper.selectByToken(accessToken);
				this.set(token);
			}
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			e.printStackTrace();
		}
		return token;
	}
	
	
	/**
	 * 
	 * @Title: getURL   
	 * @Description: TODO()   
	 * @param dataorgid
	 * @return:String
	 */
	public String getURL(String dataorgid){
		String url = "";
		try {
			url = memcachedClient.get(getCacheKey(dataorgid));
			if (url == null || "".equals(url.trim())){
				url = accesstokenMapper.selectUrlbyDataorgId(dataorgid);
				this.set(dataorgid,url);
			}
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	private String getCacheKey(String id){
		return prefix + id;
	}
}
