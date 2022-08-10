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
			MobilePhoneUser user = new MobilePhoneUser(77122888L,true,"hyd","dil chae");
			user.setRegNo(55455L);
			
			//save object
			ses.save(user);
			
			//commit tx
			tx.commit();
			System.out.println("Object is saved at::"+user.getDoj()+"no. of modifications::"+user.getUpdationCount());
		}//try
		catch(HibernateException he) {
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
				tx.rollback();
			he.printStackTrace();
		}
		

	}

}
