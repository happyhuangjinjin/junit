package com.cto51.p2p.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class P2PConfig {
	
	/**
	 * 点对点
	 * 
	 * @return
	 */
	@Bean
	public ActiveMQQueue queue() {
		return new ActiveMQQueue("jms-queue");
	}
 
}
