package sc.ad;


import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ActivitiApp {
    public static void main(String[] args)
    {
        SpringApplication.run(ActivitiApp.class, args);
    }

}