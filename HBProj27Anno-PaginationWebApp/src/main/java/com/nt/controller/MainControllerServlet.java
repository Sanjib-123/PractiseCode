package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Session;
import com.nt.entity.Actor;
import com.nt.service.ActorManagementServiceImpl;
import com.nt.service.IActorManagementService;


@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	
	private IActorManagementService service;
	
	public void init() throws ServletException{
		service = new ActorManagementServiceImpl();
		
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		/**
		 * read special request parameter value to decide  request has come 
		 * from submit button or hyperlink 
		 */
		
		String s1 = request.getParameter("s1");
		int pageNo = 0,pageSize = 0;
		HttpSession ses = null;
		if(s1.equalsIgnoreCase("gET Report")) { //for submit button
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNo = 0;
			ses = request.getSession();
			ses.setAttribute("pageSize", pageSize);
			
		}
		else {//from hyperlink
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			pageSize = (int) ses.getAttribute("pageSize");
		}
		//use service
		int pagesCount = service.getPagesCount(pageSize);
		List<Actor> list = service.getReportPageData(pageNo, pageSize);
		
		//keep results in request scope
		request.setAttribute("pageData", list);
		request.setAttribute("pagesCount", pagesCount);
		
		//forward to jsp page
		RequestDispatcher rd = request.getRequestDispatcher("/show_report.jsp");
		rd.forward(request, response);
	}
	
	
	
public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	doGet(request,response);
		
	}

}
