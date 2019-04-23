package com.stech.tcip.sys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.stech.tcip.sys.pojo.Accesstoken;
import com.stech.tcip.sys.pojo.RequestInfo;
import com.stech.tcip.sys.services.AccessTokenService;
import com.stech.tcip.sys.services.AppService;
import com.stech.tcip.sys.util.Constants;

/**
 * 
 * @ClassName: AccessInterceptor
 * @Description:TODO(系统拦截器)
 * @author: samuel
 * @date: 2017年7月5日 下午4:16:32
 * 
 *
 */
@Component
public class AccessInterceptor extends HandlerInterceptorAdapter {

	private static Logger logger = LogManager.getLogger(AccessInterceptor.class);

	// Token服务类
	@Autowired
	private AccessTokenService accessTokenService;

	// 应用服务类
	@Autowired
	private AppService appService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 请求信息
		RequestInfo requestInfo = new RequestInfo();
		String uri = request.getRequestURI();
		String uris[] = uri.split("/");
		String tcipCode = uris[2];

		if (uri.startsWith("/tcip/query_") || uri.startsWith("/tcip/busi_") || uri.startsWith("/tcip/fee_") || uri.startsWith("/tcip/service/event_") 
				|| uri.startsWith("/tcip/ib")) {
			// 获取access_token
			String access_token = request.getParameter("access_token");

			logger.info("access_token:" + access_token);

			// 验证access_token是否合法，不合法跳转到统一处理页面
			Accesstoken accesstoken = accessTokenService.validateAccessToken(access_token);
			if (accesstoken == null || accesstoken.getAppid() == null) {
				response.sendRedirect("/tcip/sys/access_error?err_code=" + Constants.ERR_CODE_UNLAWFULTOKEN);
				return false;
			}

			tcipCode = "service".equals(tcipCode) ? uris[3] : uris[2];

			// 该应用有该地址的访问权限
			if (appService.validateAuthorize(accesstoken.getAppid(), tcipCode)) {

				// 组装请求信息
				requestInfo.setAppid(accesstoken.getAppid());
				requestInfo.setOrgcode(accesstoken.getOrgcode());
				requestInfo.setDataorgid(accesstoken.getDataorgid() + "");
				requestInfo.setRequestid(request.getSession().getId());

				request.setAttribute("requestInfo", requestInfo);
				return true;

			} else {
				response.sendRedirect("/tcip/sys/access_error?err_code=" + Constants.ERR_CODE_UNLAWFULSERVICE);
				return false;
			}

		} else {
			HttpSession session = request.getSession();

			String admin = (String) session.getAttribute("admin");
			if (!"admin".equals(admin)) {
				response.sendRedirect("/tcip/login");
				return false;
			}

		}

		return true;
	}

}
