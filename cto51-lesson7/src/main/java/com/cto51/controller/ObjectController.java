package com.cto51.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ObjectController {

	@RequestMapping("object")
	public ModelAndView object(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		request.setAttribute("username", "java乐园");
		session.setAttribute("loginName", "管理员");
		mv.setViewName("object");
		return mv;
	}

}
