package com.sreelatha.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sreelatha.model.Student;

import org.hibernate.Transaction;

public class CRUDApps {
	public static void main(String args[]) {
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean status = false;
		configuration = new Configuration();
		configuration.configure();
		sessionFactory =configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		
		try {
			transaction = session.beginTransaction();
			
			Student stud = new Student();
			stud.setSid(5);
			stud.setSname("latha");
			stud.setScity("waris");			
			//session.save(stud);
			session.persist(stud);
			
			stud.setSname("nikhil");
			//session.saveOrUpdate(stud);
			session.merge(stud);
			//session.delete(stud);
			session.remove(stud);
			
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
