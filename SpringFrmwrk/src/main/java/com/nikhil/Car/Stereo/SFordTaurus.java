package com.nikhil.Car.Stereo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sft")
@Scope("prototype")
public class SFordTaurus implements SCar {

	@Override
	public void drivecar() {
		System.out.println("I am driving FordTaurus....");
		
	}

	public SFordTaurus() {
		System.out.println("FordTaurus() is created.....");
	}
	

}
