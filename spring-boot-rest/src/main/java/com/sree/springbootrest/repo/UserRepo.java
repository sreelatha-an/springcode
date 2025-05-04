package com.sree.springbootrest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sree.springbootrest.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{
	
	Users findByName(String name);
	

	
}
