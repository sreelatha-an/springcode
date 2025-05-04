package com.sree.springdatajpa.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sree.springdatajpa.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>
{
	// @query is not needed as JPA uses DSL-domain specific language
	//@Query ("select s from Student s where s.name=?1")
	public Student findByName(String string);
	
	@Query("select count(s) from Student s where s.rollNo=?1")
	public int checkifExists(Integer i);

	public List<Student> findByMarksGreaterThan(int marks);
	 
	
}