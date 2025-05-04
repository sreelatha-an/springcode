package com.sreelatha.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity 
@Table (name="StudentTable")
public class Student {
	
	@Id
	@Column(name="SID")
	@GeneratedValue(generator = "seq_gen" ,strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_gen", sequenceName = "my_seq", initialValue = 100,allocationSize = 2 )
	private int sid;
	
	@Column(name="SNAME")
	private String  sname;
	
	// @ Transient if it is transient wont even create column in table.
	@Column(name="SCITY")
	private String scity;

	public Student() {
		System.out.println("student() constructor ...");
	}
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getScity() {
		return scity;
	}

	public void setScity(String scity) {
		this.scity = scity;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", scity=" + scity + "]";
	}
	
	
}
