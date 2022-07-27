package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class PersistObjectTest {

	public static void main(String[] args) {
		//activate HB framework
		Configuration cfg = new Configuration();
		//specify HB cfg file name and location
		cfg.configure("/com/nt/cnfgs/hibernate.cfg.xml");
		//create HB SessionFactory object
		SessionFactory factory = cfg.buildSessionFactory();
		//create session object
		Session ses = factory.openSession();
		//prepare entity class object having data
		Product p = new Product();
		p.setPid(9046);p.setPname("candel");
		p.setPrice(9000.55);p.setQty(10.0);
		p.setStatus("available");
		
		//saave object
		Transaction tx = null;
		boolean flag = true;
		try {
			//begin tx
			tx = ses.beginTransaction(); //internally calls con.setAutoCommit(false)
			ses.persist(p); 
			//ses.save(p);
			flag = true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag = false;
		}//catch
		catch(Exception e) {
			e.printStackTrace();
			flag = false;
		}//catch
		finally {
			//perform Tx Mgmt
			if(flag) {
				tx.commit(); //internally calls con.commit method
				System.out.println("Object is saved(Record is inserted)");
			}//if
			else {
				tx.rollback(); //Internally calls con.rollback method
				System.out.println("Object is not saved(Record is not inserted)");
			}//else
			//close HB objects
			ses.close();
			factory.close();
		}//finally
		

	}

}
