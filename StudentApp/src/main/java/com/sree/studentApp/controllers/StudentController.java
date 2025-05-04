package com.sree.studentApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sree.studentApp.model.Students;
import com.sree.studentApp.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/students")
	public List<Students> getStudents(){
		
		return studentService.getAllStudents();
		
	}
	@RequestMapping("/addStudents")
	public String addStudents(){
		
		return studentService.addStudents();
		
	}

}
