package sc.redis.cache.controller;

import java.util.HashMap;
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

import sc.redis.cache.model.User;
import sc.redis.cache.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/user/getUser/{id}")
	@ResponseBody
	public Map<String, Object> getUser(@PathVariable Long id){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");
		result.put("body", userService.getUser(id));
		return result;
	}
	
	
	@RequestMapping(value="/user/listUser", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listUser(){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");
		result.put("body", userService.listUser());
		return result;
	}
	
	
	@PostMapping(value="/user/addUser")
	@ResponseBody
	public Map<String, Object> addUser(User user){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");
		result.put("body", userService.addUser(user));
		return result;
	}

	@PutMapping(value="/user/updateUser")
	@ResponseBody
	public Map<String, Object> updateUser(User user){
		System.out.println(user.getId());
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");
		result.put("body", userService.updateUser(user));
		return result;
	}
	
	

	@DeleteMapping(value="/user/deleteUser/{id}")
	@ResponseBody
	public Map<String, Object> deleteUser(@PathVariable Long id){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");
		result.put("body", userService.deleteUser(id));
		return result;
	}
}
