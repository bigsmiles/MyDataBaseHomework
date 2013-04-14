package com.controller.homework;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.SearchStudentInfo;

public class ShowStudentOnCourseServlet extends HttpServlet 
{
	private static final long serialVersionUID = 6989925835878853594L;

	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		String courseid = request.getParameter("courseid");
		String teacherid = request.getParameter("teacherid");
		
		
		if (courseid!= null && teacherid!=null) 
		{
			SearchStudentInfo studentInfo = new SearchStudentInfo();
			request.getSession().setAttribute("studentoncourse", studentInfo.searchStudentOnCourse(courseid,teacherid));
			//System.out.println("Here1111!");
		}
		
		try 
		{
			response.sendRedirect("/homework/showstudentoncourse.jsp");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
