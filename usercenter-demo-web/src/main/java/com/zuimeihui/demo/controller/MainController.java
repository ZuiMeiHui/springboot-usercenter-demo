package com.zuimeihui.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {
	
	@GetMapping({"/main.htm"})
	public String main() {
		return "success";
	}
}
