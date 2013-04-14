package com.controller.homework;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.SearchStudentInfo;
import com.bean.homework.Student;

public class ShowTeamAndMemberServlet extends HttpServlet 
{
	private static final long serialVersionUID = 6989925835878853594L;

	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		//System.out.println("Here001!");
		Student s = (Student) request.getSession().getAttribute("student");
		String teamid = request.getParameter("teamid");
		String monitorid = request.getParameter("monitorid");
		String flag = request.getParameter("flag");
		String studentid = s.getStudentId();
		
		
		if (teamid!= null && monitorid!=null) 
		{
			//Student s = (Student) request.getSession().getAttribute("student");
			
			SearchStudentInfo showteaminfo = new SearchStudentInfo();
			request.getSession().setAttribute("myteammemberinfo", showteaminfo.searchTeamInfo(teamid,monitorid));
			//System.out.println("Here1111!");
			
			//SearchStudentInfo searchStudentInfo2 = new SearchStudentInfo();
			//request.getSession().setAttribute("myteam", searchStudentInfo2.searchStudentTeamInfo(s.getStudentId()));
			
		}
		
		try 
		{
			if(flag.equals("0"))
			    response.sendRedirect("/homework/showteammember.jsp?" + request.getQueryString() );
			else if(flag.equals("1"))
				response.sendRedirect("/homework/showteammemberforteacher.jsp?" + request.getQueryString() );
	
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
