package com.controller.homework;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.SearchCourse;
import com.bean.homework.Student;
import com.bean.homework.Teacher;



public class RefreshTeacherMainPageServlet extends HttpServlet
{
	private static final long serialVersionUID = 7226458696780819414L;

	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		
		Teacher s = (Teacher) request.getSession().getAttribute("teacher");
		
		SearchCourse courseInfo1 = new SearchCourse();
		request.getSession().setAttribute("teacherstillcourse", courseInfo1.TeacherSearchCourse(s.getTeacherId()));
		
		SearchCourse courseInfo2 = new SearchCourse();
		request.getSession().setAttribute("teachercourse", courseInfo2.TeacherSearchHaveCourse(s.getTeacherId()));
		try 
		{
			response.sendRedirect("/homework/teachermain.jsp");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
