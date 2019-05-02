package com.cto51.p2p.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class P2PConsumer {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	// 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
	@JmsListener(destination = "jms-queue", containerFactory="queueFactory")
	public void receiveQueue(String text) {
		log.info("P2PConsumer收到 : {}", text);
	}
}
