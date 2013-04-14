package com.controller.homework;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.DeleteAction;
import com.action.homework.SearchCourse;
import com.bean.homework.Student;

public class DeleteCourseServlet extends HttpServlet 
{
	private static final long serialVersionUID = 6989925835878853594L;
      
	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		String courseid = request.getParameter("courseid");
		String studentid = ((Student) request.getSession().getAttribute("student")).getStudentId();
		if (courseid != null) 
		{
			DeleteAction DeleteAction = new DeleteAction();
			DeleteAction.courseDelete(studentid,courseid);
            
			SearchCourse courseInfo1 = new SearchCourse();
			request.getSession().setAttribute("stillcourse", courseInfo1.SearchCourse(studentid));
			
			//System.out.println("Here!");
			SearchCourse courseInfo = new SearchCourse();
			request.getSession().setAttribute("mycourse", courseInfo.SearchHaveCourse(studentid));
		}

		try 
		{
			response.sendRedirect("/homework/showcourse.jsp");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
