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
	
	// 5th : UserController 내의 POST 요청 login과 GET 요청 logout을 처리 할 메소드들을 완성시키지 못함
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		
		session.setAttribute("loginUser", user.getId());
		
		return "redirect:hello";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:hello";
	}
	
}
