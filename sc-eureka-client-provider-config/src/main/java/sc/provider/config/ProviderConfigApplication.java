package sc.provider.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages="sc.provider.config.dao")
public class ProviderConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderConfigApplication.class, args);
	}
	
}
