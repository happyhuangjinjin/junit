package com.um.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan(basePackages = { "com.um.sys.dao" })
@EnableRedisHttpSession
public class UmApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmApplication.class, args);

	}

}
