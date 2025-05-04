package com.nikhil.SpringFrmwrk;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
 
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	//Alien alien = (Alien) context.getBean("alienobj");
          Alien alien =  context.getBean("alienobj",Alien.class);
        
        alien.coding();
		/*
		 * Laptop lap = (Laptop) context.getBean("lap"); lap.getcode();
		 * lap.age=20; System.out.println("lap age="+lap.age); Alien alien1 = (Alien)
		 * context.getBean("alienobj1"); alien1.coding();
		 * System.out.println("name1="+alien1.name); 
		 */
//		  Laptop lap1 =  context.getBean(Laptop.class);
//		  lap1.getcode();
		  
		  Desktop desk = context.getBean(Desktop.class);
		  desk.getcode();
		//  Computer com= context.getBean(Laptop.class);
		  Computer com = context.getBean(Computer.class);
		  com.getcode();
        
    }
}
