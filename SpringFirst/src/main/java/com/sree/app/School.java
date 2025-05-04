package com.sree.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class School {
	
	@Autowired
	SClass sclass;
	public void School() {
		System.out.println("inside School() construtor");
	}

	 public void show() {
		 System.out.println("welcome to School");
		 sclass.welcome();
		 // java.lang.NullPointerException: Cannot invoke "com.sree.app.SClass.welcome()" because "this.sclass" is null
		 // so need to do dependency injection by autowiring... 
	 }
}
