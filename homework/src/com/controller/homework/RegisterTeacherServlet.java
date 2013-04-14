package com.controller.homework;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.homework.RegisterAction;
import com.bean.homework.Student;
import com.bean.homework.Teacher;

public class RegisterTeacherServlet extends HttpServlet 
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
		 Teacher tempTeacher = new  Teacher();
		tempTeacher.setTeacherId(request.getParameter("TeacherId"));//从网页传信息。。。request
		tempTeacher.setTeacherName(request.getParameter("Name"));
		tempTeacher.setTeacherGender(request.getParameter("Gender"));
		tempTeacher.setPassword(request.getParameter("Password"));
		
		tempTeacher.setDomain(request.getParameter("Domain"));
		tempTeacher.setMail(request.getParameter("Mail"));
		
		RegisterAction register = new RegisterAction();
		//Student student = register.studentRegister(tempStudent);
		int flag = register.teacherRegister(tempTeacher);
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
