package com.nt.clustered;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class ClusteredSaveObjectTest2 {

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
			p.setPid(5670);
			p.setPname("chair");
			p.setPrice(5455.0);
			p.setQty(55.77);
			p.setStatus("available");
			int idVal = (Integer) ses.save(p); //keeps p object in L1 cache
			System.out.println("Generated id value ::"+idVal);
			Thread.sleep(30000);
			tx.commit(); //generates the insert SQL query by collecting p object from L1 cache
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
