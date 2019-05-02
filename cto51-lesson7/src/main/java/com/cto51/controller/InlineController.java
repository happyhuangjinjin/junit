package com.cto51.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InlineController {

	@RequestMapping("inline")
	public ModelAndView inline(ModelAndView mv){
		mv.setViewName("inline");
		mv.addObject("username", "java乐园");		
		return mv;
	}
	
}
