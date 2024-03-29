package com.controller.homework;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.LoginAction;
import com.bean.homework.Teacher;

public class TeacherLoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = -8052223741830167994L;

	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String teacherId = request.getParameter("teacherId");//从网页传信息。。。request
		String passwords = request.getParameter("passwords");

		System.out.println(teacherId);
		LoginAction login = new LoginAction();
		Teacher teacher = login.teacherLogin(teacherId, passwords);
		
		if (teacher == null)
		{
			try {
				response.sendRedirect("/homework/login_error.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else 
		{
			request.getSession().setAttribute("teacher", teacher);
			//Student s = (Student) request.getSession().getAttribute("student");
			//一个存进Session，一个取出Session

			try {
				response.sendRedirect("/homework/servlet/RefreshTeacherMainPageServlet");
				//response.sendRedirect("/homework/teachermain.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
