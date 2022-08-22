package com.nt.model;

import lombok.Data;

@Data
public class Employee {
	private int eno;
	private String ename;
	private String eadd;
	private float salary = 9000.0f;
	
	public Employee() {
		System.out.println("Employee.Employee()");
	}

}
//w3c = world wide web consortium