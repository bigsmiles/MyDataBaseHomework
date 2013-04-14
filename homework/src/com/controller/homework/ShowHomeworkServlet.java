package com.controller.homework;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.SearchHomework;

public class ShowHomeworkServlet extends HttpServlet 
{
	private static final long serialVersionUID = 6989925835878853594L;

	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		//System.out.println("Here001!");
		String courseid = request.getParameter("courseid");
		String teacherid = request.getParameter("teacherid");
		System.out.println("Here!"+courseid);
		
		if (courseid!= null && teacherid!=null) 
		{
			/*RegisterAction RegisterAction = new RegisterAction();
			RegisterAction.courseRegister(studentid,courseid);
            
			//System.out.println("Here!");
			//request.getSession().removeAttribute("mycourse");*/
			
			//System.out.println("Here!");
			
			
			SearchHomework homeworkInfo = new SearchHomework();
			request.getSession().setAttribute("myhomework", homeworkInfo.SearchHomework(courseid,teacherid));
			//System.out.println("Here1111!");
		}
		
		try 
		{
			response.sendRedirect("/homework/showhomework.jsp?" + request.getQueryString());
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
