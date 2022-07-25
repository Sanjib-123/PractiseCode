package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class LoadObjectUsingGetMethodTest {

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
		//Product p = new Product();
//		p.setPid(9014);p.setPname("candel");
//		p.setPrice(9000.55);p.setQty(10.0);
//		p.setStatus("available");
//		
		//saave object
		//Transaction tx = null;
		//boolean flag = true;
		try {
			//load object ses.get()
			Product proxy = ses.load(Product.class, 9046);
			System.out.println(proxy.getPname());
			//load object(ses.get()
			//Product prod = ses.get(Product.class, 9046);
//			if(prod==null) {
//				System.out.println("Record not found");
//			}
//			else {
//				System.out.println("record found and it is"+prod.getPid()+" "+prod.getPname()+" "+prod.getPrice()+" "+prod.getQty()+" "+prod.getStatus());
//			}
			//begin tx
			//tx = ses.beginTransaction(); //internally calls con.setAutoCommit(false)
			//int idVal = (int)ses.save(p); 
			//ses.save(p);
			//flag = true;
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
			ses.clear();
			factory.close();
			//perform Tx Mgmt
//			if(flag) {
//				tx.commit(); //internally calls con.commit method
//				System.out.println("Object is saved(Record is inserted)");
//			}//if
//			else {
//				tx.rollback(); //Internally calls con.rollback method
//				System.out.println("Object is not saved(Record is not inserted)");
//			}//else
		}//finally
		

	}

}
