package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class DeleteObjectTest {

	public static void main(String[] args) {
		//get SessionFactory object
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(factory;ses){
			//load object 
			Product prod = ses.get(Product.class, 9045);
			if(prod==null)
				System.out.println("Record not found to delete");
			else {
//			//prepare object
//			Product p = new Product();
//			p.setPid(9045);
			//begin transaction
			tx = ses.beginTransaction();
			ses.remove(prod); //delete method is deprecated from v6
			tx.commit();
			System.out.println("Object deleted");
			}
		}//try
		catch(HibernateException he) {
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
				tx.rollback();
			System.out.println("Object is not deleted");
		}

	}

}
