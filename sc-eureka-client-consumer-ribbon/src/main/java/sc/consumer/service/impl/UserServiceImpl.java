package sc.consumer.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sc.consumer.model.User;
import sc.consumer.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Map<String, Object> getUser(Long id) {
		return restTemplate.getForObject("http://sc-eureka-client-provider:8200/user/getUser/{1}", Map.class, id);
	}

	@Override
	public Map<String, Object> listUser() {
		return restTemplate.getForObject("http://sc-eureka-client-provider:8200/user/listUser", Map.class);
	}

	@Override
	public Map<String, Object> addUser(User user) {
		return restTemplate.postForObject("http://sc-eureka-client-provider:8200/user/addUser", user, Map.class);
	}

	@Override
	public Map<String, Object> updateUser(User user) {
		restTemplate.put("http://sc-eureka-client-provider:8200/user/updateUser",user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "000000");
		map.put("msg", "ok");
		return map;
	}

	@Override
	public Map<String, Object> deleteUser(Long id) {
		restTemplate.delete("http://sc-eureka-client-provider:8200/user/deleteUser/{id}", id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "000000");
		map.put("msg", "ok");
		return map;
	}

}
