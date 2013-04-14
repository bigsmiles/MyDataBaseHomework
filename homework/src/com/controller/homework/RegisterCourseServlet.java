package com.controller.homework;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.RegisterAction;
import com.action.homework.SearchCourse;
import com.bean.homework.Student;

public class RegisterCourseServlet extends HttpServlet 
{
	private static final long serialVersionUID = 6989925835878853594L;

	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		//System.out.println("Here001!");
		String courseid = request.getParameter("courseid");
		String teacherid = request.getParameter("teacherid");
		System.out.println(courseid);
		String studentid = ((Student) request.getSession().getAttribute("student")).getStudentId();
		if (courseid != null && teacherid !=null) 
		{
			RegisterAction RegisterAction = new RegisterAction();
			System.out.println("Here!");
			RegisterAction.courseRegister(studentid,courseid,teacherid);
            
			
			//request.getSession().removeAttribute("mycourse");
			SearchCourse courseInfo = new SearchCourse();
			request.getSession().setAttribute("stillcourse", courseInfo.SearchCourse(studentid));
			
			SearchCourse courseInfo2 = new SearchCourse();
			request.getSession().setAttribute("mycourse", courseInfo2.SearchHaveCourse(studentid));
		}
		
		try 
		{
			response.sendRedirect("/homework/registercourse.jsp");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
