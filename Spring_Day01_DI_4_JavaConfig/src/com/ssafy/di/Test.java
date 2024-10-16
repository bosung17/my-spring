package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationCofing2.class);
		
		Programmer p = context.getBean("p", Programmer.class);
		
		p.coding();
		
		
	}
}
