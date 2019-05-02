package com.cto51;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cto51.dao.UserDao;
import com.cto51.dto.GenderDto;
import com.cto51.dto.GradeDto;
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
		user.setMobileNo("13711645815");
		user.setNickName("公众号 聊点");
		user.setPhoto("/user/pic/1.png");
		user.setEmail("414679493@qq.com");
		user.setBirthday(new Date());
		dao.save(user);
	}

	@Test
	public void updateTest() {
		UserDto user = new UserDto();
		user.setId(1);
		user.setName("聊点");
		user.setMobileNo("13711645813");
		user.setNickName("公众号 聊点");
		user.setPhoto("/user/pic/4.png");
		user.setEmail("happyhuangjinjin@sina.com");
		user.setBirthday(new Date());
		dao.update(user);
	}

	@Test
	public void deleteTest() {
		dao.delete(8);
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
		UserDto u = dao.getUser(9);
		System.out.println(u.getId());
		System.out.println(u.getEmail());
		System.out.println(u.getName());
		System.out.println(u.getNickName());
		System.out.println(u.getPhoto());
		System.out.println(u.getBirthday());
		System.out.println(u.getMobileNo());
	}

	@Test
	public void findAllRsTest() {
		List<UserDto> list = dao.findAllRs();
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
	public void getUserRsTest() {
		UserDto u = dao.getUserRs(9);
		System.out.println(u.getId());
		System.out.println(u.getEmail());
		System.out.println(u.getName());
		System.out.println(u.getNickName());
		System.out.println(u.getPhoto());
		System.out.println(u.getBirthday());
		System.out.println(u.getMobileNo());
	}

	@Test
	public void getAllUserWithClassTest() {
		List<UserDto> list = dao.getAllUserWithClass();
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
			GenderDto gd = u.getGenderDto();
			System.out.println(gd.getGenderName());
		}
	}

	@Test
	public void getAllUserAndGradeTest() {
		List<UserDto> list = dao.getAllUserAndGrade();
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
			List<GradeDto> gd = u.getGrades();
			System.out.println(gd.size());
		}
	}

}
