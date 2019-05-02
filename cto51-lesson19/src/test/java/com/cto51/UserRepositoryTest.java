package com.cto51;

import java.util.Iterator;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cto51.dto.UserDto;
import com.cto51.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;

	@Test
	public void saveTest() {
		UserDto u = new UserDto();
		u.setId(1L);
		u.setUserName("黄金");
		u.setPosition("CTO");
		u.setSalary(100000f);
		userRepository.save(u);
		userRepository.save(u);
		u = new UserDto();
		u.setId(2L);
		u.setUserName("白银");
		u.setPosition("COO");
		u.setSalary(900000f);
		userRepository.save(u);
	}

	@Test
	public void getUsersTest() {
		for (UserDto userDto : userRepository.findAll()) {
			log.info("user: id={}, userName={}, position={}, salary={}", userDto.getId(), userDto.getUserName(),
					userDto.getPosition(), userDto.getSalary());
		}
	}

	@Test
	public void deleteUserTest() {
		userRepository.deleteById(1L);
		for (UserDto userDto : userRepository.findAll()) {
			log.info("user: id={}, userName={}, position={}, salary={}", userDto.getId(), userDto.getUserName(),
					userDto.getPosition(), userDto.getSalary());
		}
	}

	@Test
	public void getUserByUserNameTest() {
		UserDto userDto = userRepository.getUserByUserName("白银");
		log.info("user: id={}, userName={}, position={}, salary={}", userDto.getId(), userDto.getUserName(),
				userDto.getPosition(), userDto.getSalary());
	}

	public void print(Iterable<UserDto> userDtoIter) {
		if (userDtoIter != null && userDtoIter.iterator() != null) {
			Iterator<UserDto> iter = userDtoIter.iterator();
			while (iter.hasNext()) {
				UserDto userDto = iter.next();
				log.info("user: id={}, userName={}, position={}, salary={}", userDto.getId(), userDto.getUserName(),
						userDto.getPosition(), userDto.getSalary());
			}
		}
	}

	@Test
	public void queryBuilderTest() {
		// 完全匹配
		QueryBuilder query = QueryBuilders.termQuery("userName", "白");
		Iterable<UserDto> userDtoIter = userRepository.search(query);
		print(userDtoIter);
		log.info("-----------");
		// 多个匹配
		query = QueryBuilders.multiMatchQuery("白", "userName", "position");
		userDtoIter = userRepository.search(query);
		log.info("-----------");
		print(userDtoIter);
		// 匹配所有文件
		query = QueryBuilders.matchAllQuery();
		userDtoIter = userRepository.search(query);
		print(userDtoIter);
	}

	@Test
	public void joinQueryTest() {
		QueryBuilder query = QueryBuilders.boolQuery()//
				.must(QueryBuilders.termQuery("userName", "白"))//
				.mustNot(QueryBuilders.termQuery("position", "COO"));
		Iterable<UserDto> userDtoIter = userRepository.search(query);
		print(userDtoIter);
	}
	
	  /**
     * 范围内查询
     */
	@Test
    public void rangeQueryTest() {
        QueryBuilder query = QueryBuilders.rangeQuery("salary")
            .from(0.0)
            .to(10000000.0f)
            .includeLower(true)     // 包含上界
            .includeUpper(true);      // 包含下届
        Iterable<UserDto> userDtoIter = userRepository.search(query);
		print(userDtoIter);
    }
    
}
