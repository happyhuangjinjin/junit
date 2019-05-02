package sc.zuul.consumer.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sc.zuul.consumer.model.User;

@RestController
public class UserController {

	@RequestMapping("/user/getUser/{id}")
	public Map<String, Object> getUser(@PathVariable Integer id) {
		System.out.println("id = " + id);
		Map<String, Object> resp = new HashMap<String, Object>();
		resp.put("code", "000000");
		resp.put("msg", "success");
		User u = new User();
		u.setId(1);
		u.setPosition("cto");
		u.setUsername("黄金");
		resp.put("body", u);
		return resp;
	}

	@RequestMapping("/user/listUser")
	public Map<String, Object> listUser() {
		Map<String, Object> resp = new HashMap<String, Object>();
		resp.put("code", "000000");
		resp.put("msg", "success");
		User u1 = new User();
		u1.setId(1);
		u1.setPosition("cto");
		u1.setUsername("黄金");

		User u2 = new User();
		u2.setId(2);
		u2.setPosition("cto");
		u2.setUsername("白银");

		List<User> list = new ArrayList<User>();
		list.add(u1);
		list.add(u2);
		resp.put("body", list);

		return resp;
	}

}
