package com.cto51.dao;

import java.util.List;

import com.cto51.model.User;

public interface UserDao {

	Integer addUser(User user);

	User getUser(Integer id);

	List<User> listUser();

	Integer updateUser(User user);

	Integer deleteUser(Integer id);

}
