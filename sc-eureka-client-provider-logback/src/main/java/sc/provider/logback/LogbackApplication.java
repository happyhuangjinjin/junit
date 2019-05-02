package sc.provider.logback;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
//@MapperScan(basePackages="sc.provider.logback.dao")
public class LogbackApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(LogbackApplication.class, args);
	}
	
}
