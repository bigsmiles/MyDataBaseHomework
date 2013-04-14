package com.controller.homework;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.DeleteAction;
import com.action.homework.SearchCourse;
import com.bean.homework.Teacher;

public class DeleteTeacherCourseServlet extends HttpServlet 
{
	private static final long serialVersionUID = 6989925835878853594L;
      
	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		String courseid = request.getParameter("courseid");
		String teacherid = ((Teacher) request.getSession().getAttribute("teacher")).getTeacherId();
		if (courseid != null &&teacherid !=null) 
		{
			DeleteAction DeleteAction = new DeleteAction();
			DeleteAction.courseTeacherDelete(teacherid,courseid);
            
			SearchCourse courseInfo1 = new SearchCourse();
			request.getSession().setAttribute("teacherstillcourse", courseInfo1.TeacherSearchCourse(teacherid));
			
			SearchCourse courseInfo2 = new SearchCourse();
			request.getSession().setAttribute("teachercourse", courseInfo2.TeacherSearchHaveCourse(teacherid));
		}

		try 
		{
			response.sendRedirect("/homework/showteachercourse.jsp");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
