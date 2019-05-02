package com.cto51.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cto51.dto.UserDto;

@RestController
public class SessionSharedController {
	
	@RequestMapping(value = "/setUserToSession")
	public UserDto setUserToSession (HttpServletRequest request){
		UserDto u = new UserDto();
		u.setUserName("聊点");
		u.setNickName("公众号");
		u.setPassword("137116546713");
		u.setSex("男");
	    request.getSession().setAttribute("user", u);
	    return u;
	}
	
	@RequestMapping(value = "/getUserFromSession")
	public Object getUserFromSession (HttpServletRequest request){
		UserDto u = (UserDto)request.getSession().getAttribute("user");
		u.setSessionId(request.getSession().getId());
	    return u;
	}

}
