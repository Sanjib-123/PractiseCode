package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;

@Service("ActorService")
public class ActorMgmtServiceImpl implements IActorMgmtService {
	@Autowired //Injects inMemory Proxy class obj that implementing our custom repository
	private IActorRepository actorRepo;

	@Override
	public String registerActor(Actor actor) {
		System.out.println("InMemory Proxy class name::"+actorRepo.getClass()+"---list of implemented interface "+Arrays.toString(actorRepo.getClass().getInterfaces()));
		Actor sactor = actorRepo.save(actor);
		
		return "actor is registered with id value:"+sactor.getAid();
	}

	@Override
	public String registerActorsGroup(Iterable<Actor> list) {
		if(list != null) {
			List<Actor>sEntities =  (List<Actor>) actorRepo.saveAll(list);
			List<Integer>ids = sEntities.stream().map(actor->actor.getAid()).collect(Collectors.toList());
			return ids.size()+"Object are saved having id values::"+ids;
		}
		return "Problem in batch insertion";
	}

	@Override
	public long fetchRecordsCount() {
		
		return actorRepo.count();
	}

	@Override
	public Iterable<Actor> fetchAllActors() {
		
		return actorRepo.findAll();
	}

	@Override
	public boolean isActorAvailable(int aid) {
		
		return actorRepo.existsById(aid);
	}

//	@Override
//	public String registerActorsGroup(List<Actor> list) {
//		if(list!=null) {
//			Iterable<Actor>sEntities = actorRepo.saveAll(list);
//			List<Integer> ids = new ArrayList();
//			int i = 0;
//			for(Actor actor:sEntities) {
//				ids.add(actor.getAid());
//				++i;
//			}
//			return ids.size()+"Objects are saved having id values::"+ids;
//		}
//		return "Problem in batch insertion";
//	
//	}
	

}