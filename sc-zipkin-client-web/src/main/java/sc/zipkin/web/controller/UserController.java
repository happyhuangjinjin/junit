package sc.zipkin.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sc.zipkin.web.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/user/getUser/{id}")
	public Map<String, Object> getUser(@PathVariable Integer id) {
		return userService.getUser(id);
	}

	@RequestMapping("/user/listUser")
	public Map<String, Object> listUser() {
		return userService.listUser();
	}

}
