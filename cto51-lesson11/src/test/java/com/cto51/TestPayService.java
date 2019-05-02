package com.cto51;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cto51.dto.PayDto;
import com.cto51.service.PayService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPayService {

	@Autowired
	private PayService service;

	@Test
	public void saveTest() {
		PayDto fromUser = new PayDto();
		fromUser.setName("公众号 聊点");
		fromUser.setPayCard("6626881209089045");
		fromUser.setMomey(200000.0f);
		
		PayDto toUser = new PayDto();
		toUser.setName("架构师知音");
		toUser.setPayCard("6566881209089067");
		toUser.setMomey(200000.0f);
		
		service.save(fromUser);
		service.save(toUser);
	}

	@Test
	public void doPayTest() {
		PayDto fromUser = new PayDto();
		fromUser.setId(1);
		fromUser.setName("公众号 聊点");
		fromUser.setPayCard("6626881209089045");
		fromUser.setMomey(200000.0f-100);
		
		PayDto toUser = new PayDto();
		toUser.setId(2);
		toUser.setName("架构师知音");
		toUser.setPayCard("6566881209089067");
		toUser.setMomey(200000.0f+100);
		service.doPay(fromUser, toUser);
	}
	
	
	@Test
	public void deleteTest() {
		service.delete(2);
	}

	@Test
	public void findAllTest() {
		List<PayDto> list = service.findAll();
		System.out.println(list.size());
		if (list.size() > 0) {
			PayDto p = list.get(0);
			System.out.println(p.getId());
			System.out.println(p.getName());
			System.out.println(p.getPayCard());
			System.out.println(p.getMomey());
		}
	}

	@Test
	public void getPayTest() {
		PayDto p = service.getPay(2);
		System.out.println(p.getId());
		System.out.println(p.getName());
		System.out.println(p.getPayCard());
		System.out.println(p.getMomey());
	}

}
