package com.cto51.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcMysqlController {

	@Value("${jdbc.mysql.username}")
	private String username;
	
	@Value("${jdbc.mysql.password}")
	private String password;
	
	@Value("${jdbc.mysql.url}")
	private String url;
	
	@RequestMapping("/getJdbcMysqlInfo")
	public Map<String, String> getJdbcMysqlInfo() {
		Map<String, String> resp = new HashMap<>();
		resp.put("username", username);
		resp.put("password", password);
		resp.put("url", url);
		return resp;
	}
}
