package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class HQLSelectTest {
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session ses = factory.openSession();
		try(factory;ses){
			//prepare Query Object
			//Query query = ses.createQuery("from Actor");
			//send and execute the query
			//List<Actor> list = query.getResultList();
//			list.forEach(actor->{
//				System.out.println(actor);
//			});
			//list.forEach(System.out::println);
			//list.stream().forEach(System.out::println);
//			for(Actor actor:list) {
//				System.out.println(actor);
//			}
			
			//Prepare Query Object
//			Query query = ses.createQuery("from Actor");
//			//Execute the query
//			Iterator<Actor> it = query.iterate();
//			while(it.hasNext()) {
//				Actor actor = it.next();
//				System.out.println(actor);
//			}
			
			//HQL Select Query(Entity query-selecting allo col values of DB table)
			/*Query query = ses.createQuery("from Actor where actorAddrs=?1");
			query.setParameter(1,"hyd");
			List<Actor> list = query.getResultList();
			list.forEach(actor ->{
				System.out.println(actor);
				
			});
			*/
			//HQL Select Query(Scalar query-Getting specific multiple col values of db table)
			Query query = ses.createQuery("SELECT actorId,actorName from Actor where actorAddrs=?1");
			query.setParameter(1, "hyd");
			List<Object[]> list = query.getResultList();
			list.forEach(row->{
				for(Object val:row)
					System.out.println(val+" ");
				System.out.println();
			});
			
		}
	}

}
