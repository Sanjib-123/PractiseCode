package com.nt.runners;

import java.util.Comparator;
import java.util.List;

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

	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
