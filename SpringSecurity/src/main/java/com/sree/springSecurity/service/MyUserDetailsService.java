package com.sree.springSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sree.springSecurity.model.UserPrincipal;
import com.sree.springSecurity.model.Users;
import com.sree.springSecurity.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = userRepo.findByName(username);
		if(users==null) {
			System.out.println("User not found --404");
			throw new UsernameNotFoundException("User not found --404");
		}
			
		return new UserPrincipal(users);
	}

}
