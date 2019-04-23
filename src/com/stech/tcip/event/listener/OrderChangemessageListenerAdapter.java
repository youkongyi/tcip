package com.stech.tcip.event.listener;

import org.springframework.stereotype.Component;

import com.stech.tcip.sys.util.Constants;

/**
 * 
 * @ClassName:  OrderChangemessageListenerAdapter   
 * @Description:TODO(工单状态变更)   
 * @author: samuel 
 * @date:   2017年8月10日 下午3:12:48   
 *   
 *
 */
@Component
public class OrderChangemessageListenerAdapter extends AbstractMessageListenerAdapter{
	
	//接收来自TCIS的消息并推送给注册了该事件的应用
	public void handleMessage(String message){
		Commonhandler(Constants.TCIS_PUSH_ORDERCHANGE, message);
	}
}
