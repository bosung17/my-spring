package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.dto.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@GetMapping("/login")
	public String login() {
		return "user/loginForm";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		// 1st try : if문 안에 user.getId(), user.getPw()를 통해 id, pw를 가져온 뒤 비교하여 세션에 저장할지 무한 로그인이 되게 만들지 결정하는 곳에서 막힘
		if (user.getId().equals("ssafy") && user.getPw().equals("1234")) {
			session.setAttribute("loginUser", user.getId());
			return "redirect:hello";
		}
		return "redirect:login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:hello";
	}

}
