package com.stech.tcip.sys.cache;

import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.exception.MemcachedException;

public class RequestIdCache extends MemcachedBasis {

	//token缓存前缀
	protected String prefix = "reqid::";
	
	
	public boolean set(String requestid){
		boolean flag = false;
		try {
			flag = memcachedClient.set(getCacheKey(prefix, requestid), this.short_exptime, requestid);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public String get(String requestid){
		String cachedRequestid = null;
		try {
			cachedRequestid = memcachedClient.get(getCacheKey(prefix, requestid));
			if (cachedRequestid == null){
				set(requestid);
			}
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			e.printStackTrace();
		}
		return cachedRequestid;
	}

}
