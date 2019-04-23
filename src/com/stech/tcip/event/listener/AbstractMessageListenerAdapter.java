package com.stech.tcip.event.listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.base.Predicate;
import com.stech.tcip.event.dao.EventpushlogMapper;
import com.stech.tcip.event.dao.EventregMapper;
import com.stech.tcip.event.pojo.Eventpushlog;
import com.stech.tcip.event.pojo.Eventreg;
import com.stech.tcip.sys.util.Constants;

/**
 * 
 * @ClassName: AbstractMessageListenerAdapter
 * @Description:TODO(消息推送抽象对象)
 * @author: samuel
 * @date: 2017年8月10日 下午3:15:50
 * 
 *
 */
public abstract class AbstractMessageListenerAdapter {

	private static final Logger logger = LogManager.getLogger(AbstractMessageListenerAdapter.class);

	@Autowired
	private EventregMapper eventregMapper;
	@Autowired
	private EventpushlogMapper eventpushlogMapper;

	public abstract void handleMessage(String message);

	public int invokePush(String urlAddr, String postParam, String token) throws IOException {

		// 如果有token信息则带上token参数
		if (!"".equals(token) && null != token) {
			urlAddr = urlAddr + "?token=" + token;
		}

		// 创建httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建post方式请求对象
		HttpPost httpPost = new HttpPost(urlAddr);
		logger.info(urlAddr);
		logger.info(postParam);

		// 设置请求参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		NameValuePair nameValuePair = new BasicNameValuePair("jsonStr", postParam);
		nvps.add(nameValuePair);

		httpPost.setEntity(new UrlEncodedFormEntity(nvps, Constants.ENCODING_UTF8));

		// 设置header信息
		// 指定报文头【Content-type】、【User-Agent】
		// httpPost.setHeader("Content-type",
		// "application/x-www-form-urlencoded");
		// httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0;
		// Windows NT; DigExt)");

		// 向服务器端发送请求 并且获取响应对象 浏览器中输入网址点击回车
		CloseableHttpResponse response = httpClient.execute(httpPost);

		// 获取响应对象中的响应码
		StatusLine statusLineline = response.getStatusLine();
		int statusCode = statusLineline.getStatusCode();

		logger.info(statusCode);

		// if (statusCode == 200){
		// HttpEntity respEntity = response.getEntity();
		// String respBody = EntityUtils.toString(respEntity,
		// Constants.ENCODING_UTF8);
		// logger.info(respBody);
		// EntityUtils.consume(respEntity);
		// }

		// 释放链接
		response.close();
		httpClient.close();
		return statusCode;

	}

	protected void Commonhandler(String messageCode, String message) {
		// 获取需要推送的任务清单
		Eventreg eventreg = new Eventreg();
		eventreg.setMessagecode(messageCode);
		eventreg.setCancelflag(0);
		eventreg.setDataorgid(getDataorgid(message));
		List<Eventreg> list = eventregMapper.pusheventList(eventreg);

		// 根据注册事件的应用ID进行推送
		for (Eventreg eventreged : list) {
			String url = eventreged.getUrl();
			String token = eventreg.getToken();
			//int status = 0;
			logger.info(eventreged.getAppid());
			
			
			Eventpushlog eventpushlog = new Eventpushlog();
			eventpushlog.setAppid(eventreged.getAppid());
			eventpushlog.setDataorgid(getDataorgid(message));
			eventpushlog.setPushcode(messageCode);
			eventpushlog.setUrl(url);
			
			eventpushlog.setMessage(message.getBytes());
			//eventpushlogMapper.insert(eventpushlog);

			// RetryerBuilder 构建重试实例
			// retryer,可以设置重试源且可以支持多个重试源，可以配置重试次数或重试超时时间，以及可以配置等待时间间隔
			Retryer<Integer> retryer = RetryerBuilder.<Integer>newBuilder().retryIfException().// 设置异常重试源
					retryIfResult(new Predicate<Integer>() {// 设置自定义段元重试源，
						@Override
						public boolean apply(Integer state) {// 特别注意：这个apply返回true说明需要重试，与操作逻辑的语义要区分
							if (state != 200){
								return true;
							}
							return false;
						}
					}).withStopStrategy(StopStrategies.stopAfterAttempt(3))// 设置重试3次，同样可以设置重试超时时间
					.withWaitStrategy(WaitStrategies.fixedWait(5000L, TimeUnit.MILLISECONDS)).build();// 设置每次重试间隔
			
			try {
				
				retryer.call(new Callable<Integer>() {
					@Override
					public Integer call() throws Exception {
						int status = invokePush(url, message, token);
						eventpushlog.setStatus(status + "");
						return status;
					}
				});
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 记录推送日志
			eventpushlogMapper.insert(eventpushlog);
		}
	}

	/**
	 * 
	 * @Title: getDataorgid
	 * @Description: TODO(截取推送消息中的分公司ID)
	 * @param message
	 * @return:String
	 */
	private String getDataorgid(String message) {
		int dataorgidstart = message.lastIndexOf("dataorgid");
		int datatorgidend = message.indexOf(",", message.lastIndexOf("dataorgid"));
		return message.substring(dataorgidstart + 12, datatorgidend - 1);
	}

}
