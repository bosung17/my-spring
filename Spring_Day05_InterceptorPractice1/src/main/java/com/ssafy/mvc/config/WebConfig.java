package com.ssafy.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.mvc.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	// 의존성 주입 (필드 주입, 생성자 주입, 설정자 주입)
	@Autowired
	private LoginInterceptor LoginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(LoginInterceptor).addPathPatterns("/regist");
	}
}
