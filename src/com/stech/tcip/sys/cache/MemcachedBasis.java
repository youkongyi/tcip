package com.stech.tcip.sys.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.rubyeye.xmemcached.MemcachedClient;

@Component
public class MemcachedBasis {

    @Autowired
    protected MemcachedClient memcachedClient;

    /**
    * 失效时间（秒）3600*24 一天
    */
    protected int exptime = 3600 * 24;
    
    protected int short_exptime = 60 * 5;

    /**
    * 基础数据失效时间（秒）3600*24*7 一周
    */
    protected int dataExptime = this.exptime * 7;
    
    protected String getCacheKey(String prefix,String id){
		return prefix + id;
	}

}