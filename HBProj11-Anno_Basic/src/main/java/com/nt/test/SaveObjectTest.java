package com.nt.test;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Artist;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		//get SessionFactory
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(factory;ses){
			//begin Tx
			tx = ses.beginTransaction();
			//prepare objects
			//Artist arst = new Artist(2335,"raja","hyd",455666L,"hero");
			Artist arst = new Artist();
			arst.setAid(4344);
			arst.setName("srk");
			arst.setCatagory("hero");
			Integer idval = (Integer) ses.save(arst);
			System.out.println("generated id value::"+idval);
			tx.commit();
		}//try1
		
		catch(HibernateException he) {
			if(tx!=null||tx.getRollbackOnly()||tx.getStatus()!=null) {
				tx.rollback();
			}
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
