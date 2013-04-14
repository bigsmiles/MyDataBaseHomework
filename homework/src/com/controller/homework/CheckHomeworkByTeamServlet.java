package com.controller.homework;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.SearchHomework;
import com.action.homework.SearchStudentInfo;

public class CheckHomeworkByTeamServlet extends HttpServlet 
{
	private static final long serialVersionUID = 6989925835878853594L;

	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		//System.out.println("Here001!");
		String courseid = request.getParameter("courseid");
		String teacherid = request.getParameter("teacherid");
		String homeworkid =request.getParameter("homeworkid");
		
		
		if (courseid!= null && teacherid!=null && homeworkid!=null) 
		{
					
			SearchHomework homeworkInfo = new SearchHomework();
			request.getSession().setAttribute("homeworkbyteam", homeworkInfo.SearchHomeworkByTeam(courseid,teacherid,homeworkid));
		   
			//SearchStudentInfo showteaminfo = new SearchStudentInfo();
			//request.getSession().setAttribute("myteammemberinfo", showteaminfo.searchTeamInfo(teamid,monitorid));
		}
		
		try 
		{
			response.sendRedirect("/homework/checkhomeworkbyteam.jsp");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
