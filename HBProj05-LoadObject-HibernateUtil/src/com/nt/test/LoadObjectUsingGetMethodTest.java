package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class LoadObjectUsingGetMethodTest {

	public static void main(String[] args) {
		//get session object
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//get session object
		Session ses = HibernateUtil.getSession();
		
		try {
			//load object ses.get()
			Product prod = ses.load(Product.class, 9046);
			
			if(prod==null) {
			System.out.println("Record not found");
		}
		else {
				System.out.println("record found and it is"+prod.getPid()+" "+prod.getPname()+" "+prod.getPrice()+" "+prod.getQty()+" "+prod.getStatus());
		}
			
		}//try
		
		catch(HibernateException he) {
			System.out.println("object/record not found");
			he.printStackTrace();
			//flag = false;
		}//catch
		catch(Exception e) {
			e.printStackTrace();
			//flag = false;
		}//catch
		finally {
			HibernateUtil.closeSessionFactory();
			HibernateUtil.closeSession(ses);
			
		}//finally
		

	}

}
