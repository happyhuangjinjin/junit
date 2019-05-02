package com.cto51;

import javax.jms.ConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@Configuration
@EnableJms
public class ActiveMQConfig {

	    @Bean("queueFactory")
	    public JmsListenerContainerFactory<?> queueListenerFactory(ConnectionFactory connectionFactory) {
	        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	        factory.setConnectionFactory(connectionFactory);
	        factory.setPubSubDomain(false);
	        return factory;
	    }

	    @Bean("topicFactory")
	    public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory connectionFactory) {
	        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	        factory.setConnectionFactory(connectionFactory);
	        factory.setPubSubDomain(true);
	        return factory;
	    }
}
