package com.stech.tcip.sys.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.stech.tcip.sys.cache.AccessTokenCache;
import com.stech.tcip.sys.dao.AccesstokenMapper;
import com.stech.tcip.sys.pojo.Accesstoken;
import com.stech.tcip.sys.pojo.ReturnInfo;
import com.stech.tcip.sys.services.AccessTokenService;
import com.stech.tcip.sys.util.Constants;
import com.stech.tcip.sys.util.PageBeanUtil;
import com.stech.tcip.sys.util.PagedResult;
import com.stech.tcip.sys.util.SecretUtils;
import com.sun.org.apache.xml.internal.security.utils.Base64;

@Service("accessTokenService")
public class AccessTokenServiceImpl implements AccessTokenService{
	
	private static final Logger logger = LogManager.getLogger(AccessTokenServiceImpl.class);
	
	//accesstoken数据库处理对象
	@Autowired
	private AccesstokenMapper accesstokenMapper;
	
	//token缓存对象
	@Autowired
	private AccessTokenCache accessTokenCache;
	
	@Override
	public String createToken(Accesstoken accesstoken) throws Exception {
		
		/**
		 * 加密算法 (appID+orgcode+dataorgid)
		 * 
		 */
		String secret = accesstoken.getSecret();
		
		String key = accesstoken.getDataorgid() + secret+  accesstoken.getOrgcode()+ accesstoken.getAppid();
		
		String finalToken = "";
		if (accesstoken.getSecret().getBytes().length >24){
			finalToken = SecretUtils.encryptThreeDESECB(key, secret);
		}else {
			finalToken = SecretUtils.encryptThreeDESECB(key, Constants.SECRET_KEY);
		}
		
		finalToken = Base64.encode((finalToken+Math.random()).getBytes());
				
		//将token信息保存到数据库
		accesstoken.setAccesstoken(finalToken);
		accesstokenMapper.insert(accesstoken);
		logger.info(finalToken);
		return finalToken;
	}

	
	/**
	 * 
	 * @Title: validateAccessToken   
	 * @Description: TODO(验证token是否合法)   
	 * @param: accessToken
	 * @return: Accesstoken      
	 * @throws
	 */
	public Accesstoken validateAccessToken(String accessToken) {
		
		//判断accessToken是否为空
		if(accessToken == null || "".equals(accessToken)){
			return null;
		}
				
		//获取accessToken信息
		Accesstoken token =  accessTokenCache.get(accessToken);
		
		/*byte[] detoken = Base64Decoder.decode(token.getBytes(), 1, token.length()-1);
		String strdetoken = new String(detoken);
		System.out.println(new String(detoken));
		String detoken1 = strdetoken.substring(0,strdetoken.length()-Constants.TOKEN_OPERATOR.length());
		System.out.println(detoken1);
		
		String tokenele = new String(Base64Decoder.decode(detoken1.getBytes(), 0, detoken1.length()));
		System.out.println();
		String[] strArrays = tokenele.split("_");
		for (String ele : strArrays){
			System.out.println(ele);
		}*/
		
		return token;
	}

	@Override
	public boolean expireAccessToken(String accessToken) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public Accesstoken getAccesstoken(String accessToken) {
		return accesstokenMapper.selectByPrimaryKey(Integer.parseInt(accessToken));
	}

	
	public AccesstokenMapper getAccesstokenMapper() {
		return accesstokenMapper;
	}

	public void setAccesstokenMapper(AccesstokenMapper accesstokenMapper) {
		this.accesstokenMapper = accesstokenMapper;
	}


	
	public PagedResult<Accesstoken> selectAllWithPage(Accesstoken accesstoken, Integer pageNo, Integer pageSize) {
		//启用分页
		PageHelper.startPage(pageNo, pageSize);
		
		//查询数据
		List<Accesstoken> list =accesstokenMapper.selectAllAccesstokens(accesstoken);
		
		return PageBeanUtil.toPagedResult(list);
		
	}


	@Override
	public ReturnInfo delAccessToken(String ids) {
		String strIds[] = ids.substring(0,ids.length()-1).split(",");
		int successflag = 0;
		String retMes = "";
		for (String pkid : strIds){
			int delflag = accesstokenMapper.deleteByPrimaryKey(Integer.parseInt(pkid));
			if (delflag <1 ){
				successflag =1 ;
				retMes += "id:[" + pkid + "],删除错误!\n"; 
			}else {
				retMes += "id:[" + pkid + "],删除成功!\n"; 
			}
			
		}
		ReturnInfo info = new ReturnInfo();
		info.setResult(""+successflag);
		info.setMsg(retMes);
		return info;
	}

}
