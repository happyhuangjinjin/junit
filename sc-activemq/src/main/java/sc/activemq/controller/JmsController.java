package sc.activemq.controller;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import sc.activemq.service.ProductService;

@RestController
public class JmsController {

	@Autowired
	private ActiveMQQueue queue;

	@Autowired
	private ActiveMQTopic topic;

	@Autowired
	private ProductService productService;

	@PostMapping("/activeMq/queue")
	public void sendQueue(String msg) {
		productService.sendMessage(this.queue, msg);
	}

	@PostMapping("/activeMq/topic")
	public void sendTopic(String msg) {
		productService.sendMessage(this.topic, msg);
	}
}
