package com.controller.homework;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.SearchHomework;

public class CheckHomeworkByPersonServlet extends HttpServlet 
{
	private static final long serialVersionUID = 6989925835878853594L;

	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		//System.out.println("Here001!");
		String courseid = request.getParameter("courseid");
		String teacherid = request.getParameter("teacherid");
		String homeworkid =request.getParameter("homeworkid");
		
		
		if (courseid!= null && teacherid!=null && homeworkid!=null) 
		{
					
			SearchHomework homeworkInfo = new SearchHomework();
			request.getSession().setAttribute("homeworkbyperson", homeworkInfo.SearchHomeworkByPerson(courseid,teacherid,homeworkid));
		}
		
		try 
		{
			response.sendRedirect("/homework/checkhomeworkbyperson.jsp");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
