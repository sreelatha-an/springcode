package com.sreelatha.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity 
@Cacheable // Marks the entity as cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY) //Specifies the cache strategy
@Table (name="StudentTable")
public class EStudent {
	
	@Id
	@Column(name="SID")
	private int sid;
	
	@Column(name="SNAME")
	private String  sname;
	
	// @ Transient if it is transient wont even create column in table.
	@Column(name="SCITY")
	private String scity;

	public EStudent() {
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
