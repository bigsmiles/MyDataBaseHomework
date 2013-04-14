package com.controller.homework;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.RegisterAction;
import com.action.homework.SearchCourse;
import com.bean.homework.Teacher;

public class TeacherRegisterCourseServlet extends HttpServlet 
{
	private static final long serialVersionUID = 6989925835878853594L;

	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		
		String courseid = request.getParameter("courseid");
		String coursename = request.getParameter("coursename");
		
		String teacherid = ((Teacher) request.getSession().getAttribute("teacher")).getTeacherId();
		String teachername = ((Teacher) request.getSession().getAttribute("teacher")).getTeacherName();
		if (courseid != null && teacherid !=null) 
		{
			RegisterAction RegisterAction = new RegisterAction();
			System.out.println("Here!");
			RegisterAction.courseTeacherRegister(courseid,coursename,teacherid,teachername);
            
			SearchCourse courseInfo1 = new SearchCourse();
			request.getSession().setAttribute("teacherstillcourse", courseInfo1.TeacherSearchCourse(teacherid));
			
			SearchCourse courseInfo2 = new SearchCourse();
			request.getSession().setAttribute("teachercourse", courseInfo2.TeacherSearchHaveCourse(teacherid));
			
		}
		
		try 
		{
			response.sendRedirect("/homework/teacherregistercourse.jsp");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
