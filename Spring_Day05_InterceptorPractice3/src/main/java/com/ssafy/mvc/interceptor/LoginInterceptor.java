package com.ssafy.mvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		// 2nd try : preHandle 메소드 작성 중 session에서 loginUser 어떻게 가져오는지 헷갈림
		if (session.getAttribute("loginUser") == null) {
			return false;
		}
		return true;
	}
}
