package sc.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages="sc.provider.dao")
public class ProviderNodeTowApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderNodeTowApplication.class, args);
	}
	
}

