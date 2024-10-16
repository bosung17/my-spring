package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.User;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginForm";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		
		// 원래는 UserService를 통해서 로그인 하는 게 맞아!
		// id : ssafy, pw : 1234 통과 (유일한 회원)
		if (user.getId().equals("ssafy") && user.getPw().equals("1234")) {
			// 통과
			session.setAttribute("loginUser", user.getId());
			return "redirect:hello";
		}
		// 로그인 실패
		return "redirect:login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {

		// 1. 세션에서 유저 속성 지우기
//		session.removeAttribute("loginUser");
		
		// 2. 세션 자체 초기화
		session.invalidate();
		
		return "redirect:hello";
	}

}
