package com.sree.springbootrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sree.springbootrest.model.Users;
import com.sree.springbootrest.service.UsersService;




@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(10);
	
	@PostMapping("register")
	public Users register(@RequestBody Users user)
	{		
		user.setPassword(bcrypt.encode(user.getPassword()));
		System.out.println("users in register=>"+user);
		return usersService.save(user);
	}
	
	
}
