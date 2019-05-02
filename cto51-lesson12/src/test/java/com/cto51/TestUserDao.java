package com.cto51;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cto51.dao.UserDao;
import com.cto51.dto.UserDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserDao {

	@Autowired
	private UserDao dao;

	@Test
	public void saveTest() {
		UserDto user = new UserDto();
		user.setName("聊点");
		user.setMobileNo("13711645813");
		user.setNickName("聊点");
		user.setPhoto("/user/pic/1.png");
		user.setEmail("happyhuangjinjin@sina.com");
		user.setBirthday(new Date());
		dao.save(user);
	}

	@Test
	public void updateTest() {
		UserDto user = new UserDto();
		user.setId(8);
		user.setName("聊点");
		user.setMobileNo("13711645813");
		user.setNickName("聊点");
		user.setPhoto("/user/pic/2.png");
		user.setEmail("happyhuangjinjin@sina.com");
		user.setBirthday(new Date());
		dao.update(user);
	}

	@Test
	public void deleteTest() {
		dao.delete(6);
	}

	@Test
	public void findAllTest() {
		List<UserDto> list = dao.findAll();
		System.out.println(list.size());
		if (list.size() > 0) {
			UserDto u = list.get(0);
			System.out.println(u.getId());
			System.out.println(u.getEmail());
			System.out.println(u.getName());
			System.out.println(u.getNickName());
			System.out.println(u.getPhoto());
			System.out.println(u.getBirthday());
			System.out.println(u.getMobileNo());
		}
	}

	@Test
	public void getUserTest() {
		UserDto u = dao.getUser(8);
		System.out.println(u.getId());
		System.out.println(u.getEmail());
		System.out.println(u.getName());
		System.out.println(u.getNickName());
		System.out.println(u.getPhoto());
		System.out.println(u.getBirthday());
		System.out.println(u.getMobileNo());
	}

}
