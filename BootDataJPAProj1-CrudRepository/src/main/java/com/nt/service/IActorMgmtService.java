package com.nt.service;

import java.util.List;

import com.nt.entity.Actor;

public interface IActorMgmtService {
	public String registerActor(Actor actor);
	public String registerActorsGroup(Iterable<Actor>list);
	public long fetchRecordsCount();
	public Iterable<Actor> fetchAllActors();
	public boolean isActorAvailable(int aid);
	

}
