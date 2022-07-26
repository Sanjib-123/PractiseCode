package com.nt.service;

import java.util.Arrays;

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

}
