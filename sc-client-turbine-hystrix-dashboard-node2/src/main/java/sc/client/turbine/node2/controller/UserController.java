package sc.client.turbine.node2.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sc.client.turbine.node2.model.User;
import sc.client.turbine.node2.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/feign/user/getUser/{id}")
	@ResponseBody
	public Map<String, Object> getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}

	@RequestMapping(value = "/feign/user/listUser", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listUser() {
		return userService.listUser();
	}

	@PostMapping(value = "/feign/user/addUser")
	@ResponseBody
	public Map<String, Object> addUser(User user) {
		return userService.addUser(user);
	}

	@PutMapping(value = "/feign/user/updateUser")
	@ResponseBody
	public Map<String, Object> updateUser(User user) {
		return userService.updateUser(user);
	}

	@DeleteMapping(value = "/feign/user/deleteUser/{id}")
	@ResponseBody
	public Map<String, Object> deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}
}
