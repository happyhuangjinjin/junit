package sc.zuul.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import sc.zuul.model.User;
import sc.zuul.service.UserService;

@RestController
public class UserController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;

	@GetMapping(value = "/feign/user/getUserTest")
	@ResponseBody
	public Map<String, Object> getUserTest() {
		Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("code", "000000");
        resp.put("msg", "ok");
		return resp;
	}
	
	@GetMapping(value = "/feign/user/getUser/{id}")
	@ResponseBody
	public Map<String, Object> getUser(@PathVariable Long id) {
		logger.info("getUser id = {}", id);
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
