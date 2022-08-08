package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Actor;

public interface IActorMgmtService {
	public String registerActor(Actor actor);
	public String registerActorsGroup(Iterable<Actor>list);
	public long fetchRecordsCount();
	public Iterable<Actor> fetchAllActors();
	public boolean isActorAvailable(int aid);
	public Iterable<Actor> fetchActorsByIds(Iterable<Integer>ids);
	public Optional<Actor> fetchActorById(int aid);
	public Actor showActorById(int aid);
	public String updateActorMobileNo(int aid,Long newMobileNo);
	public String removeActorById(int aid);
	

}
