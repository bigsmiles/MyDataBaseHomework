<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Student"  %>
<jsp:useBean id="myteammemberinfo" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
<html>
<head>
<title> Login Ok!</title>
</head>
<body>
<p>
Welcome
</p>
<table width="95%" align="center" border="0">
	<caption></caption>
	<tr>
		
		<td width="20%">小组成员名</td>
	</tr>
<% 
	Iterator it = myteammemberinfo.iterator();
	while (it.hasNext())
	{
		Student teams = (Student)it.next();	
%>
	<tr>
		<td><%= teams.getStudentName()%></td>
	</tr>

<%} %>
</table>


</body>
</html>