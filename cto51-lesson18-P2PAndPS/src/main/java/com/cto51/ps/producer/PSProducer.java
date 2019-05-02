package com.cto51.ps.producer;

import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class PSProducer {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JmsMessagingTemplate jmsTemplate;

	@Autowired
	private ActiveMQTopic topic;

	public void sendQueue(String msg) {
		log.info("PSProducer发布消息 : {}",  msg);
		this.jmsTemplate.convertAndSend(this.topic, msg);
	}

}
