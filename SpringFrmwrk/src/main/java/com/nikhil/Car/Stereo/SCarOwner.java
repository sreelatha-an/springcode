package com.nikhil.Car.Stereo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //Automatically registers the class as a bean when component scanning is enabled
public class SCarOwner {
	@Value("Sreelatha")
	public String name;
	
	//@Autowired
	//@Qualifier("sft") //qualifier with name can use @primary on class. this is field level injection 
	private SCar car;
	
	//@Autowired  	// construction based dependency injection
	public SCarOwner(@Qualifier("STataPunch") SCar car) { this.car=car;	} //@Qualifier("sft") to use as component name if not primary
	// if no name to Component then give the same class name as it is
	
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

	public SCar getCar() {
		return car;
	}

	@Autowired //setter based dependency injection
	public void setCar(@Qualifier("sft") SCar car) {
		this.car = car;
	}
	

}
