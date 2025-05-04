package com.nikhil.Car.Stereo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nikhil.Car.config.SAppConfig;

public class StereotypeAnnotations {

	private static SCar car;

	public static void main(String[] args) {
				
		ApplicationContext context = new AnnotationConfigApplicationContext(SAppConfig.class);
		SCarOwner carowner1 = context.getBean(SCarOwner.class);
		
		carowner1.driveMyCar();
		/*
		 * // for singleton or prototype TataPunch tata1 =
		 * context.getBean("tatapunchsingleton", TataPunch.class); tata1.drivecar();
		 * TataPunch tata2 = context.getBean("tatapunchsingleton", TataPunch.class);
		 * tata2.drivecar();
		 * 
		 * TataPunch tatap1 = context.getBean("tatapunchProtype", TataPunch.class);
		 * tatap1.drivecar(); TataPunch tatap2 = context.getBean("tatapunchProtype",
		 * TataPunch.class); tatap2.drivecar();
		 */
		/* ....................... .................. ......................................*/
		
		
	}

}
