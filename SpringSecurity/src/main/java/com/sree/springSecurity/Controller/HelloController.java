package com.sree.springSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

	@GetMapping({"/hello","/"})
	public String hello(HttpServletRequest request) {
		return "Hello to Security Demo.. session="+request.getSession().getId();
	}
	
	@GetMapping("about")
	public String about(HttpServletRequest request) {
		return "<a href=\"sree.com\">sree</a> session="+request.getSession().getId();
	}
}
