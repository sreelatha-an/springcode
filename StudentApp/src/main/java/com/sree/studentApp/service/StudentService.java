package com.sree.studentApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sree.studentApp.model.Students;
import com.sree.studentApp.repo.StudentRepo;

@Component
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	public List<Students> getAllStudents(){
		
		return studentRepo.findAll();				
		
	}

	public String addStudents() {
		Students s = new Students();
		s.setName("Raj");
		s.setAge(45);
		studentRepo.save(s);
		return "done";
	}
}
