package com.cto51.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.mysql.jdbc.Driver;

@Configuration
public class JdbcConfig {
	
	@Bean
	@ConfigurationProperties(prefix="jdbc.mysql")
	public DriverManagerDataSource getDS(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		return ds;
	}
	
//	@Bean
//	@ConfigurationProperties(prefix="jdbc.mysql")
//	public SimpleDriverDataSource getDS() throws Exception{
//		SimpleDriverDataSource ds = new SimpleDriverDataSource();
//		ds.setDriver(new Driver());
//		return ds;
//	}

	@Bean
	@Autowired
	public JdbcTemplate getJdbcTemplate(DataSource ds){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(ds);
		return jdbcTemplate;
	}
	
}
