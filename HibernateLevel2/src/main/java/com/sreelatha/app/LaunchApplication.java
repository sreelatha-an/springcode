package com.sreelatha.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sreelatha.model.EStudent;


public class LaunchApplication {

	public static void main(String[] args) {
	
		Configuration config = new Configuration();
		//1. configure hibernate.cfg.xml file to configuration object
		//config.configure("ecachehibernate.cfg.xml")
		
		//2. Load hibernate.properties automatically only jdbc related we can give in properties 
		//but not the mapping details of the class we cannot give in properties.. 
		// this not needed as config.configure("hibernate.properties");
		
		//3. Setting Hibernate properties directly using setProperty method
/*		config.setProperty("hibernate.connection.driver_class",
		"com.mysql.cj.jdbc.Driver");
		config.setProperty("hibernate.connection.url",
		"jdbc:mysql://localhost:3306/learndb");
		config.setProperty("hibernate.connection.password", "mysql4$Java");
		config.setProperty("hibernate.connection.username", "root");
		config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		config.setProperty("hibernate.hbm2ddl.auto", "update");
		config.setProperty("hibernate.show_sql", "true");
		config.setProperty("hibernate.format_sql", "true");

		*/
		
		System.out.println("after loading properties...");
		//3. build session factory object
		SessionFactory sessionFactory = config.addAnnotatedClass(EStudent.class).buildSessionFactory();
		//4. get session object from session factory
		Session session = sessionFactory.openSession();
		//5. begin transaction
		Transaction transaction = session.beginTransaction();
		
	
		EStudent stud = new EStudent();
		stud.setSid(1);
		stud.setSname("nikh");
		stud.setScity("waris");
		
		//6. perform operation
		//session.save(stud);
		//session.persist(stud);
		session.merge(stud);
		
		//7. performing transaction operation
		transaction.commit();
		
		//8. close resources
		session.close();
		
System.out.println("done....");
	}

}
