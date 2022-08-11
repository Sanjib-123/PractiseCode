package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class L1CacheSelectTest {

	public static void main(String[] args) {
		//get SessionFactory
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		//get Session
		Session ses = HibernateUtil.getSession();
		try(factory;ses){
			//load object
			Product p = ses.get(Product.class,9045); //collects in DB and puts in L1 cache
			System.out.println(p);
			System.out.println("-----------------");
			Product p1 = ses.get(Product.class,9045); //collects from l1 cache and gives to app
			System.out.println(p1);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}

	}

}
