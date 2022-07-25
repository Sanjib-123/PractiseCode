package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	
	static {
		try {
		//configure object
		Configuration cfg = new Configuration();
		cfg.configure("/com/nt/cnfgs/hibernate.cfg.xml");
		//build sessionFactory
		factory = cfg.buildSessionFactory();
		}
	
	catch(HibernateException he) {
		he.printStackTrace();
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//static
	
	public static SessionFactory getSessionFactory() {
		if(factory!=null)
			
		return factory;
		else 
			throw new IllegalArgumentException("-----------");
	}
	
	public static Session getSession() {
		Session ses = null;
		if(factory!=null)
			ses = factory.openSession();
		
		return ses;
	}
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
	

}
