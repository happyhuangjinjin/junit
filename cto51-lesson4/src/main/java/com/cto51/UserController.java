package com.cto51;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cto51.dao.UserDao;
import com.cto51.model.User;

@RestController
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserDao userDao;
	
	@PostMapping("/user")
	public Map<String, Object> addUser(User user){
		Map<String, Object> resp = new HashMap<>();
		resp.put("code", "000000");
		resp.put("body", userDao.addUser(user));
		logger.info("--addUser--");
		return resp;
	}
	
	@GetMapping("/user/{id}")
	public Map<String, Object> getUser(@PathVariable Integer id){
		Map<String, Object> resp = new HashMap<>();
		resp.put("code", "000000");
		resp.put("body", userDao.getUser(id));
		logger.info("--getUser--");
		return resp;
	}
	
	@GetMapping("/user")
	public Map<String, Object> listUser(){
		Map<String, Object> resp = new HashMap<>();
		resp.put("code", "000000");
		resp.put("body", userDao.listUser());
		logger.info("--listUser--");
		return resp;
	}

	@PutMapping("/user")
	public Map<String, Object> updateUser(User user){
		Map<String, Object> resp = new HashMap<>();
		resp.put("code", "000000");
		resp.put("body", userDao.updateUser(user));
		logger.info("--updateUser--");
		return resp;
	}
	
	@DeleteMapping("/user/{id}")
	public Map<String, Object> deleteUser(@PathVariable Integer id){
		Map<String, Object> resp = new HashMap<>();
		resp.put("code", "000000");
		resp.put("body", userDao.deleteUser(id));
		logger.info("--deleteUser--");
		return resp;
	}
}
