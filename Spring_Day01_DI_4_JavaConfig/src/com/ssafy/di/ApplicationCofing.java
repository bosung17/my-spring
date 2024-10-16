package com.ssafy.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationCofing {

	@Bean
	public Desktop desktop() {
		return new Desktop();
	}
	
	@Bean
	public Programmer programmer() {
		//생성자 주입
		Programmer p = new Programmer(desktop());
		return p;
	}
	
}
