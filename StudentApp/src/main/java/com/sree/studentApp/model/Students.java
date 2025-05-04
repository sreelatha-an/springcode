package com.sree.studentApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//@Data
@Entity
@Table(name="students")
public class Students {

	@Id
	@GeneratedValue( strategy=GenerationType.AUTO)
	//@GeneratedValue(generator = "stgen", strategy=GenerationType.AUTO)	
	//@SequenceGenerator(name="stgen", sequenceName = "stseq", initialValue = 100,allocationSize = 1 )
	private int id;	
	private String name;
	private int age;
	public Students(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Students() {	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
