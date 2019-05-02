package com.cto51.dao;

import java.util.List;

import com.cto51.dto.UserDto;

public interface UserDao {

	int save(UserDto user);

	int update(UserDto user);

	int delete(Integer id);

	List<UserDto> findAll();

	UserDto getUser(Integer id);

}
