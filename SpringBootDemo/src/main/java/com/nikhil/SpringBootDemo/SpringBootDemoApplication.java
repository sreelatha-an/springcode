package com.nikhil.SpringBootDemo;

import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
		Alien obj = context.getBean(Alien.class);
		System.out.println(obj.getAge());
		obj.code();
	}
}
