package sc.zipkin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sc.zipkin.model.UserDTO;
import sc.zipkin.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/user/getUser/{id}")
	public Map<String, Object> getUser(@PathVariable Integer id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");
		UserDTO user = userService.getUser(id);
		result.put("body", user);
		return result;
	}

	@RequestMapping("/user/listUser")
	public Map<String, Object> listUser() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");

		List<UserDTO> list = userService.listUser();
		result.put("body", list);
		return result;
	}

}
