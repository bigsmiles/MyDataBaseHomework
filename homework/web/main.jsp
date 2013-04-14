<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Student"  %>
<jsp:useBean id="student" class = "com.bean.homework.Student" scope= "session" ></jsp:useBean>
<jsp:useBean id="mystudent" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
<html>
<head>
<title> Login Ok!<%= student.getStudentName()%></title>
</head>
<body>
<%if (student.getStudentId() == null){ %>
您尚未登陆，请返回<a href="index.html">登录</a>
<%}else{ %>
<p>
Welcome, <%= student.getStudentName()%>
</p>
<table width="95%" align="center" border="1">
	<caption>个人主页</caption>
	<tr>
		<td width="10%">学号</td>
		<td width="25%">姓名</td>
		<td width="15%">性别</td>
		<td width="10%">年级</td>
		<td width="5%">班级</td>
		<td width="5%">专业</td>
		<td width="5%">邮箱</td>
	</tr>
<% 
	Iterator it = mystudent.iterator();
	while (it.hasNext())
	{
		Student students = (Student)it.next();		
%>
	<tr>
		<td><%= students.getStudentId() %></td>
		
		<td><%= students.getStudentName() %></td>
		<td><%= students.getStudentGender() %></td>
		<td><%= students.getGrade() %></td>
		<td><%= students.getClasses() %></td>
		<td><%= students.getStudentSdept() %></td>
		<td><%= students.getMail() %></td>
		
	</tr>

<%
	}
%>

</table>
<tr>
<th height="48" scope="row"><a href="registercourse.jsp">注册课程</a></th>
<th height="48" scope="row"><a href="showcourse.jsp">管理课程和作业</a></th>
<th height="48" scope="row"><a href="showteam.jsp">小组管理</a></th>
<th height="48" scope="row"><a href="showandchangestudentinfo.jsp">个人信息修改</a></th>
<th height="48" scope="row"><a href = "servlet/ExitServlet" >退出</a></th>

</tr>
<br/>
<p align="center">
</p>
<%} %>
</body>
</html>