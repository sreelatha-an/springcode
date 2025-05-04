package com.sree.springSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sree.springSecurity.model.Users;
import com.sree.springSecurity.repo.UserRepo;

@Service
public class UsersService {

	@Autowired
	private UserRepo repo;
	
	public Users save(Users user) {
		 return repo.save(user);
	}

}
