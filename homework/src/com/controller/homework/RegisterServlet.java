package com.controller.homework;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.RegisterAction;
import com.bean.homework.Student;

public class RegisterServlet extends HttpServlet 
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
		 Student tempStudent = new  Student();
		tempStudent.setStudentId(request.getParameter("StudentId"));//从网页传信息。。。request
		tempStudent.setStudentName(request.getParameter("Name"));
		tempStudent.setStudentGender(request.getParameter("Gender"));
		tempStudent.setPassword(request.getParameter("Password"));
		tempStudent.setGrade(request.getParameter("Grade"));
		tempStudent.setClasses(request.getParameter("Classes"));
		tempStudent.setStudentSdept(request.getParameter("StudentSdept"));
		tempStudent.setMail(request.getParameter("Mail"));
		
		RegisterAction register = new RegisterAction();
		//Student student = register.studentRegister(tempStudent);
		int flag = register.studentRegister(tempStudent);
         System.out.println(tempStudent.getStudentId()+" ID");
		if (flag==0)
		{
			try {
				//System.out.println(tempStudent.getStudentId()+" No");
				response.sendRedirect("/homework/login_error.html");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else 
		{
			//request.getSession().setAttribute("student", student);
			//Student s = (Student) request.getSession().getAttribute("student");
			//一个存进Session，一个取出Session

			try {
				//response.sendRedirect("/homework/servlet/RefreshMainPageServlet");
				//System.out.println(tempStudent.getStudentId()+" YES");
				response.sendRedirect("/homework/index.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
