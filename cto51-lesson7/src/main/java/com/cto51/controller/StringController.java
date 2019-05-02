package com.cto51.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StringController {

	@RequestMapping("string")
	public ModelAndView string(ModelAndView mv){
		mv.setViewName("string");
		mv.addObject("username", "公众号：java乐园");		
		return mv;
	}
	
}
