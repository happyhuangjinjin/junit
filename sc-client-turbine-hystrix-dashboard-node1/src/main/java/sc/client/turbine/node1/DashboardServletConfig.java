package sc.client.turbine.node1;

import javax.servlet.Servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@Configuration
public class DashboardServletConfig {
	
	@Bean
	public ServletRegistrationBean<Servlet> getDashboardServlet(){
		
		HystrixMetricsStreamServlet servlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean<Servlet> bean = new ServletRegistrationBean<Servlet>(servlet);
		bean.setLoadOnStartup(1);
		bean.addUrlMappings("/hystrix.stream");
		bean.setName("hystrix");
		return bean;
	}

}
