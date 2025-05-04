package com.sree.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringFirstApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext context = 	SpringApplication.run(SpringFirstApplication.class, args);
	
	System.out.println("Hello world its my first Application");
	
	School school = context.getBean(School.class);
	school.show();
	}

}
