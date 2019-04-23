package com.stech.tcip.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stech.tcip.sys.pojo.InterService;
import com.stech.tcip.sys.services.InterfaceService;
import com.stech.tcip.sys.util.PagedResult;

@Controller
public class InterfaceController {
	
	@Autowired
	private InterfaceService interfaceService;

	@RequestMapping("/sys/interface/interface_list")
	public String interfaceList(Model model,InterService interService,@RequestParam(value="pageNo",defaultValue="1")int pageNo,
						@RequestParam(value="pageSize",defaultValue="10")int pageSize){
		
		PagedResult<InterService> pagedResult= interfaceService.selectInterServices(interService, pageNo, pageSize);
		model.addAttribute("pagedResult",pagedResult);
		model.addAttribute("interService",interService);
		return "/sys/interface/interface_list";
	}
	
}
