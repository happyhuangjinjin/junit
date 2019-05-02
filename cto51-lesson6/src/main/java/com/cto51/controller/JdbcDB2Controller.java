package com.cto51.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cto51.config.DB2Config;

@RestController
public class JdbcDB2Controller {

	@Autowired
	private DB2Config config;
	
	@RequestMapping("/getJdbcDB2Info")
	public Map<String, String> getJdbcDB2Info() {
		Map<String, String> resp = new HashMap<>();
		resp.put("username", config.getUsername());
		resp.put("password", config.getPassword());
		resp.put("url", config.getUrl());
		return resp;
	}
}
