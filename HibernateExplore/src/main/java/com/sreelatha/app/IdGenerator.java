package com.sreelatha.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sreelatha.model.Student;


public class IdGenerator {

	public static void main(String[] args) {
		//1. configuration object
		Configuration configuration = new Configuration();
		//2. configure hibernate.cfg.xml file to configuration object
		//configuration.configure("hibernate.cfg.xml");
		System.out.println("before config");
		configuration.configure();
		System.out.println("after config");
		//3. build session factory object
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		System.out.println("afdter sessionfactory");
		//4. get session object from session factory
		Session session = sessionFactory.openSession();
		System.out.println("before transaction begins");
		//5. begin transaction
		Transaction transaction = session.beginTransaction();
		System.out.println("after begin transaction");		
		Student stud = new Student();
		//stud.setSid(1);
		stud.setSname("uvaraj");
		stud.setScity("chittor");
		System.out.println("before persist");		
		//6. perform operation
		//session.save(stud);
	session.persist(stud);
//		session.merge(stud);
		System.out.println("afdter persist");
		//7. performing transaction operation
		transaction.commit();
		System.out.println("after commit");
		//8. close resources
		session.close();
		

	}

}
