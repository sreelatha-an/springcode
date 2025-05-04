package com.telusko.model;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="studenttable")
public class Student 
{
	@Id
     private Integer sid;
     
     private String sName;
     
     private String scity;
	
	public Student()
	{
		System.out.println("Zero Param Constructor for Hibernate");
	}
	public Student(String sName,String scity)
	{
		System.out.println("2 Param Constructor for Hibernate");
		this.sName=sName;
		this.scity=scity;
	}

	public Student(String sName,Integer ii)
	{
		System.out.println("2 Param Constructor for Hibernate id..");
		this.sName=sName;
		this.sid=ii;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getScity() {
		return scity;
	}

	public void setScity(String scity) {
		this.scity = scity;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sName=" + sName + ", scity=" + scity + "]";
	}
	
	
}
