package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
	
	private final UserService userservice;

//	@Autowired
	public UserController(UserService userservice) {
		this.userservice = userservice;
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginform";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		User tmp = userservice.login(user.getId(), user.getPassword());
		
		if (tmp == null) {
			return "redirect:login";
		}
		
		session.setAttribute("loginUser", tmp.getName());
		return "redirect:list";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:list";
	}
	
	@GetMapping("users")
	public String userList(Model model) {
		model.addAttribute("userList", userservice.getUserList());
		return "/user/adminPage";		
	}
}
