package com.nt.utility;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		try {
		//Modern Bootstrapping code
		Configuration cfg = new Configuration();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		StandardServiceRegistry registry = builder.configure("com/nt/cfgs/hibernate.cfg.xml").build();
		//create SessionFactory
		factory = cfg.buildSessionFactory(registry);
	}
		catch(Exception se) {
			se.printStackTrace();
		}
	}
	public static SessionFactory getSessionFactory() {
		
			return factory;
	}
	public static Session getSession() {
		Session ses = null;
		if(factory!=null)
			ses = factory.openSession();
		
		return ses;
	}
	
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}

}
