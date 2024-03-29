package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Artist;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		//get SessionFactory
				SessionFactory factory = HibernateUtil.getSessionFactory();
				Session ses = HibernateUtil.getSession();
				
				try(factory;ses){
					Artist arts = ses.load(Artist.class, 4344);
					System.out.println(arts);

	}
				catch(HibernateException he) {
					System.out.println("Problem in Loading records ");
					he.printStackTrace();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
	}

}
