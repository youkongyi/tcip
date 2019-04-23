package com.stech.tcip.event.listener;

import com.stech.tcip.sys.util.Constants;

public class GssellordermessageListenerAdapter extends AbstractMessageListenerAdapter {

	// 接收来自TCIS的消息并推送给注册了该事件的应用
	public void handleMessage(String message) {
		Commonhandler(Constants.TCIS_PUSH_GSSELLORDER, message);
	}
}
