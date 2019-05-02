package com.cto51.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cto51.dto.UserDto;

@Controller
public class UserController {
	
	@RequestMapping("/user/getUserMap")
	public String getUserMap(Map<String, Object> map){
		UserDto dto = new UserDto();
		dto.setUserName("java乐园");
		dto.setAge(30);
		dto.setPosition("cto");
		map.put("user", dto);
		return "getUserMap";
	}

	@RequestMapping("/user/getUserModel")
	public String getUserInfoModel(Model model){
		UserDto dto = new UserDto();
		dto.setUserName("大黄哥");
		dto.setAge(30);
		dto.setPosition("cto");
		model.addAttribute("user", dto);
		return "getUserModel";
	}
	
	@RequestMapping("/user/getUserInfoModelAndView")
	public ModelAndView getUserModelAndView(){
		ModelAndView modelAndView = new ModelAndView();
		UserDto dto = new UserDto();
		dto.setUserName("大黄哥");
		dto.setAge(30);
		dto.setPosition("cto");
		modelAndView.addObject(dto);
		modelAndView.setViewName("getUserModelAndView");
		return modelAndView;
	}
}
