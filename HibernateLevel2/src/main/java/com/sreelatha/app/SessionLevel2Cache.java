package com.sreelatha.app;
import org.hibernate.cfg.Configuration;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import com.sreelatha.model.EStudent;



public class SessionLevel2Cache {
	public static void main(String args[]) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Session session2 = null;
		boolean status = false;
		
		/* <mapping class="com.sreelatha.model.Student"/> in samplehibernate.cfg.xml 
		 above can be replaced by below.
		configuration.addAnnotatedClass(Student.class);  */
		
		sessionFactory = new Configuration().configure("ecachehibernate.cfg.xml")
		.addAnnotatedClass(EStudent.class).buildSessionFactory();		
		//
		
		try {
			session = sessionFactory.openSession();
			session2 = sessionFactory.openSession();
			
			//level2 cache will already have.
			// for each session it creates an object from resultset in cache and gives.
			//so 2 constructors => 2 objects created and given back , 1 for each session.
			EStudent ss = session.get(EStudent.class, 1);
			EStudent ss1 = session.get(EStudent.class, 1);
			
				
			System.out.println("ss=="+ss);
			System.out.println("ss1=="+ss1);
			
			EStudent ss2 = session2.get(EStudent.class, 1);//session scoped
			EStudent ss3 = session2.get(EStudent.class, 1);//level1 cache will already have.
				
			System.out.println("ss2=="+ss2);
			System.out.println("ss3=="+ss3);
						
		}
		catch (Exception e ){ System.out.println("e=="+e);
		//if no data exists for lazy loading - load/getReference below error 		
		//org.hibernate.ObjectNotFoundException: No row with the given identifier exists: 
		}
		finally {
			session.close();
			session2.close();
			sessionFactory.close();
		}
		
		
	}
	
}
