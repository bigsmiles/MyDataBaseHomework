package com.controller.homework;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.SearchHomework;
import com.action.homework.SearchStudentInfo;
import com.action.homework.SearchCourse;
import com.bean.homework.Student;
import com.bean.homework.Course;
import com.bean.homework.Team;
import com.dao.homework.CourseDaoImpl;



public class RefreshMainPageServlet extends HttpServlet
{
	private static final long serialVersionUID = 7226458696780819414L;

	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		Student s = (Student) request.getSession().getAttribute("student");
		SearchStudentInfo searchStudentInfo = new SearchStudentInfo();
		request.getSession().setAttribute("mystudent", searchStudentInfo.searchStudentInfo(s.getStudentId()));
		
		SearchCourse courseInfo1 = new SearchCourse();
		request.getSession().setAttribute("stillcourse", courseInfo1.SearchCourse(s.getStudentId()));
		
		SearchCourse courseInfo2 = new SearchCourse();
		request.getSession().setAttribute("mycourse", courseInfo2.SearchHaveCourse(s.getStudentId()));
		
		SearchStudentInfo searchStudentInfo2 = new SearchStudentInfo();
		request.getSession().setAttribute("myteam", searchStudentInfo2.searchStudentTeamInfo(s.getStudentId()));
		
		
		try 
		{
			response.sendRedirect("/homework/StudentMain.html");
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
