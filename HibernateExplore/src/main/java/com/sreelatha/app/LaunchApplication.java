package com.sreelatha.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sreelatha.model.Student;


public class LaunchApplication {

	public static void main(String[] args) {
		//1. configuration object
		Configuration configuration = new Configuration();
		//2. configure hibernate.cfg.xml file to configuration object
		//configuration.configure("hibernate.cfg.xml");
		configuration.configure();
		//3. build session factory object
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//4. get session object from session factory
		Session session = sessionFactory.openSession();
		//5. begin transaction
		Transaction transaction = session.beginTransaction();
		
		Student stud = new Student();
		stud.setSid(1);
		stud.setSname("bammulu");
		stud.setScity("boduppal");
		
		//6. perform operation
		//session.save(stud);
		//session.persist(stud);
		session.merge(stud);
		
		//7. performing transaction operation
		transaction.commit();
		
		//8. close resources
		session.close();
		

	}

}
