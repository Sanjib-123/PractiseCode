package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.sbeans.Employee;

@SpringBootApplication
public class BootProject06ConfigurationPropertiesListArraySetApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx = SpringApplication.run(BootProject06ConfigurationPropertiesListArraySetApplication.class, args);
		
		//get employee obj ref
		Employee emp = ctx.getBean("emp",Employee.class);
		
		//display the objects
		System.out.println(emp);
	}

}
