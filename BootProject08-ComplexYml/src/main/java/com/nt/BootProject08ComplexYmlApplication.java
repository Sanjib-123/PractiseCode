package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.nt.sbeans.Employee;

@SpringBootApplication
public class BootProject08ComplexYmlApplication {

	public static void main(String[] args) {
		//create IOC container
				
		ApplicationContext ctx = SpringApplication.run(BootProject08ComplexYmlApplication.class, args);
		
		//get customer obj ref
				Employee emp = ctx.getBean("emp",Employee.class);
				
				//print customer
				System.out.println(emp);
				
	}

}
