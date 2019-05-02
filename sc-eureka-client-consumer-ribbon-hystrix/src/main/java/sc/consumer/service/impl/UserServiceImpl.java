package sc.consumer.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.andrewoma.dexx.collection.ArrayList;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import sc.consumer.model.User;
import sc.consumer.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getUserError")
	@Override
	public Map<String, Object> getUser(Long id) {
		return restTemplate.getForObject("http://sc-eureka-client-provider:8200/user/getUser/{1}", Map.class, id);
	}
	
	public Map<String, Object> getUserError(Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "000000");
		map.put("msg", "ok");
		User u = new User();
		u.setId(-1L);
		u.setUserName("failName");
		map.put("body", u);
		return map;
	}

	@HystrixCommand(fallbackMethod = "listUserError")
	@Override
	public Map<String, Object> listUser() {
		return restTemplate.getForObject("http://sc-eureka-client-provider:8200/user/listUser", Map.class);
	}
	
	public Map<String, Object> listUserError(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "000000");
		map.put("msg", "ok");
		map.put("body", new ArrayList<User>());
		return map;
	}

	@HystrixCommand(fallbackMethod = "addUserError")
	@Override
	public Map<String, Object> addUser(User user) {
		return restTemplate.postForObject("http://sc-eureka-client-provider:8200/user/addUser", user, Map.class);
	}

	public Map<String, Object> addUserError(User user){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "000000");
		map.put("msg", "ok");
		map.put("body", 0);
		return map;
	}
	
	@HystrixCommand(fallbackMethod = "updateUserError")
	@Override
	public Map<String, Object> updateUser(User user) {
		restTemplate.put("http://sc-eureka-client-provider:8200/user/updateUser",user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "000000");
		map.put("msg", "ok");
		return map;
	}
	
	public Map<String, Object> updateUserError(User user){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "000000");
		map.put("msg", "ok");
		map.put("body", 0);
		return map;
	}

	@HystrixCommand(fallbackMethod = "deleteUserError")
	@Override
	public Map<String, Object> deleteUser(Long id) {
		restTemplate.delete("http://sc-eureka-client-provider:8200/user/deleteUser/{id}", id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "000000");
		map.put("msg", "ok");
		return map;
	}
	
	public Map<String, Object> deleteUserError(Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "000000");
		map.put("msg", "ok");
		map.put("body", 0);
		return map;
	}

}
