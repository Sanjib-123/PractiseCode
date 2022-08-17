package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.service.IWishMessageService;

@Controller
public class WishMessageGenerator {
	@Autowired
	private IWishMessageService service;
	
	@RequestMapping("/")
	public String showHome() {
		return "home";//LVN
	}
	
	@RequestMapping("/wish")
	public ModelAndView generateMessage() {
		//use service
		String result = service.generateWishMessage();
		
		//return MAV
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("wMsg", result);
//		mav.setViewName("display");
//		return mav;
		return new ModelAndView("display","wMsg",result);//Here we can add only one Model Attribute
	}

}
