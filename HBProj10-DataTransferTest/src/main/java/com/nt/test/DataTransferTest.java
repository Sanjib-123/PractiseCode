package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;

import com.nt.utility.HibernateUtil_Mysql;
import com.nt.utility.HibernateUtil_Postgre;

public class DataTransferTest {

	public static void main(String[] args) {
		//get session factory
		SessionFactory mysqlfactory = HibernateUtil_Mysql.getSessionFactory();
		//get session object
		Session mysqlses = HibernateUtil_Mysql.getSession();
		SessionFactory postgrefactory = HibernateUtil_Postgre.getSessionFactory();
		//get session object
		Session postgrelses = HibernateUtil_Postgre.getSession();
		
		
		Transaction tx = null;
		try(mysqlfactory;mysqlses;postgrefactory;postgrelses){
			//load object from mysql
			Product prod = mysqlses.get(Product.class,1);
			if(prod!=null) {
			//begin tx
			tx = postgrelses.beginTransaction();
			//Prepare object
			postgrelses.save(prod);
			
			tx.commit();
			System.out.println("Product is transfered");
			}//if
			else {
				System.out.println("Product is not available to transfer");
			}
		}//try
		catch(HibernateException he) {
			if(tx!=null && tx.getStatus()!= null && tx.getRollbackOnly()) 
				tx.rollback();
				he.printStackTrace();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
