package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.MobilePhoneUser;
import com.nt.utility.HibernateUtil;

public class ObjectVersioningInsertTest {

	public static void main(String[] args) {
		//create SessionFactory,SessionObject
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(factory;ses){
			//begin Tx
			tx = ses.beginTransaction();
			//Prepare object
			MobilePhoneUser user = new MobilePhoneUser(9999888L,true,"odisha","dil dil");
			
			//save object
			ses.save(user);
			
			//commit tx
			tx.commit();
			System.out.println("Object is saved");
		}//try
		catch(HibernateException he) {
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
				tx.rollback();
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
