package com.controller.homework;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.LoginAction;
import com.bean.homework.Student;

public class LoginServlet extends HttpServlet 
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
		String studentId = request.getParameter("studentId");//从网页传信息。。。request
		String password = request.getParameter("password");

		System.out.println(studentId);
		LoginAction login = new LoginAction();
		Student student = login.studentLogin(studentId, password);
		System.out.println(studentId);
		if (student == null)
		{
			try {
				response.sendRedirect("/homework/login_error.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else 
		{
			request.getSession().setAttribute("student", student);
			//Student s = (Student) request.getSession().getAttribute("student");
			//一个存进Session，一个取出Session

			try {
				response.sendRedirect("/homework/servlet/RefreshMainPageServlet");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
