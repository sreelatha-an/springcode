package com.sreelatha.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sreelatha.model.Student;

import org.hibernate.Transaction;

public class LazyEagerLoading {
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
			
			
			Student ss = session.get(Student.class, 5);//if no data...
			//Student ss = session.load(Student.class, 4);
			//Student ss = session.getReference(Student.class, 5);
			
			
			
			if(ss!=null) {
			System.out.println("id=="+ss.getSid());
			System.out.println("name=="+ss.getSname());
			System.out.println("city=="+ss.getScity());
			} else {
				System.out.println("no record exists == ss is null");
			}
			

			status=true;			
			
		}catch (HibernateException he) {System.out.println("he exception=="+he);}
		catch (Exception e ){ System.out.println("e=="+e);
		//if no data exists for lazy loading - load/getReference below error 		
		//org.hibernate.ObjectNotFoundException: No row with the given identifier exists: 
		}
		finally {
			if(status==true) transaction.commit();
			else transaction.rollback();
			session.close();
			sessionFactory.close();
		}
		
		
	}
	
}
