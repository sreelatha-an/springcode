package com.sree.springSecurity.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sree.springSecurity.entity.Student;
import com.sree.springSecurity.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

	@Autowired
	private StudentService  studentService;
	
	@GetMapping("csrf-token")
	public CsrfToken getCSRFToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@GetMapping("students")
	public List<Student> getStudents(){
		return studentService.getStudents();
	}
	
	
	  @PostMapping("/students") 
	  public void addStudents(@RequestBody Student
	  student) {
		  studentService.addStudent(student);
	  
	  }
	 
	
	
}
