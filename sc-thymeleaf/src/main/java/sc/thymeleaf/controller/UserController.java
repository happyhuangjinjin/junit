package sc.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sc.thymeleaf.model.User;

@Controller
public class UserController {

	@RequestMapping("/user/list")
	public String userList2(Model model) throws Exception {
		model.addAttribute("hello", "Hello, thymeleaf!");
		List<User> list = new ArrayList<User>();
		User u1 = new User();
		u1.setId(1);
		u1.setName("huangjinjin");
		u1.setAge(30);
		u1.setPosition("cto");
		list.add(u1);
		
		User u2 = new User();
		u2.setId(2);
		u2.setName("huang ge");
		u2.setAge(32);
		u2.setPosition("cco");
		list.add(u2);
		
		model.addAttribute("list", list);
		return "/user/list";
	}

}
