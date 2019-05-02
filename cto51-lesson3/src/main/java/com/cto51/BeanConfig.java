package com.cto51;

import java.util.EventListener;

import javax.servlet.Filter;
import javax.servlet.Servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cto51.spring.FilterSpring;
import com.cto51.spring.ListenerSpring;
import com.cto51.spring.ServletSpring;

@Configuration
public class BeanConfig {

	@Bean
	public ServletRegistrationBean<Servlet> getFervletSpring() {
		ServletRegistrationBean<Servlet> servletSpring = new ServletRegistrationBean<Servlet>(new ServletSpring());
		servletSpring.addUrlMappings("/servletSpring"); // 访问路径映射
		return servletSpring;
	}
	
	@Bean
	public FilterRegistrationBean<Filter> getFilterSpring() {
		FilterRegistrationBean<Filter> filterSpring = new FilterRegistrationBean<Filter>(new FilterSpring());
		filterSpring.addUrlPatterns("/servletSpring"); // 拦截路径映射
		filterSpring.setOrder(2);
		return filterSpring;
	}
	
	@Bean
	public ServletListenerRegistrationBean<EventListener> getListenerSpring() {
		ServletListenerRegistrationBean<EventListener> listenerSpring = new ServletListenerRegistrationBean<EventListener>(new ListenerSpring());
		return listenerSpring;
	}
}
