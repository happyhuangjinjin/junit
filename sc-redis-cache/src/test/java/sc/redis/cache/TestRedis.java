package sc.redis.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sc.redis.cache.model.User;
import sc.redis.cache.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

	private static final Logger logger = LoggerFactory.getLogger(TestRedis.class);

	@Autowired
	private UserService userService;
	
	@Test
	public void add() {
		User u = new User();
		u.setId(4L);
		u.setUserName("huangjinjin");
		u.setPosition("cto");
		u.setAge(24);
		userService.addUser(u);
		
	}
	
	@Test
	public void get() {
		User u =userService.getUser(4L);
		logger.info("userName = "+ u.getUserName());
	}
}