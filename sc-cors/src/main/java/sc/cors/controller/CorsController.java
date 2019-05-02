package sc.cors.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sc.cors.model.User;

@RestController
public class CorsController {

	@RequestMapping("/cors/getUserInfo")
	public Map<String, Object> getUserInfo() {
		Map<String, Object> resp = new HashMap<String, Object>();
		resp.put("code", "success");
		resp.put("message", "success");
		User user = new User();
		user.setId(1);
		user.setPosition("cto");
		user.setUserName("huang jinjin");
		resp.put("body", user);
		return resp;
	}
	
	@RequestMapping("/nocors/listUserInfo")
	public Map<String, Object> listUserInfo() {
		Map<String, Object> resp = new HashMap<String, Object>();
		resp.put("code", "success");
		resp.put("message", "success");
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setId(1);
		user.setPosition("cto");
		user.setUserName("huang jinjin");
		list.add(user);
		resp.put("body", list);
		return resp;
	}

}
