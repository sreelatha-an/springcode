package com.nikhil.SpringFrmwrk;

public class Desktop implements Computer{

	public Desktop() {
		System.out.println("destop constructor");
	}
	@Override
	 public void getcode() {
		 System.out.println("getcode in Desktop.....");
	 }
}
