package com.redis.session.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.redis.session.model.User;

@RestController
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * 把用户放入session
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/user/login")
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request) {
		// 取出session中的userName
		Object loginUser = request.getSession().getAttribute("loginUser");
		if (loginUser == null) {
			logger.info("不存在session，设置user");
			User u = new User();
			u.setAge(23);
			u.setId(1L);
			u.setPosition("总裁");
			u.setUserName("huangjinjin");
			request.getSession().setAttribute("loginUser", u);
		} else {
			logger.info("存在session，user=" +  JSON.toJSONString(loginUser));
		}
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				logger.info(cookie.getName() + " : " + cookie.getValue());
			}
		}
		Map<String, Object> resp = new HashMap<String, Object>();
		resp.put("code", "000000");
		resp.put("msg", "交易成功");
		return resp;
	}

	/**
	 * 获取session的用户
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/user/getUser")
	@ResponseBody
	public Map<String, Object> getUser(HttpServletRequest request) {
		Map<String, Object> resp = new HashMap<String, Object>();
		resp.put("code", "000000");
		resp.put("msg", "交易成功");
		resp.put("body", request.getSession().getAttribute("loginUser"));
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				logger.info(cookie.getName() + " : " + cookie.getValue());
			}
		}
		return resp;
	}
	
}
