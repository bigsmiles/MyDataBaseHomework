<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Course"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Student"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Team"  %>
<jsp:useBean id="student" class = "com.bean.homework.Student" scope= "session" ></jsp:useBean>
<jsp:useBean id="myteammemberinfo" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
<jsp:useBean id="myteam" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
<html>
<head>
<title> Login Ok!<%= student.getStudentName()%></title>
</head>
<body>
<p>
Welcome, <%= student.getStudentName()%>
</p>
<table width="95%" align="center" border="1">
	<caption></caption>
	<tr>
		
		<td width="20%">小组成员名</td>
		<td width="40">操作</td>
	</tr>
<% 
	Iterator it = myteammemberinfo.iterator();
	while (it.hasNext())
	{
		Student teams = (Student)it.next();	
%>
	<tr>
		<td><%= teams.getStudentName()%></td>
		<td>
	    <a href = "servlet/DeleteTeamMemberServlet?studentid=<%=teams.getStudentId() %>&<%=request.getQueryString()%>">删除该组员</a>

		</td>
	</tr>

<%} %>
</table>


</body>
</html>