package com.cto51.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConditionController {

	@RequestMapping("condition")
	public ModelAndView ifCondition(String flag){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("condition");
		mv.addObject("flag", flag);		
		return mv;
	}
	
}
