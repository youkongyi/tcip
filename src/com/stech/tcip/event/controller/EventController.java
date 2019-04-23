package com.stech.tcip.event.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stech.tcip.event.pojo.Eventpushlog;
import com.stech.tcip.event.pojo.Eventreg;
import com.stech.tcip.event.pojo.ReqEventreg;
import com.stech.tcip.event.services.EventPushlogService;
import com.stech.tcip.event.services.EventService;
import com.stech.tcip.sys.pojo.RequestInfo;
import com.stech.tcip.sys.pojo.ReturnInfo;
import com.stech.tcip.sys.util.PagedResult;

@Controller
public class EventController {

	// 事件处理服务类
	@Autowired
	private EventService eventService;

	// 事件推送日志服务
	@Autowired
	private EventPushlogService eventPushlogService;

	// 请求报文
	@Autowired
	private RequestInfo requestInfo;

	/**
	 * 
	 * @Title: evenReg
	 * @Description: TODO(推送消息注册)
	 * @param eventreg
	 * @return:int
	 */
	@RequestMapping(value = "/service/event_reg", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ReturnInfo eventReg(@RequestBody ReqEventreg eventreg, HttpServletRequest request) {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		ReturnInfo returnInfo = eventService.eventReg(eventreg.getBody(),requestInfo);
		return returnInfo;
	}

	/**
	 * 
	 * @Title: eventCancel
	 * @Description: TODO(事件取消)
	 * @param appid
	 *            第三方应用ID
	 * @param messagecode
	 *            事件编码
	 * @param type
	 *            事件推送类型
	 * @return:int
	 */
	@RequestMapping(value = "/service/event_cancel", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ReturnInfo eventCancel(@RequestBody ReqEventreg reqEventreg, HttpServletRequest request) {
		// 获取请求头
		requestInfo = (RequestInfo) request.getAttribute("requestInfo");
		
		Eventreg eventreg = reqEventreg.getBody();
		eventreg.setAppid(requestInfo.getAppid());
		
		return eventService.eventCancel(eventreg);
	}

	/**
	 * 
	 * @Title: pusheventList
	 * @Description: TODO(查询注册事件清单)
	 * @return:PagedResult<Eventreg>
	 */
	@RequestMapping(value = "/sys/pushevent/pushevent_list", produces = "application/json;charset=UTF-8")
	public ModelAndView pusheventList(Eventreg eventreg, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		ModelAndView mv = new ModelAndView();
		PagedResult<Eventreg> pagedResult = eventService.pusheventList(eventreg, pageNo, pageSize);
		mv.addObject("pagedResult", pagedResult);
		mv.setViewName("/sys/pushevent/pushevent_list");
		return mv;
	}

	/**
	 * 
	 * @Title: pusheventHistory
	 * @Description: TODO(推送日志查询)
	 * @param eventpushlog
	 * @param pageNo
	 * @param pageSize
	 * @return:ModelAndView
	 */
	@RequestMapping(value = "/sys/pushevent/pushevent_history", produces = "application/json;charset=UTF-8")
	public ModelAndView pusheventHistory(Eventpushlog eventpushlog, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		ModelAndView mv = new ModelAndView();

		PagedResult<Eventpushlog> pagedResult = eventPushlogService.selectPushLogs(eventpushlog, pageNo, pageSize);

		mv.addObject("pagedResult", pagedResult);
		mv.setViewName("/sys/pushevent/pushevent_history");
		return mv;
	}
	
	
	/**
	 * 
	 * @Title: pusheventHistory
	 * @Description: TODO(推送日志查询)
	 * @param eventpushlog
	 * @param pageNo
	 * @param pageSize
	 * @return:ModelAndView
	 */
	@RequestMapping(value = "/sys/pushevent/viewMessage", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String viewMessage(int id) {
		return eventPushlogService.viewMessage(id);

	}
}
