package com.sree.springSecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sree.springSecurity.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{
	
	Users findByName(String name);
	

	
}
