package sc.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sc.activemq.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMqTest {

	@Autowired
	private ActiveMQQueue queue;

	@Autowired
	private ActiveMQTopic topic;

	@Autowired
	private ProductService productService;

	@Test
	public void testJms() {
//		String msgQueue = "send 黄金 ";
//		for(int i=0; i<5; i++){
//			productService.sendMessage(this.queue, msgQueue+i);
//		}
		String msgTopic = "send 白银 ";
		for(int i=0; i<5; i++){
			productService.sendMessage(this.topic, msgTopic+i);
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
	}

}
