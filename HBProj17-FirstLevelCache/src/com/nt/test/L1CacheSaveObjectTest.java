package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class L1CacheSaveObjectTest {

	public static void main(String[] args) {
		//get SessionFactory
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		//get Session
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(factory;ses){
			tx = ses.beginTransaction();
			//load object
			Product p = new Product();
			p.setPid(5677);
			p.setPname("sofa");
			p.setPrice(5455.0);
			p.setQty(55.77);
			p.setStatus("available");
			int idVal = (Integer) ses.save(p); //keeps p object in L1 cache
			System.out.println("Generated id value ::"+idVal);
			tx.commit(); //generates the insert SQL query by collecting p object from L1 cache
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}

	}

}
