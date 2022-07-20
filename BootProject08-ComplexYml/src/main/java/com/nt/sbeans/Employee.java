package com.nt.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component("emp")
@Data
@ConfigurationProperties(prefix="org.nit")
public class Employee {
	//simple properties
		private Integer eno;
		private String ename;
		
		//array type
		private String[] favColors;
		
		//collection type
		private List<String> nickName;
		private Set<Long> phoneNumber;
		private Map<String,Object> idDetails;
		
		
		//HAS-A properties
		private Company company;

}
