package com.nikhil.Car.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.nikhil.Car.Car;
import com.nikhil.Car.CarOwner;
import com.nikhil.Car.FordTaurus;
import com.nikhil.Car.TataPunch;

@Configuration
public class AppConfig {

//	@Bean(name= {"tata1","tata2"})
	/*
	 * @Bean
	 * 
	 * @Scope("prototype") public TataPunch tatapunchProtype() { return new
	 * TataPunch(); }
	 * 
	 * @Bean public TataPunch tatapunchsingleton() { return new TataPunch(); }
	 */
	// @Autowired annotation can be skipped as Spring performs automatic autowiring
	// by type.
	@Bean
	public CarOwner carowner( Car car) { // no need to mention (@Autowired Car car)
		// if not want (@Qualifier("tataPunch" Car car)
		// return new CarOwner();
		CarOwner cow = new CarOwner();
		// cow.setCar(tataPunch()); //this is tightly coupled to avoid it, can send in
		// constructor.
		cow.setCar(car);
		cow.setName("Nikhil");
		return cow;
	}

	@Bean
	public TataPunch tataPunch() { return new TataPunch();
	}
	 
	@Bean 
	@Primary
	public FordTaurus fordTaurus() { return new FordTaurus(); }
	 
}
