<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Course"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Teacher"  %>
<jsp:useBean id="teacher" class = "com.bean.homework.Teacher" scope= "session" ></jsp:useBean>
<jsp:useBean id="teachercourse" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
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
		<td width="10%">课程号</td>
		<td width="25%">课程名</td>
		<td width="25%">课程老师号</td>
		<td width="25%">课程老师名字</td>
		<td width="25">操作</td>
	</tr>
<% 
	Iterator it = teachercourse.iterator();
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
		  
		   <a href = "servlet/ShowStudentOnCourseServlet?courseid=<%=courses.getCourseId()%>&teacherid=<%=courses.getTeacherId()%>">查看该课程选课情况</a>
		  <br/>
		   <a href = "servlet/DeleteTeacherCourseServlet?courseid=<%=courses.getCourseId()%>&teacherid=<%=courses.getTeacherId()%>">删除该课程</a>
		 <br/>
		   <a href = "servlet/ShowTeacherHomeworkServlet?courseid=<%=courses.getCourseId()%>&teacherid=<%=courses.getTeacherId()%>">布置该课程作业</a>
		<br/>
		   <a href = "servlet/CheckHomeworkServlet?courseid=<%=courses.getCourseId()%>&teacherid=<%=courses.getTeacherId()%>">查看该课程作业提交情况</a>
		</td>
	</tr>

<%} %>
</table>
<br/>
<p align="center">
</p>

</body>
</html>