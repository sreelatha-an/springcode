package com.sree.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sree.springboot.model.Alien;
import com.sree.springboot.model.Laptop;
import com.sree.springboot.service.LaptopService;

@SpringBootApplication
public class SpringBootDemoApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
		Alien obj = context.getBean(Alien.class);
		System.out.println(obj.getAge());
		obj.code();
		
		Laptop lap = context.getBean(Laptop.class);
		LaptopService lapService = context.getBean(LaptopService.class);
		lapService.addToRegister(lap);
		
	}
}
