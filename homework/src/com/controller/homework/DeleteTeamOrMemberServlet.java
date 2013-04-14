package com.controller.homework;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.DeleteAction;
import com.action.homework.SearchStudentInfo;
import com.bean.homework.Student;

public class DeleteTeamOrMemberServlet extends HttpServlet 
{
	private static final long serialVersionUID = 6989925835878853594L;
      
	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		Student s = (Student) request.getSession().getAttribute("student");
		String teamid = request.getParameter("teamid");
		String monitorid =request.getParameter("monitorid");
		String studentid = s.getStudentId();
		// System.out.println(studentid+teamid+"lalalal");
		if (teamid != null) 
		{
			
			
			DeleteAction deleteaction = new DeleteAction();
			
			System.out.println(studentid.equals(monitorid));
			if(studentid.trim().equals(monitorid))
			{
			  deleteaction.teamAllDelete1(teamid);	
			  deleteaction.teamAllDelete2(teamid);	
			  
			}
			else
			{
				
			  deleteaction.teamMemberDelete(teamid,s.getStudentId());
			}
			
			SearchStudentInfo searchStudentInfo2 = new SearchStudentInfo();
			request.getSession().setAttribute("myteam", searchStudentInfo2.searchStudentTeamInfo(s.getStudentId()));
		}

		try 
		{
			response.sendRedirect("/homework/showteam.jsp");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
