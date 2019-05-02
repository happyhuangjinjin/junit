package com.cto51.p2p.producer;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class P2PProducer {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JmsMessagingTemplate jmsTemplate;

	@Autowired
	private ActiveMQQueue queue;

	public void sendQueue(String msg) {
		log.info("P2PProducer send message to queue: {}",  msg);
		this.jmsTemplate.convertAndSend(this.queue, msg);
	}

}
