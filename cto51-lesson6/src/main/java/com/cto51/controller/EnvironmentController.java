package com.cto51.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvironmentController {

	@Autowired
	private Environment env;
	
	@RequestMapping("/getEnvironment")
	public List<Map<String, String>> getEnvironment() {
		List<Map<String, String>> allDBInfo = new ArrayList<>();
		
		Map<String, String> mysqlInfo = new HashMap<>();
		mysqlInfo.put("username", env.getProperty("jdbc.mysql.username"));
		mysqlInfo.put("password", env.getProperty("jdbc.mysql.password"));
		mysqlInfo.put("url", env.getProperty("jdbc.mysql.url"));
		
		Map<String, String> sqlserverInfo = new HashMap<>();
		sqlserverInfo.put("username", env.getProperty("jdbc.sqlserver.url"));
		sqlserverInfo.put("password", env.getProperty("jdbc.sqlserver.url"));
		sqlserverInfo.put("url", env.getProperty("jdbc.sqlserver.url"));
		
		Map<String, String> db2Info = new HashMap<>();
		db2Info.put("username", env.getProperty("jdbc.db2.url"));
		db2Info.put("password", env.getProperty("jdbc.db2.url"));
		db2Info.put("url", env.getProperty("jdbc.db2.url"));
		
		Map<String, String> oracleInfo = new HashMap<>();
		oracleInfo.put("username", env.getProperty("jdbc.oracle.url"));
		oracleInfo.put("password", env.getProperty("jdbc.oracle.url"));
		oracleInfo.put("url", env.getProperty("jdbc.oracle.url"));
		
		allDBInfo.add(mysqlInfo);
		allDBInfo.add(sqlserverInfo);
		allDBInfo.add(db2Info);
		allDBInfo.add(oracleInfo);
		return allDBInfo;
	}
	
}
