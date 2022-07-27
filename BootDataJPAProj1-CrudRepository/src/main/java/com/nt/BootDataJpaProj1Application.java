package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.entity.Actor;
import com.nt.service.IActorMgmtService;

@SpringBootApplication
public class BootDataJpaProj1Application {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx = SpringApplication.run(BootDataJpaProj1Application.class, args);
		
		//get Service class obj ref
		IActorMgmtService service = ctx.getBean("ActorService",IActorMgmtService.class);
		
		//invoke the method
//		try {
//			//create Actor class obj
//			Actor actor = new Actor();
//			actor.setAname("Rajini");
//			actor.setCatagory("HERO");
//			actor.setMobileNo(99999999L);
//			String resultMsg = service.registerActor(actor);
//			System.out.println(resultMsg);
//		}//try
//		catch(DataAccessException dae) {
//			dae.printStackTrace();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			List<Actor>actorsList = List.of(new Actor(1001,"SALMAN","HERO",98093078L),
//					new Actor(1002,"RANVIR","HERO",98093078L),
//					new Actor(1001,"VIJAY","HERO",98093078L)); //java 9 features
//			String resultMsg = service.registerActorsGroup(actorsList);
//			System.out.println(resultMsg);
//		}//try
//		catch(DataAccessException dae) {
//			dae.printStackTrace();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		try {
//		List<Actor>actorsList = List.of(new Actor("SALMAN","HERO",98093078L),
//					new Actor("RANVIR","HERO",98093078L),
//					new Actor("VIJAY","HERO",98093078L)); //java 9 features
//			String resultMsg = service.registerActorsGroup(actorsList);
//			System.out.println(resultMsg);
//		}//try
//		catch(DataAccessException dae) {
//			dae.printStackTrace();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		try {
//			System.out.println("records count is::"+service.fetchRecordsCount());
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
		try {
			System.out.println("9 AID actor available ?"+service.isActorAvailable(9));
		}
		catch(Exception e) {
			e.printStackTrace();
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

	}
}

