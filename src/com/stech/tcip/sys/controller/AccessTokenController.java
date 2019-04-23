package com.stech.tcip.sys.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stech.tcip.sys.pojo.Accesstoken;
import com.stech.tcip.sys.pojo.ReturnInfo;
import com.stech.tcip.sys.services.AccessTokenService;
import com.stech.tcip.sys.util.PagedResult;

@Controller
public class AccessTokenController {

	private static final Logger logger = LogManager.getLogger(AccessTokenController.class);
	
	@Autowired
	private AccessTokenService accessTokenService;
	
	//分页参数
	private PagedResult<Accesstoken> pageResult;
	
	//生成token
	@RequestMapping(value="sys/token/token_add",consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo token_add(@RequestBody Accesstoken accesstoken) throws Exception{
		logger.info(accesstoken);
		ReturnInfo returnInfo = new ReturnInfo("1");
		accesstoken.setState(0);
		
		//验证参数是否为空
		if(accesstoken.getAppid() == null || "".equals(accesstoken.getAppid())){
			returnInfo.setMsg("缺少必须的参数APPID");
			return returnInfo;			
		}else if(accesstoken.getOrgcode() == null || "".equals(accesstoken.getOrgcode())){
			returnInfo.setMsg("缺少必须的参数getDataorgid");
		}else if(accesstoken.getDataorgid() == null || "".equals(accesstoken.getDataorgid())){
			returnInfo.setMsg("缺少必须的参数getDataorgid");
		}else {
			returnInfo.setMsg(accessTokenService.createToken(accesstoken));
			returnInfo.setResult("0");
		}
		return returnInfo;
	}
	

	/**
	 * 
	 * @Title: token_list   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param para
	 * @return:String
	 */
	@RequestMapping("/sys/token/token_list")
	public String token_list(Model model,Accesstoken accesstoken,@RequestParam(value="pageNo",defaultValue="1")Integer pageNo, 
								@RequestParam(value="pageSize",defaultValue="15")Integer pageSize){
		//请求服务获取数据
		pageResult= accessTokenService.selectAllWithPage(accesstoken,pageNo, pageSize);
		
		model.addAttribute("pageResult", pageResult);
		
		return "/sys/token/token_list";
	}
	
	@RequestMapping("/sys/token/token_del")
	@ResponseBody
	public ReturnInfo tokenDel(String ids){
		return accessTokenService.delAccessToken(ids);
	}
	
	
	@RequestMapping("/sys/token/token_modify")
	public String token_modify(){
		return "sys/token/token_modify";
	}
	
}
