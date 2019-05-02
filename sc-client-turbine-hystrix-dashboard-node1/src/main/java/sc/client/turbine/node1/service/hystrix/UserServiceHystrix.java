package sc.client.turbine.node1.service.hystrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import sc.client.turbine.node1.model.User;
import sc.client.turbine.node1.service.UserService;

@Component
public class UserServiceHystrix  implements UserService{

	@Override
	public Map<String, Object> getUser(Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");
		User u = new User();
		u.setId(-1L);
		u.setUserName("failBackNameNode1");
		result.put("body", u);
		return result;
	}

	@Override
	public Map<String, Object> listUser() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");
		List<User> list = new ArrayList<User>();
		User u = new User();
		u.setId(-1L);
		u.setUserName("failBackNameNode1");
		list.add(u);
		result.put("body", list);
		return result;
	}

	@Override
	public Map<String, Object> addUser(User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");
		result.put("body", 0);
		return result;
	}

	@Override
	public Map<String, Object> updateUser(User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");
		result.put("body", 0);
		return result;
	}

	@Override
	public Map<String, Object> deleteUser(Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");
		result.put("body", 0);
		return result;
	}

}
