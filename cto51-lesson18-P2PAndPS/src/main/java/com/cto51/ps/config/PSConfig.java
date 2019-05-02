package com.cto51.ps.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PSConfig {
	
	/**
	 * 发布/订阅
	 * 
	 * @return
	 */
	@Bean
	public ActiveMQTopic topic() {
		return new ActiveMQTopic("jms-topic");
	}
 
}
