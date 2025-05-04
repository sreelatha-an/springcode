package com.sree.springSecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private int id;
	private String name;
	private String tech;
		
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", tech=" + tech + "]";
	}

	
}
