package com.sree.studentApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sree.studentApp.model.Students;

@Component
public interface StudentRepo extends JpaRepository<Students, Integer>{
	

}
