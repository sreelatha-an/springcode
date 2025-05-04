package com.sree.springOAuth.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("welcome")
	public String welcome() {
		return "Welcome to Spring OAuth2 Demo...";
	}
	
}
