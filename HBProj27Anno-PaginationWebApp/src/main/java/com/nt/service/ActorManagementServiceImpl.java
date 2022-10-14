package com.nt.service;

import java.util.List;

import com.nt.dao.IActorDAO;
import com.nt.entity.Actor;

public class ActorManagementServiceImpl implements IActorManagementService {
	
	private IActorDAO dao;
	

	@Override
	public int getPagesCount(int pageSize) {
		
		long recordsCount = dao.getRecordsCount();
		int pagesCount = (int) (recordsCount/pageSize);
		pagesCount = recordsCount%pageSize==0?pagesCount:++pagesCount;
		
		return pagesCount;
	}

	@Override
	public List<Actor> getReportPageData(int pageNo, int pageSize) {
		//decide start position
		int startPos = (pageNo * pageSize) - pageSize;
		//use Dao
		List<Actor> list = dao.getPageData(startPos, pageSize);
		
		return list;
	}
 
	
}
