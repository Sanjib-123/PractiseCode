package com.nt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProject09LayeredAppProfilesPropertiesfilesApplication {
	@Autowired
	private Environment env;
	
	@Bean(name="c3p0DS")
	@Profile("test")
	public ComboPooledDataSource createC3PODS() throws Exception{
		System.out.println("BootProject09LayeredAppProfilesPropertiesfilesApplication.createC3PODS()");
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		cpds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		cpds.setUser(env.getRequiredProperty("spring.datasource.username"));
		cpds.setPassword(env.getProperty("spring.datasource.password"));
		cpds.setInitialPoolSize(Integer.parseInt(env.getProperty("c3p0.minsize")));
		cpds.setMaxPoolSize(Integer.parseInt(env.getProperty("c3p0.maxsize")));
		return cpds;
		
	}

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx = SpringApplication.run(BootProject09LayeredAppProfilesPropertiesfilesApplication.class, args);
		
		//get Controller class obj ref
		PayrollOperationsController controller = ctx.getBean("payroll",PayrollOperationsController.class);
		
		//invoke the b.method
		try {
			List<Employee> list = controller.showEmployeesByDesgs("CLERK", "MANAGER", "SALESMAN");
			list.forEach(emp->{
				System.out.println(emp);
			});
		}//try
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("Internal problem---try again::"+e.getMessage());
		}//catch
		//close IOC container
		((ConfigurableApplicationContext) ctx).close();
	}

}
