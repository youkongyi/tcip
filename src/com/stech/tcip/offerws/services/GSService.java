package com.stech.tcip.offerws.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stech.tcip.sys.pojo.RequestInfo;

public interface GSService {

	/**
	 * 
	 * @Title: queryStationusers   
	 * @Description: TODO(查询站箱用户信息)   
	 * @param userid
	 * @param requestInfo
	 * @return:String
	 */
	public String queryIcbuyinfo(String userid, RequestInfo requestInfo) throws JsonProcessingException;

}
