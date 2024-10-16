package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {
	
	@GetMapping("/hello") // /를 붙여도 되고 안 붙여도 되는 듯 함
	public String hello() {
		// 2nd try : HelloController에서 hello를 getmapping 하다가 model 만들고 넣는 거에서 막힘
		return "hello";
	}
	
}
