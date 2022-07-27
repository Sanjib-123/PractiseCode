package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class SaveOrUpdateObjectTest {

	public static void main(String[] args) {
		//get session factory
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//get session object
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(factory;ses){
			//begin tx
			tx = ses.beginTransaction();
			//Prepare object
			Product prod = new Product();
			prod.setPid(9050);
			prod.setPname("recliner");
			prod.setPrice(180000.0);
			prod.setQty(1.0);
			prod.setStatus("available");
			
			//save or update object
			ses.saveOrUpdate(prod);
			tx.commit();
			System.out.println("Object is saved or updated");
		}//try
		catch(HibernateException he) {
			if(tx!=null && tx.getStatus()!= null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Problem is saving or updating object");
			}//if
		}
		

	}

}
