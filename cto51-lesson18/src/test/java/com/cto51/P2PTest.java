package com.cto51;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cto51.p2p.producer.P2PProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class P2PTest {

	@Autowired
	private P2PProducer producer;

	@Test
	public void p2pTest() throws InterruptedException {
	    this.producer.sendQueue("测试点对点模式");
	}
	
	
	@Test
	public void p2pMultiConsumerTest() throws InterruptedException {
		for(int i=0; i<5; i++){
			this.producer.sendQueue("测试多消费者点对点模式"+i);
		}
	}
}
