package com.nt;

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
		try {
			//create Actor class obj
			Actor actor = new Actor();
			actor.setAname("Rajini");
			actor.setCatagory("HERO");
			actor.setMobileNo(99999999L);
			String resultMsg = service.registerActor(actor);
			System.out.println(resultMsg);
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
