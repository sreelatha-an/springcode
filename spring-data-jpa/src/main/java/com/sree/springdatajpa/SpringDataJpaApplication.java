package com.sree.springdatajpa;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sree.springdatajpa.Repo.StudentRepo;
import com.sree.springdatajpa.model.Student;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		StudentRepo repo = context.getBean(StudentRepo.class);
		
		
		/*
		 * Student s1 = context.getBean(Student.class); s1.setRollNo(4);
		 * s1.setName("mammu"); s1.setMarks(300);
		 * 
		 * Student s2 = context.getBean(Student.class); s2.setRollNo(2);
		 * s2.setName("uv"); s2.setMarks(450);
		 * 
		 * repo.save(s1); repo.save(s2);
		 */
		 
		/*
		 * List<Student>students = repo.findAll();
		 * System.out.println("findAll students=="+students.toString());
		 * //students.forEach(s->System.out.println(s));
		 * 
		 * Optional<Student> opSt = repo.findById(5); System.out.println("opSt=="+
		 * opSt.orElse(new Student()));
		 * 
		 * System.out.println("-------");
		 * 
		 */		//repo.deleteById(2);
		
		//Student st = repo.findByName("sree");
		//System.out.println("findByName=="+st);
		int r=4;
		int c = repo.checkifExists(r);
		System.out.println(c+ " rows exists with rollno="+r);
		
		List studmrks = repo.findByMarksGreaterThan(300);
		System.out.println("student marks greater than 300== "+studmrks.toString());
		
		
	}

}
