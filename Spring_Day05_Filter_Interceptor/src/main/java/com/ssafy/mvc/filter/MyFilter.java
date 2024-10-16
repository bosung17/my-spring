package com.ssafy.mvc.filter;

import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

//@Component // 모든 경로에 적용
//@Order(1) // 순서 지정 가능, 숫자는 정수 범위, 주로 양수 사용 : 숫자 낮을수록 먼저!
public class MyFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("서블릿 전1");
		chain.doFilter(request, response); // 없으면 서블릿으로 안 넘어감
		System.out.println("서블릿 후1");
	}

}
