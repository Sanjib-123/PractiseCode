package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest1 {

	public static void main(String[] args) {
		//get session object
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//get session object
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
	
		
		try(factory;ses){
			//prepare entity object
			Product p = new Product();
			p.setPid(9011);
			p.setPname("FaceCream");
			p.setPrice(900.0);
			p.setQty(4.0);
			p.setStatus("available");
			
			//begin Tx
			tx = ses.beginTransaction();
			ses.update(p);
			tx.commit();
			System.out.println("Object Updated");
		
			
		}//try
		catch(HibernateException he) {
			if(tx!=null && tx.getStatus()==TransactionStatus.ACTIVE && tx.getRollbackOnly()==true)
				tx.rollback();
			System.out.println("Object is not updated");
			he.printStackTrace();
		}
		catch(Exception e) {
			if(tx!=null && tx.getStatus()==TransactionStatus.ACTIVE && tx.getRollbackOnly()==true)
				tx.rollback();
			System.out.println("Object is not updated");
			e.printStackTrace();
		}//catch
		

	}//main

}//class
