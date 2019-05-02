package sc.zuul;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableZuulProxy
@SpringCloudApplication
@EnableFeignClients
public class ZuulFilterApplication {

    public static void main(String[] args){
        SpringApplication.run(ZuulFilterApplication.class, args);
    }

}
