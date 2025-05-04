package com.nikhil.SpringFrmwrk;

public class Laptop implements Computer {
	
	  
	public Laptop() { System.out.println("constructor Laptop()..."); }
	 
	@Override
	public void getcode() {
		System.out.println("get code in laptop...");
	}
}