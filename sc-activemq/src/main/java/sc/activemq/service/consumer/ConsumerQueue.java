package sc.activemq.service.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerQueue {

	// 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
	@JmsListener(destination = "jms-queue")
	public void receiveQueue(String text) {
		System.out.println("ConsumerQueue收到:" + text);
	}
}
