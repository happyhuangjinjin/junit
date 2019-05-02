package com.cto51.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/sayHi2SpringBoot")
	public Map<String, String> sayHi2SpringBoot(){
		Map<String, String> resp = new HashMap<String, String>();
		resp.put("code", "000000");
		resp.put("msg", "hello world Spring Boot!");
		return resp;
	}
	
}
