<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Course"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Student"  %>
<jsp:useBean id="student" class = "com.bean.homework.Student" scope= "session" ></jsp:useBean>
<jsp:useBean id="stillcourse" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
<html>
<head>
<title> Login Ok!<%= student.getStudentName()%></title>
</head>
<body>
<p>
Wellcome, <%= student.getStudentName()%>
</p>
<table width="95%" align="center" border="1">
	<caption></caption>
	<tr>
		<td width="10%">课程号</td>
		<td width="25%">课程名</td>
		<td width="25%">课程老师号</td>
		<td width="25%">课程老师名字</td>
		<td width="25">操作</td>
	</tr>
<% 
	Iterator it = stillcourse.iterator();
	while (it.hasNext())
	{
		Course courses = (Course)it.next();		
%>
	<tr>
		<td><%= courses.getCourseId() %></td>
		<td><%= courses.getCourseName() %></td>
		<td><%= courses.getTeacherId() %></td>
		<td><%= courses.getTeacherName() %></td>
		<td>
		   <a href = "servlet/RegisterCourseServlet?courseid=<%=courses.getCourseId()%>&teacherid=<%=courses.getTeacherId()%>">注册该课程</a>
		</td>
	</tr>

<%} %>
</table>
<br/>
<p align="center">
</p>

</body>
</html>