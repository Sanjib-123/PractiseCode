package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.MobilePhoneUser;
import com.nt.utility.HibernateUtil;

public class ObjectVersioningUpdateTest {
	public static void main(String[] args) {
	//create SessionFactory,SessionObject
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session ses = HibernateUtil.getSession();
			Transaction tx = null;
			try(factory;ses){
				//begin Tx
				tx = ses.beginTransaction();
				//Prepare object
				MobilePhoneUser user = ses.get(MobilePhoneUser.class, 1);
				if(user!=null) {
					//update object
					user.setCircle("ap");
					ses.update(user);
					//commit tx
					tx.commit();
					System.out.println("Object is updated for ::"+user.getUpdateCount());
				}//if
				else {
					System.out.println("Object not found for Updation");
				}//else
				
				
			}//try
			catch(HibernateException he) {
				if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
					tx.rollback();
				he.printStackTrace();
			

		}

	}
}


