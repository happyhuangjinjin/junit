package com.cto51;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cto51.ps.producer.PSProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PSTest {

	@Autowired
	private PSProducer producer;

	@Test
	public void pSTest() throws InterruptedException {
	    this.producer.sendQueue("测试发布/订阅模式");
	}
	
}
