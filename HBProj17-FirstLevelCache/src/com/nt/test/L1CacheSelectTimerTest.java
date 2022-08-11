package com.nt.test;

import java.util.Timer;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.schedulling.TimerService;
import com.nt.utility.HibernateUtil;

public class L1CacheSelectTimerTest {

	public static void main(String[] args) {
		//get SessionFactory
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		//get Session
		Session ses = HibernateUtil.getSession();
		Timer timer = new Timer();
		timer.schedule(new TimerService(ses), 1000,2000);
		try(factory;ses){
			//load object
			Product p = ses.get(Product.class,9045); //collects in DB and puts in L1 cache
			System.out.println(p);
			Thread.sleep(5000);
			System.out.println("-----------------");
			Product p1 = ses.get(Product.class,9045); //collects from l1 cache and gives to app
			System.out.println(p1);
			System.out.println("-----------------");
			Thread.sleep(2000);
			//ses.clear(); //remove all object from l1 cache
			Product p2 = ses.load(Product.class, 9045);
			System.out.println(p2);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
