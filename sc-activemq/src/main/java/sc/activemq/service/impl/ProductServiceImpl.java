package sc.activemq.service.impl;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import sc.activemq.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Override
	public void sendMessage(Destination destination, String message) {
		jmsMessagingTemplate.convertAndSend(destination, message);
	}

}
