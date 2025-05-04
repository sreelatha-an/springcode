package com.nikhil.Car;

import org.springframework.beans.factory.annotation.Autowired;

public class CarOwner {
	
	public String name;
	
	private Car car;
	
	public CarOwner() {	}
	
	public void driveMyCar() {
		System.out.println("driveMyCar() safely....");
		System.out.println("myname is "+name);
		car.drivecar();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	//@Autowired //setterbased autowiring
	public void setCar(Car car) {
		this.car = car;
	}
	

}
