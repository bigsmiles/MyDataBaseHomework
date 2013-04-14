<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Course"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Teacher"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Homework"  %>
<jsp:useBean id="teacher" class = "com.bean.homework.Teacher" scope= "session" ></jsp:useBean>
<jsp:useBean id="teacherhomework" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
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
		<td width="25%">作业号</td>
		<!-- 
		<td width="25">课程名</td>
		<td width="25">教师号</td>
		<td width="25%">提交日期</td>
		-->
		<td width="25">分数</td>
		<td width="25">操作</td>
		
	</tr>
<% 
	Iterator it = teacherhomework.iterator();
	while (it.hasNext())
	{
		Homework homeworks = (Homework)it.next();		
%>
	<tr>
		<td><%= homeworks.getHomeworkId() %></td>
		<!-- 
		<td><%= homeworks.getCourseId() %></td>
		<td><%= homeworks.getTeacherId() %></td>
		
		<td><%= homeworks.getSubmitDate() %></td>
		-->
		<td><%= homeworks.getScore() %></td>
		
		<td>
		   <a href = "servlet/CheckHomeworkByPersonServlet?courseid=<%=homeworks.getCourseId()%>&teacherid=<%=homeworks.getTeacherId()%>&homeworkid=<%=homeworks.getHomeworkId()%>">查看作业提交情况(个人)</a>
		   <a href = "servlet/CheckHomeworkByTeamServlet?courseid=<%=homeworks.getCourseId()%>&teacherid=<%=homeworks.getTeacherId()%>&homeworkid=<%=homeworks.getHomeworkId()%>">查看作业提交情况(小组)</a>
		   
		</td>
		
	</tr>

<%} %>
</table> 
</form>
<p align="center">
</p>

</body>
</html>