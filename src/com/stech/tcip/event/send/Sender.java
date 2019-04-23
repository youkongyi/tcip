package com.stech.tcip.event.send;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class Sender {

	private static final Logger logger = LogManager.getLogger(Sender.class);
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(Destination destination,String message){
		
		logger.info("---------------生产者发送消息-----------------");
		logger.info("---------------生产者发了一个消息-----------------");
		
		jmsTemplate.send(destination,new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {

				return session.createTextMessage(message);
				
			}
		});
		
		
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	
	
}
