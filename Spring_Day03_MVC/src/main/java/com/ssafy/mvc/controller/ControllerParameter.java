package com.ssafy.mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class ControllerParameter {

	@GetMapping("/test1")
	public String test1() {
		
		return "test1";
	}
	
	@GetMapping("/test2-1")
	public String test2_1(Model model) {
		model.addAttribute("msg", "model data");
		return "test2";
	}
	@GetMapping("/test2-2")
	public String test2_2(Map<String, Object> model) {
		model.put("msg", "map data");
		return "test2";
	}
	
	@GetMapping("/test3")
	public String test3(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		
//		HttpSession session = request.getSession();
		
		model.addAttribute("id", id);
		return "test3";
	}
	
	@GetMapping("/test3-1")
	public String test3_1(Model model, @RequestParam("myid")String id, @RequestParam(value="pw", defaultValue = "0000")String pw) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "test3";
	}
}
