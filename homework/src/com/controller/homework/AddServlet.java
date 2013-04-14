package com.controller.homework;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.AddAction;
import com.action.homework.SearchHomework;

public class AddServlet extends HttpServlet 
{
	private static final long serialVersionUID = 6989925835878853594L;

	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		//System.out.println("Here001!");
		String courseid = request.getParameter("courseid");
		String teacherid = request.getParameter("teacherid");
		String homeworkid = request.getParameter("homeworkid");
		System.out.println("Here!"+courseid+teacherid+homeworkid);
		
		if (courseid!= null && teacherid!=null) 
		{
			/*RegisterAction RegisterAction = new RegisterAction();
			RegisterAction.courseRegister(studentid,courseid);
            
			//System.out.println("Here!");
			//request.getSession().removeAttribute("mycourse");*/
			
			//System.out.println("Here!");
			
			AddAction addhomework = new AddAction();
			addhomework.addNewHomework(homeworkid, courseid, teacherid);
			
			SearchHomework homeworkInfo = new SearchHomework();
			request.getSession().setAttribute("teacherhomework", homeworkInfo.SearchHomework(courseid,teacherid));
			//System.out.println("Here1111!");
		}
		
		try 
		{
			response.sendRedirect("/homework/showteacherhomework.jsp");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
