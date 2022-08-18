package com.nt.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.model.Employee;

@Controller
public class TestController {
	
	@GetMapping("/report")
	public String showReport(Map<String,Object>map) {
//		//add model attributes(Simple values)
//		map.put("name", "raja");
//		map.put("age", "40");
//		map.put("addrs", "hyd");
//		
//		String nickNames[]=new String[] {"raja","jony","ramesh","suresh"};
//		Set<Long>mobilePhonesSet=new HashSet();
//		mobilePhonesSet.add(9999999L);
//		mobilePhonesSet.add(8888888L);
//		List<String>coursesList=List.of("java","Spring","spring boot","hibernate");
//		Map<String,Long>idsMap=Map.of("aadhar",453544L,
//				                       "voterId",5665667L,
//				                       "panNo",546656757L);
//		
//		//create model attributes
//		map.put("nickNames", nickNames);
//		map.put("phonesInfo", mobilePhonesSet);
//		map.put("coursesInfo", coursesList);
//		map.put("idsInfo", idsMap);
		
		List<Employee> empList = List.of(new Employee(101,"sanjib","developer",130000.0));
		
		map.put("empInfo", empList);
		//return LVN
		return "show_report";
	}

}
