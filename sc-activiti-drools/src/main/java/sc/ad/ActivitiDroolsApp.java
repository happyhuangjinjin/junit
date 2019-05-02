package sc.ad;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
 
@SpringBootApplication
@ImportResource("activiti.cfg.xml")
public class ActivitiDroolsApp {
    public static void main(String[] args)
    {
        SpringApplication.run(ActivitiDroolsApp.class, args);
    }

}