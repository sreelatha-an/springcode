package com.sree.springSecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sree.springSecurity.model.Users;
import com.sree.springSecurity.service.JwtService;
import com.sree.springSecurity.service.UsersService;



@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(10);
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtService jwtService;
	
	@PostMapping("register")
	public Users register(@RequestBody Users user)
	{		
		user.setPassword(bcrypt.encode(user.getPassword()));
		System.out.println("users in register=>"+user);
		return usersService.save(user);
	}
	
	@PostMapping("login")
	public String login(@RequestBody Users user) {
		
		Authentication auth = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword())
				);
		if(auth.isAuthenticated()) return jwtService.generateToken(user.getName());
		else return "Failure";
		
	}
	
	
}
