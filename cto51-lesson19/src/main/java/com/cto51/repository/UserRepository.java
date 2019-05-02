package com.cto51.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.cto51.dto.UserDto;

public interface UserRepository extends ElasticsearchRepository<UserDto, Long>{
	
	UserDto getUserByUserName(String userName);
	
	UserDto getUserByPosition(String position);

	int deleteUserByUserName(String userName);
}
