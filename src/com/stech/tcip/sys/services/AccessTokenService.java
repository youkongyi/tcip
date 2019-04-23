package com.stech.tcip.sys.services;

import org.springframework.stereotype.Service;

import com.stech.tcip.sys.pojo.Accesstoken;
import com.stech.tcip.sys.pojo.ReturnInfo;
import com.stech.tcip.sys.util.PagedResult;

/**
 * 
 * @ClassName:  AccessTokenService   
 * @Description:TODO(access_token服务类，提供生成，过期，验证等服务)   
 * @author: samuel 
 * @date:   2017年7月5日 下午5:28:27   
 *   
 *
 */
@Service
public interface AccessTokenService {

	/**
	 * 
	 * @Title: createToken   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param:  appId 第三方用户唯一凭证
	 * @param:  dataorgid  分公司ID
	 * @param:  secret	第三方用户唯一凭证密钥，既appsecret
	 * @return: String      
	 * @throws
	 */
	public String createToken(Accesstoken accesstoken)  throws Exception;
	
	/**
	 * 
	 * @Title: validateAccessToken   
	 * @Description: TODO(验证token是否合法)   
	 * @param: accessToken
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public Accesstoken validateAccessToken(String accessToken);
	
	/**
	 * 
	 * @Title: expireAccessToken   
	 * @Description: TODO(失效 accessToken)   
	 * @param: @param accessToken
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public boolean expireAccessToken(String accessToken);
	
	/**
	 * 
	 * @Title: getAccesstoken   
	 * @Description: TODO(查询用户TOKEN明细信息)   
	 * @param: @param accessToken
	 * @param: @return      
	 * @return: Accesstoken      
	 * @throws
	 */
	public Accesstoken getAccesstoken(String accessToken);
	
    /**
     * 
     * @Title: selectAll   
     * @Description: TODO(查询所有的token)   
     * @param accesstoken
     * @return:List<Accesstoken>
     */
    public PagedResult<Accesstoken> selectAllWithPage(Accesstoken accesstoken,Integer pageNo, Integer pageSize);
    
    /**
     * 
     * @Title: delAccessToken   
     * @Description: TODO(删除token)   
     * @param ids
     * @return:ReturnInfo
     */
    public ReturnInfo delAccessToken(String ids);
	
}
