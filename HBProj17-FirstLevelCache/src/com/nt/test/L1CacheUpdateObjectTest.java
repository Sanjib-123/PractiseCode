package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class L1CacheUpdateObjectTest {

	public static void main(String[] args) {
		//get SessionFactory
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		//get Session
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(factory;ses){
			//load object
			Product p = ses.get(Product.class,9045); //collects in DB and puts in L1 cache
			if(p==null)
				System.out.println("Record not found");
			else
				tx = ses.beginTransaction();
			p.setPrice(5678.0); //modification 1
			p.setQty(56.0); //modification 2
			tx.commit(); //generate single update sql reflecting the both modification
				System.out.println("record updated");
			
		}//try
		catch(HibernateException he) {
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
				tx.rollback();
			he.printStackTrace();
		}

	}

}
