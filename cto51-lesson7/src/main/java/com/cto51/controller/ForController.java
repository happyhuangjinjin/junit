package com.cto51.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

	@Controller
	public class ForController {

		@RequestMapping("for")
		public ModelAndView forExample(ModelAndView mv){
			mv.setViewName("for");
			List<Map<String, Object>> users = new ArrayList<>();
			Map<String, Object> user = new HashMap<>();
			user.put("id", 1);
			user.put("username", "黄哥");
			user.put("salary", 1000000.00);
			users.add(user);
			
			user = new HashMap<>();
			user.put("id", 2);
			user.put("username", "java乐园");
			user.put("salary", 2000000.00);
			users.add(user);
			
			user = new HashMap<>();
			user.put("id", 3);
			user.put("username", "架构师知音");
			user.put("salary", 3000000.00);
			users.add(user);
			mv.addObject("users", users);		
			return mv;
		}
		
	}