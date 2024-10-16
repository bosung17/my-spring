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

//	@PostMapping("/login")
//	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw) {
//		
//		System.out.println(id);
//		System.out.println(pw);
//		
//		return "hello";
////		return "redirect:hello";
//	}

	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		System.out.println(user);

		session.setAttribute("loginUser", user.getId());

		return "redirect:hello";
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
