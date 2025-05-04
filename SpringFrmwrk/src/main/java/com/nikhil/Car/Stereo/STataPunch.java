package com.nikhil.Car.Stereo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class STataPunch implements SCar{

	@Override
	public void drivecar() {
		System.out.println("I am driving TataPunch..");
		
	}

	public STataPunch() {
		System.out.println("TataPunch() is created...");
	}
	
	

}
