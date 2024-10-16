package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView homeHandle1() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg", "Welcome to Spring MVC (GET)");
		
		mav.setViewName("home");
		
		return mav;
	}
	@RequestMapping(value="/home", method = RequestMethod.POST)
	public ModelAndView homeHandle2() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg", "Welcome to Spring MVC (POST)");
		
		mav.setViewName("home");
		
		return mav;
	}
	
}
