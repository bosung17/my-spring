package com.ssafy.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/rest4")
public class RestController4 {
	// http://localhost:8080/rest4/board/1
	// http://localhost:8080/rest4/board/2
	// http://localhost:8080/rest4/board/99
	
	@GetMapping("/board1/{id}")
	public String test1(@PathVariable int id) {
		return id + ":board";
	}
	@GetMapping("/board2/{id}")
	public String test2(@PathVariable("id") int num) {
		return num + ":board";
	}
}
