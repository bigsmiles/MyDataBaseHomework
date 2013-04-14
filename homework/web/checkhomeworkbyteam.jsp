<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Course"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Teacher"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.TeamHomework"  %>
<jsp:useBean id="teacher" class = "com.bean.homework.Teacher" scope= "session" ></jsp:useBean>
<jsp:useBean id="homeworkbyteam" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
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
		<td width="10%">小组号</td>
		<td width="25%">小组名</td>
		<td width="25%">组长</td>
		<td width="25%">提交日期</td>
		<td width="25%">小组成员</td>
	</tr>
<% 
	Iterator it = homeworkbyteam.iterator();
	while (it.hasNext())
	{
		TeamHomework homeworkteam = (TeamHomework)it.next();		
%>
	<tr>
		<td><%= homeworkteam.getTeamId() %></td>
		<td><%= homeworkteam.getTeamName() %></td>
		<td><%= homeworkteam.getTeamMonitor() %></td>
		<td><%= homeworkteam.getSubmitDate() %></td>
			<td>
	    <a href = "servlet/ShowTeamAndMemberServlet?flag=1&teamid=<%=homeworkteam.getTeamId()%>&monitorid=<%=homeworkteam.getTeamMonitor()%>">查看小组</a>
		</td>	
		
	</tr>

<%} %>
</table>
<br/>
<p align="center">
</p>

</body>
</html>