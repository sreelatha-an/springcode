package com.sree.springbootrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sree.springbootrest.model.Users;
import com.sree.springbootrest.repo.UserRepo;


@Service
public class UsersService {

	@Autowired
	private UserRepo repo;
	
	public Users save(Users user) {
		 return repo.save(user);
	}

}
