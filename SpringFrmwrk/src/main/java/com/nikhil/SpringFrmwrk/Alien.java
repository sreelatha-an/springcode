package com.nikhil.SpringFrmwrk;

public class Alien {

	private String name;
	private Computer comp;
	
	public Alien() {
		System.out.println("inside constructor alien()..");
	}

	/*
	 * public Alien (String name, Computer comp) { this.name=name; this.comp=comp;
	 * System.out.println("got construction with 2 params..."); }
	 */
	public void coding() {
		System.out.println("inside Alien coding...");
		comp.getcode();		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("setting =>"+name);
	}
	public Computer getComp() {
		return comp;
	}
	public void setComp(Computer comp) {
		this.comp = comp;
	}
	
	
}
