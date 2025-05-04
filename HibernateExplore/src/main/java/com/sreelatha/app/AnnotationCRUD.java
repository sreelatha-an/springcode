package com.sreelatha.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sreelatha.model.Student;

import org.hibernate.Transaction;

public class AnnotationCRUD {
	public static void main(String args[]) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean status = false;
		
		/* <mapping class="com.sreelatha.model.Student"/> in samplehibernate.cfg.xml 
		 above can be replaced by below.
		configuration.addAnnotatedClass(Student.class);  */
		
		sessionFactory = new Configuration().configure("samplehibernate.cfg.xml")
		.addAnnotatedClass(Student.class).buildSessionFactory();		
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Student stud = new Student();
			stud.setSid(5);
			stud.setSname("ammulu");
			stud.setScity("boduppal");			
			//session.save(stud);
			session.persist(stud);
			
			stud.setSname("mammu");
			//session.saveOrUpdate(stud);
			session.merge(stud);
			
			Student ss = session.get(Student.class, 5);
			
			//session.delete(stud);
			session.remove(stud);
			System.out.println(ss);

			/*
			 * Student stud1 = new Student(); stud1.setSid(1); stud1.setScity("bengaluru");
			 * stud1.setSname("sree"); session.persist(stud1);
			 */
			status=true;			
			
		}catch (HibernateException he) {System.out.println("he exception=="+he);}
		catch (Exception e ){ System.out.println("e=="+e);}
		finally {
			if(status==true) transaction.commit();
			else transaction.rollback();
			session.close();
			sessionFactory.close();
		}
		
		
	}
	
}
