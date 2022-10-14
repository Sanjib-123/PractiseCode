package com.nt.dao;

import java.util.List;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;


import org.hibernate.Session;
import org.hibernate.query.Query;

public class ActorDAOImpl implements IActorDAO {
	private static final String GET_ACTORS_COUNT="SELECT COUNT(*)FROM com.nt.entity.Actor";
	private static final String GET_ACTORS_PAGE_DATA="FROM com.nt.entity.Actor";

	@Override
	public long getRecordsCount() {
		//Get Session object
		Session ses = HibernateUtil.getSession();
		long count = 0;
		try(ses){
			//Execute JPQL
			Query query = ses.createQuery(GET_ACTORS_COUNT);
			count = (long) query.getSingleResult();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Actor> getPageData(int startPos, int pageSize) {
		//Get session object
		Session ses = HibernateUtil.getSession();
		//Execute jpql
		try(ses){
			Query query = ses.createQuery(GET_ACTORS_PAGE_DATA);
			//pagination setting
			query.setFirstResult(startPos);
			query.setMaxResults(pageSize);
			List<Actor> list = query.getResultList();
			return list;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
