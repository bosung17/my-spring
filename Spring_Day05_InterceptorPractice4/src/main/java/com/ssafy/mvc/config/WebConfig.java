package com.ssafy.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.mvc.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private LoginInterceptor li;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(li).addPathPatterns("/regist");
	}
}