package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

	@Override
	public Iterable<Actor> fetchActorsByIds(Iterable<Integer> ids) {
		
		return actorRepo.findAllById(ids);
	}

	@Override
	public Optional<Actor> fetchActorById(int aid) {
		Optional<Actor> opt = actorRepo.findById(aid);
		return opt;
	}

	@Override
	public Actor showActorById(int aid) {
		return actorRepo.findById(aid).orElseThrow(()->new IllegalArgumentException("Actor not found"));
//		Optional<Actor> opt =actorRepo.findById(aid);
//		return opt.orElseThrow(()->new IllegalArgumentException("Actor not found"));
//		if(opt.isPresent())
//			
//		return opt.get() ;
//		else
//			throw new IllegalArgumentException("aCTOR not found");
	}

	@Override
	public String updateActorMobileNo(int aid, Long newMobileNo) {
		Optional<Actor> opt = actorRepo.findById(aid);
		if(opt.isPresent()) {
			Actor actor = opt.get();
			actor.setMobileNo(newMobileNo);
			Actor uActor = actorRepo.save(actor);
			return aid+"is updated with new MobileNo"+newMobileNo;
		}
		else
		return aid+"Actor not found for updation";
	}

	@Override
	public String removeActorById(int aid) {
		Optional <Actor> opt = actorRepo.findById(aid);
		if(opt.isEmpty()) {
			actorRepo.deleteById(aid);
			return aid+"Actor is deleted";
		}
		else
		 return aid+"Actor is not found for deletion";
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
