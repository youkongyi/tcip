package com.stech.tcip.event.listener;

import org.springframework.stereotype.Component;

import com.stech.tcip.sys.util.Constants;

/**
 * 
 * @ClassName:  SendWithholdmessageListenerAdapter   
 * @Description:TODO(银行代扣送扣信息推送)   
 * @author: samuel 
 * @date:   2017年8月10日 下午3:14:15   
 *   
 *
 */
@Component
public class SendWithholdmessageListenerAdapter extends AbstractMessageListenerAdapter{
	
	//接收来自TCIS的消息并推送给注册了该事件的应用
	public void handleMessage(String message){
		Commonhandler(Constants.TCIS_PUSH_SENDWITHHOLD, message);
	}
}
