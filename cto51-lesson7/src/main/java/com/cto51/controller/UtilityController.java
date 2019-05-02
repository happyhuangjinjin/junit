package com.cto51.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UtilityController {

	@RequestMapping("utility")
	public ModelAndView utility(ModelAndView mv){
		mv.setViewName("utility");
		mv.addObject("words", "this is test string length");
		mv.addObject("date", new Date());
		return mv;
	}
	
}
