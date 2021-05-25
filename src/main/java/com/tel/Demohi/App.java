package com.tel.Demohi;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
      
    	
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);//class
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);//interface
        Session session = sf.openSession(); //interface// it will give you object of session
        session.beginTransaction();
        
       /* Random r= new Random();
        
        for(int i=1;i<=50;i++) {
        	 Student s1=new Student();
             s1.setRollno(i);
             s1.setName("Name"+i);
             s1.setMarks(r.nextInt(100));
             session.save(s1);
        }
       */
        Query q = session.createQuery("from Student");
        List<Student> student = q.list();
        
        
        for(Student s:student) {
        	System.out.println(s);
        }
        session.getTransaction().commit();
     
    }    
    
    }
    

