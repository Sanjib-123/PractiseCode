package com.nt.test;

import java.util.Iterator;

public class HQLSelectTest {
	
	//HQL Select Query(scalar query-Getting specific single col value of db table)
//	Query query = ses.createQuery("SELECT actorName from Actor where actorAddrs=?1");
//	query.setParameter(1,"hyd");
//	List<String> list = query.getResultList();
//	list.forEach(name->{
//		System.out.println(name);
//		
//	});
	
	//HQL Select query using Iterate()(Scalar query-getting specific single col value of db table)
	
//	Query query = ses.createQuery("SELECT actorId,actorName from Actor where actorAddrs=?1");
//	query.setParameter(1,"hyd");
//	Iterator<Object[]> it = query.iterate();
//	while(it.hasNext()) {
//		Object row[] = it.next();
//		for(Object val:row)
//			System.out.println(val+" ");
//	}
	
	//HQL Select Query using getSingleResult()method(Entity query giving 0 or 1 record)
	
//	Query query = ses.createQuery("From Actor where actorId=?1");
//	query.setParameter(1,456);
//	Actor actor = (Actor)query.getSingleResult();
//	if(actor == null)
//		System.out.println("Record not found");
//	else
//		System.out.println("Record found");
//	System.out.println(actor);
	
	
       	
}

//Prepare Query object
//Query query = ses.createQuery("from Actor where actorId>=?1 and actorId<=?2");
//set parameter values
//query.setParameter(1,1000);
//query.setParameter(2,2000);

//Execute the query
//List<Actor> list = query.getResultList();
////process the Result
//list.forEach(actor->{
//	System.out.println(actor);
//});

//Query query = ses.createQuery("from Actor where actorId>=:min and actorId<=:max");















