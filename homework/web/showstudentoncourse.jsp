<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Course"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Teacher"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Student"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Homework"  %>
<jsp:useBean id="teacher" class = "com.bean.homework.Teacher" scope= "session" ></jsp:useBean>
<jsp:useBean id="studentoncourse" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
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
		<td width="25%">学号号</td>
		
		<td width="25">姓名</td>
		
	</tr>
<% 
	Iterator it = studentoncourse.iterator();
	while (it.hasNext())
	{
		Student students = (Student)it.next();		
%>
	<tr>
		<td><%= students.getStudentId() %></td>
		<td><%= students.getStudentName() %></td>
		
	</tr>

<%} %>
</table>
</form>
<p align="center">
</p>

</body>
</html>