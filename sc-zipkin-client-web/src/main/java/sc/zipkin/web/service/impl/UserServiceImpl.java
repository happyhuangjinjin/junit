package sc.zipkin.web.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sc.zipkin.web.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private RestTemplate restTemplate;
	
	@Override
	public Map<String, Object> getUser(Integer id) {
		return restTemplate.getForObject("http://127.0.0.1:9201/user/getUser/"+id, Map.class);
	}

	@Override
	public Map<String, Object> listUser() {
		return restTemplate.getForObject("http://127.0.0.1:9201/user/listUser/", Map.class);
	}

}
