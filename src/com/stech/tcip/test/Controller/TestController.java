package com.stech.tcip.test.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stech.tcip.event.send.Sender;
import com.stech.tcip.schedule.dao.ScheduleMapper;
import com.stech.tcip.schedule.dto.ScheduleDTO;
import com.stech.tcip.schedule.services.ScheduleService;
import com.stech.tcip.schedule.util.BusinessException;

@Controller
public class TestController {
	
	
	@Autowired
	private Destination destinationNewBill;
	
	@Autowired
	private Sender sender;
	

	@RequestMapping("/test/test")
	public String test(){
		return "/test";
	}
	
	@RequestMapping("/test/push_test")
	public String pushTest(){
		
		return "/push_test";
	}
	
	@RequestMapping("/test/sendMessage")
	public String sendMessage(){
		String jsonstr = "{\"dataorgid\":\"11302\",\"orgcode\":\"ZS0105\",\"4003\":[{\"userid\":\"1400000001\"},{\"userid\":\"1400000001\"}]}";
		sender.sendMessage(destinationNewBill, jsonstr);
		return "1";
	}
	
	@RequestMapping("/test/receiveMes")
	public String receiveMes(String jsonStr){
		System.out.println("receiveMes-------------------------------" + jsonStr);
		return "/push_test";
	}
	
	@Autowired
	private ScheduleService scheduleService;
	
	@RequestMapping("/addTask")
	public void addTask() throws BusinessException {
		ScheduleDTO task = new ScheduleDTO();
		task.setId("1");
		task.setName("测试");
		task.setExportCron("0/5 * * * * ?");
		scheduleService.addJob(task);
	}
	
	@RequestMapping("/removeTask")
	public void removeTask() throws BusinessException {
		/*List<String> list = new ArrayList<String>();
		list.add("测试@1");
		scheduleService.removeJob(list);*/
	}
	
	@Autowired
	private ScheduleMapper scheduleMapper;
	
	@RequestMapping("/query")
	public void query() {
	}
	
}
