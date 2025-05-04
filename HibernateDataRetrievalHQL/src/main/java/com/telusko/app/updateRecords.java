package com.telusko.app;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.telusko.model.Student;

public class updateRecords 
{

	public static void main(String[] args) 
	{
			SessionFactory sessionFactory = new Configuration().configure()
					.addAnnotatedClass(Student.class).buildSessionFactory();
			Session session1 =null;
			Transaction transaction=null;
			boolean flag=false;
			int count=0;
		
			try
			{
				session1=sessionFactory.openSession();
				//SELECT * FROM studenttable where scity=?;
				//Query<Student> query = session1.createQuery("FROM Student WHERE scity=:city", Student.class);
				//Query<String> query = session1.createQuery("SELECT sName FROM Student WHERE scity IN(:city1, :city2)", String.class);
				transaction=session1.beginTransaction();
				 
				MutationQuery query = session1.createMutationQuery("UPDATE Student set scity=:city1 WHERE sName=:name1 ");
				query.setParameter("city1", "Bengaluru");
				query.setParameter("name1", "lalitha");
				 count = query.executeUpdate();
				
System.out.println("no of rows updated=="+count);				
flag=true;

			      
			}
			catch(HibernateException e)
			{
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(flag==true)
				{
					transaction.commit();
					System.out.println("No of rows updated "+ count);
					
				}
				else
				{
					transaction.rollback();
					System.out.println("No of rows updated "+ count);
				
				}
				
				session1.close();
				sessionFactory.close();
			}
		
		


	}

}
