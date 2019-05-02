package sc.freemarker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sc.freemarker.model.User;

@Controller
public class FreemarkerController {
	
	@RequestMapping("/getUser")
	public String getUser(Integer id, Model model){
		User u = new User();
		u.setId(1);
		u.setAge(13);
		u.setSex(1);
		u.setUserName("黄金");
		User l = new User();
		l.setId(1);
		l.setAge(23);
		l.setSex(0);
		l.setUserName("白银");
		List<User> friends = new ArrayList<User>();
		friends.add(l);
		u.setFriends(friends);
		model.addAttribute("user",u);
		return "getUser";
	}

}
