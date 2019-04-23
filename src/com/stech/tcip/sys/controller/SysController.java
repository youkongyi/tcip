package com.stech.tcip.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stech.tcip.sys.pojo.ReturnInfo;

@Controller
public class SysController {

	
	/**
	 * 
	 * @Title: access_error   
	 * @Description: TODO(接口访问异常)   
	 * @param err_code
	 * @return:String
	 */
	@RequestMapping("/sys/access_error")
	@ResponseBody
	public ReturnInfo access_error(String err_code){
		System.out.println("err_code:"+err_code);
		ReturnInfo returnInfo = new ReturnInfo();
		returnInfo.setResult(err_code);
		return returnInfo;
	}
	
	/**
	 * 
	 * @Title: index   
	 * @Description: TODO(主界面)   
	 * @return:String
	 */
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	/**
	 * 
	 * @Title: login   
	 * @Description: TODO(登录页)   
	 * @return:String
	 */
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	/**
	 * 
	 * @Title: doLogin   
	 * @Description: TODO(登录页)   
	 * @return:String
	 */
	@RequestMapping("/doLogin")
	public ModelAndView doLogin(String userName,String password,HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView();
		if ("admin".equals(userName) && "tcipAdmin".equals(password)){
			request.getSession().setAttribute("admin", userName);
			mv.setViewName("/index");
			return mv;
		}
		
		//mv.addObject(attributeValue);
		mv.setViewName("/login");
		
		return mv;
	}
}
