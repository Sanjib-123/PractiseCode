package com.nt.runners;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Actor;
import com.nt.service.IActorMgmtService;

@Component
public class CrudRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private IActorMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		
	//for count method
		try {
			System.out.println("Records count is::"+service.fetchRecordsCount());
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("---------------");
		try {
		Iterable<Actor> it = service.fetchAllActors();
		it.forEach(actor->{             //java 8 for each
			System.out.println(actor);
		});
		System.out.println("------------");
		it.forEach(System.out::println); //java8 forEach(-) with static method reference
		System.out.println("---------------");
		for(Actor actor:it) {    //java enhanced for loop
			System.out.println(actor);
		}
		it.forEach(actor->System.out.println(actor)); //java8 forEach(_) with single line
		
		System.out.println("--------");
		List<Actor>list = (List<Actor>)it;
		list.stream().forEach(System.out::println); //java 8 streaming api + forEach(-)
		                                             //stream api to filter the data
		
		System.out.println("--------");
		System.out.println("count of records::"+list.stream().count()); //stream for aggregate operation
		
		System.out.println("--------");
		list.stream().sorted(Comparator.comparing(actor->actor.getAid())).forEach(System.out::println); //sorting operation
		
		System.out.println("-----------findAllById(-)-----------");
		service.fetchActorsByIds(List.of(9,10,11)).forEach(System.out::println);
		
		service.fetchActorsByIds(Arrays.asList(9,10,11)).forEach(actor->System.out.println(actor));
		
		System.out.println("-----------findById(-)-----------");
		Optional<Actor>opt = service.fetchActorById(9);
		if(opt.isPresent())
			System.out.println("Actor info::"+opt.get());
		else
			System.out.println("Actor not found");
		
		System.out.println("-----------------------");
		
		Optional<Actor>opt1 = service.fetchActorById(9);
		Actor actor =opt1.orElseThrow(()->new IllegalArgumentException("Actor not found"));
		System.out.println("Actor info ::"+actor);
		
		System.out.println("-----------------------");
		

		Optional<Actor>opt2 = service.fetchActorById(9);
		Actor actor1 =opt2.orElse(new Actor());
		System.out.println("Actor info ::"+actor1);
		
		
		System.out.println("-----------------------");
		
		Optional<Actor>opt3 = service.fetchActorById(9);
		if(opt3.isEmpty()) 
			System.out.println("Actor not found");
		
		else
			System.out.println("Actor found"+opt3.get());
		
		System.out.println("-------findById(_)returning<T> directly----------------");
		System.out.println("Actor info:"+service.showActorById(9));
		
		

	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
