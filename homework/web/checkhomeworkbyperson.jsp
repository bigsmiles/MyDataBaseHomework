<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Course"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Teacher"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.StudentHomework"  %>
<jsp:useBean id="teacher" class = "com.bean.homework.Teacher" scope= "session" ></jsp:useBean>
<jsp:useBean id="homeworkbyperson" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
<html>
<head>
<title> Login Ok!<%= teacher.getTeacherName()%></title>
</head>
<body>
<p>
Welcome, <%= teacher.getTeacherName()%>
</p>
<table width="95%" align="center" border="1">
	<caption></caption>
	<tr>
		<td width="10%">学生号</td>
		<td width="25%">学生名</td>
		<td width="25%">提交日期</td>
	</tr>
<% 
	Iterator it = homeworkbyperson.iterator();
	while (it.hasNext())
	{
		StudentHomework homeworkperson = (StudentHomework)it.next();		
%>
	<tr>
		<td><%= homeworkperson.getStudentId() %></td>
		<td><%= homeworkperson.getStudentName() %></td>
		<td><%= homeworkperson.getSubmitDate() %></td>
		
		<!-- 
		<td>
		   <a href = "servlet/Servlet?">删除课程</a>
		</td>
		<td>
		    <a href = "servlet/Servlet">查看作业</a>
		</td>
		-->
	</tr>

<%} %>
</table>
<br/>
<p align="center">
</p>

</body>
</html>