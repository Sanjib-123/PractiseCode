package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping(value="/report",method=RequestMethod.GET)
	public String showReport(Map<String,Object>map) {
		System.out.println("TestController.showReport()");
		return "display";
	}
	@RequestMapping(value="/report",method=RequestMethod.POST)
	public String showRepor1t(Map<String,Object>map) {
		System.out.println("TestController.showReport1()");
		return "display1";
	}

}
