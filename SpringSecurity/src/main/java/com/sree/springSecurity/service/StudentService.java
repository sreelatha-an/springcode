package com.sree.springSecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sree.springSecurity.entity.Student;

@Service
public class StudentService {

	private static List<Student> students = new ArrayList<Student>(List.of(
			new Student(1,"sree","java"),
			new Student(2,"nikhil","python")			
			));
	
	public List<Student> getStudents(){
		return students;
		}
	
	public boolean addStudent(Student student) {
		return students.add(student);
		}
	
	
}
