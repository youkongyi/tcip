package com.stech.tcip.sys.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TcipExceptionHandler implements HandlerExceptionResolver {

	@Override
	@ResponseBody
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception exception) {
		// TODO Auto-generated method stub
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg","{\"result\":\"4006\",\"msg\":\""+exception.getMessage()+"\"}");
		mv.setViewName("error");
		return mv;
	}

}
