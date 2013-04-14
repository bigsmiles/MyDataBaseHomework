package com.controller.homework;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.AddAction;
import com.action.homework.SearchHomework;
import com.action.homework.SearchStudentInfo;
import com.bean.homework.Student;

public class StudentAddServlet extends HttpServlet 
{
	private static final long serialVersionUID = 6989925835878853594L;

	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		
		String teamid = request.getParameter("teamid");
		String teamname = request.getParameter("teamname");
		String teamcour = request.getParameter("teamcour");
		String teamteacherid = request.getParameter("teamteacherid");
		String teammonitorid = request.getParameter("teammonitorid");
		String teammonitor = request.getParameter("teammonitor");
		String flag = request.getParameter("flag");
		
		String studentid = request.getParameter("studentid");
		String myteamid = request.getParameter("myteamid");
		Student s = (Student) request.getSession().getAttribute("student");
		
		if (flag.equals("0") && teamid!= null && teamname!=null && teamcour!=null && teamteacherid!=null&&teammonitorid!=null) 
		{
			/*RegisterAction RegisterAction = new RegisterAction();
			RegisterAction.courseRegister(studentid,courseid);
            
			//System.out.println("Here!");
			//request.getSession().removeAttribute("mycourse");*/
			
			//System.out.println("Here!");
			
			AddAction addteam= new AddAction();
			addteam.addTeam(teamid,teamname,teamcour,teamteacherid,teammonitorid,teammonitor);
			
			addteam.addStudentToMyTeam(teammonitorid,teamid);
			
			
			SearchStudentInfo searchStudentInfo2 = new SearchStudentInfo();
			request.getSession().setAttribute("myteam", searchStudentInfo2.searchStudentTeamInfo(s.getStudentId()));
			
		}
		else if(flag.equals("1") && studentid!=null)
		{
			AddAction addstudenttomyteam= new AddAction();
			addstudenttomyteam.addStudentToMyTeam(studentid,myteamid);
			
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
