package com.cto51;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cto51.p2p.producer.P2PProducer;
import com.cto51.ps.producer.PSProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class P2PAndPSTest {

	@Autowired
	private PSProducer pSProducer;

	@Autowired
	private P2PProducer p2PProducer;
	
	@Test
	public void p2PAndPSTest() throws InterruptedException {
	    this.pSProducer.sendQueue("测试发布/订阅模式");
	    this.p2PProducer.sendQueue("测试点对点模式");
	}
	
}
