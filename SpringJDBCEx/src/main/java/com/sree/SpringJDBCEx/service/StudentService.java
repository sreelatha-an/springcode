package com.sree.SpringJDBCEx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sree.SpringJDBCEx.model.Student;
import com.sree.SpringJDBCEx.repo.StudentRepo;

@Service
public class StudentService {
	
	private StudentRepo repo;
	
	@Autowired
	public void setRepo(StudentRepo repo) {
		this.repo = repo;
	}
	
	public StudentRepo getRepo() {
		return repo;
	}

	public void addStudent(Student stud) {
		repo.save(stud);
	}

	public List<Student> getAllStudents(){
		return repo.findAll();
	}
	
	  public Student getAstudent(int rn){
	  
	  return repo.getAStudent(rn);
	  
	  }
	  public List<Student> getAllStudentsProc(){
		  return repo.getAllStudentsProc();
	  }
	 
}
