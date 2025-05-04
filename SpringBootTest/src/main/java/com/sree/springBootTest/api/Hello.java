package com.sree.springBootTest.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	@GetMapping("Hello")
	public String sayHello() {
		return "Hello Test APP";
	}
}
