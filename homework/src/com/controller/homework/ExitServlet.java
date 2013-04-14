package com.controller.homework;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


  
  public class ExitServlet extends HttpServlet 
  {
  	private static final long serialVersionUID = 6989925835878853594L;

  	public void service(HttpServletRequest request, HttpServletResponse response)
  	{
  		HttpSession session =
  		    request.getSession(false);
  		     session.invalidate();
  		     response.setHeader("Pragma","No-cache");
  		     response.setHeader("Cache-Control","no-cache");
  		     response.setDateHeader("Expires", 0);
  		     
  		  try {
				response.sendRedirect("/homework/index.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		
  	}
  }
