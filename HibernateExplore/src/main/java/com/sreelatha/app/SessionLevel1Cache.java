package com.sreelatha.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sreelatha.model.Student;

import org.hibernate.Transaction;

public class SessionLevel1Cache {
	public static void main(String args[]) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Session session2 = null;
		boolean status = false;
		
		/* <mapping class="com.sreelatha.model.Student"/> in samplehibernate.cfg.xml 
		 above can be replaced by below.
		configuration.addAnnotatedClass(Student.class);  */
		
		sessionFactory = new Configuration().configure("samplehibernate.cfg.xml")
		.addAnnotatedClass(Student.class).buildSessionFactory();		
		
		try {
			session = sessionFactory.openSession();
			session2 = sessionFactory.openSession();
			
			Student ss = session.get(Student.class, 1);
			Student ss1 = session.get(Student.class, 1);//level1 cache will already have.
				
			System.out.println("ss=="+ss);
			System.out.println("ss1=="+ss1);
			
			Student ss2 = session2.get(Student.class, 1);//session scoped
			Student ss3 = session2.get(Student.class, 2);//level1 cache will already have.
				
			System.out.println("ss2=="+ss2);
			System.out.println("ss3=="+ss3);
						
		}catch (HibernateException he) {System.out.println("he exception=="+he);}
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
