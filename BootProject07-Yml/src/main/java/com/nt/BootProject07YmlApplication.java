package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Customer;

@SpringBootApplication
public class BootProject07YmlApplication {

	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx = SpringApplication.run(BootProject07YmlApplication.class, args);
		//get customer obj ref
		Customer cust = ctx.getBean("cust",Customer.class);
		
		//print customer
		System.out.println(cust);
		//close IOC container
		((ConfigurableApplicationContext) ctx).close();
	}

}
