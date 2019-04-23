package com.stech.tcip.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stech.tcip.sys.dto.AppAuthorizes;
import com.stech.tcip.sys.pojo.App;
import com.stech.tcip.sys.pojo.AppInterfaceKey;
import com.stech.tcip.sys.pojo.ReturnInfo;
import com.stech.tcip.sys.services.AppService;
import com.stech.tcip.sys.util.PagedResult;

@Controller
public class AppController {

	//private static final Logger logger = LogManager.getLogger(AppController.class);
	
	@Autowired
	private AppService appService;
	
	//分页参数
	private PagedResult<App> pageResult;
	
	
	@RequestMapping("/sys/app/app_list")
	public String app_list(Model model,App app,@RequestParam(value="pageNo",defaultValue="1")Integer pageNo, 
								@RequestParam(value="pageSize",defaultValue="15")Integer pageSize){
		//请求服务获取数据
		pageResult= appService.selectApps(app, pageNo, pageSize);
		
		model.addAttribute("pageResult", pageResult);
		
		return "/sys/app/app_list";
	}
	
	@RequestMapping("/sys/app/app_authorizes")
	public String appAuthorizes(Model model,AppAuthorizes appAuthorizes,String appId,@RequestParam(value="pageNo",defaultValue="1")Integer pageNo, 
			@RequestParam(value="pageSize",defaultValue="20")Integer pageSize){
		if (appId != null && appId !=""){
			appAuthorizes.setAppId(appId);
		}
		
		PagedResult<AppAuthorizes> pagedResult = appService.appAuthorizes(appAuthorizes, pageNo, pageSize);
		model.addAttribute("appAuthorizes",appAuthorizes);
		model.addAttribute("pagedResult",pagedResult);
		return "/sys/app/app_authorizes";
	}
	
	
	@RequestMapping("/sys/app/appAuthorize")
	@ResponseBody
	public ReturnInfo appAuthorize(@RequestBody AppInterfaceKey appInterfaceKey){
		int results = appService.appAuthorize(appInterfaceKey);
		return new ReturnInfo(results+"");
	}
	
	@RequestMapping("/sys/app/appDeAuthorize")
	@ResponseBody
	public ReturnInfo appDeAuthorize(@RequestBody AppInterfaceKey appInterfaceKey){
		int results = appService.appdeAuthorize(appInterfaceKey);
		return new ReturnInfo(results+"");
	}
	

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	public PagedResult<App> getPageResult() {
		return pageResult;
	}

	public void setPageResult(PagedResult<App> pageResult) {
		this.pageResult = pageResult;
	}
}
