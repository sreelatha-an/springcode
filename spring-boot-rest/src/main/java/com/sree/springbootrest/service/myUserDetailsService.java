package com.sree.springbootrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sree.springbootrest.model.UserPrincipal;
import com.sree.springbootrest.model.Users;
import com.sree.springbootrest.repo.UserRepo;


@Service
public class myUserDetailsService implements UserDetailsService{

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
