package com.cto51.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.cto51.dao.UserDao;
import com.cto51.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	 //id生成器
	 private static AtomicInteger idGen = new AtomicInteger();
	
	 //内存数据库
	 private final ConcurrentMap<Integer, User> userTable = new ConcurrentHashMap<>();

	@Override
	public Integer addUser(User user) {
		Integer id = idGen.incrementAndGet();
		user.setId(id);
		userTable.put(id, user);
		return id;
	}

	@Override
	public User getUser(Integer id) {
		return userTable.get(id);
	}

	@Override
	public List<User> listUser() {
		return new ArrayList<User>(userTable.values());
	}

	@Override
	public Integer updateUser(User user) {
		userTable.put(user.getId(), user);
		return user.getId();
	}

	@Override
	public Integer deleteUser(Integer id) {
		userTable.remove(id);
		return id;
	}


}
