<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.BaseCourse"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Teacher"  %>
<jsp:useBean id="teacher" class = "com.bean.homework.Teacher" scope= "session" ></jsp:useBean>
<jsp:useBean id="teacherstillcourse" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
<html>
<head>
<title> Login Ok!<%= teacher.getTeacherName()%></title>
</head>
<body>
<p>
Wellcome, <%= teacher.getTeacherName()%>
</p>
<table width="95%" align="center" border="1">
	<caption></caption>
	<tr>
		<td width="10%">课程号</td>
		<td width="25%">课程名</td>
		<td width="25%">开课系</td>
		<td width="25">操作</td>
	</tr>
<% 
	Iterator it = teacherstillcourse.iterator();
	while (it.hasNext())
	{
		BaseCourse courses = (BaseCourse)it.next();		
%>
	<tr>
		<td><%= courses.getCourseId() %></td>
		<td><%= courses.getCourseName() %></td>
		<td><%= courses.getCourseSdept() %></td>
		<td>
		   <a href = "servlet/TeacherRegisterCourseServlet?courseid=<%=courses.getCourseId()%>&coursename=<%=courses.getCourseName()%>">注册该课程</a>
		</td>
	</tr>

<%} %>
</table>
<br/>
<p align="center">
</p>

</body>
</html>