package com.controller.homework;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.DeleteAction;
import com.action.homework.SearchCourse;
import com.action.homework.SearchStudentInfo;
import com.bean.homework.Student;

public class DeleteTeamMemberServlet extends HttpServlet 
{
	private static final long serialVersionUID = 6989925835878853594L;
      
	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		String teamid = request.getParameter("teamid");
		String studentid = request.getParameter("studentid");
		String monitorid =request.getParameter("monitorid");
		// System.out.println(studentid+teamid+"lalalal");
		if (teamid != null && studentid!=null) 
		{
			
            //System.out.println(studentid+teamid+"lalalal");
			DeleteAction deleteaction = new DeleteAction();
			deleteaction.teamMemberDelete(teamid,studentid);
			
			//String monitorid="1234";
			SearchStudentInfo showteaminfo = new SearchStudentInfo();
			request.getSession().setAttribute("myteammemberinfo", showteaminfo.searchTeamInfo(teamid,monitorid));			
			
		}

		try 
		{
			response.sendRedirect("/homework/showteammember.jsp");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
