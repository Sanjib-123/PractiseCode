package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Hotel;

@SpringBootApplication
public class BootProject04ValueAnnotationSpelApplication {

	public static void main(String[] args) {
		//get ioc container
		ApplicationContext ctx= SpringApplication.run(BootProject04ValueAnnotationSpelApplication.class, args);
		
		//get hotel object ref
		Hotel hotel = ctx.getBean("hotel",Hotel.class);
		System.out.println(hotel);
		//close the ioc contaner
		((ConfigurableApplicationContext) ctx).close();
	}

}
