<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Teacher"  %>
<jsp:useBean id="teacher" class = "com.bean.homework.Teacher" scope= "session" ></jsp:useBean>
<jsp:useBean id="mystudent" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
<html>
<head>
<title> Login Ok!<%= teacher.getTeacherName()%></title>
</head>
<body>
<%if (teacher.getTeacherId() == null){ %>
您尚未登陆，请返回<a href="index.html">登录</a>
<%}else{ %>
<p>
Wellcome, <%= teacher.getTeacherName()%>
</p>
<table width="95%" align="center" border="1">
	<caption>个人主页</caption>
	<tr>
		<td width="10%">职工号</td>
		<td width="25%">姓名</td>
		<td width="15%">性别</td>
		<td width="10%">邮箱</td>
		<td width="5%">专业领域</td>
	</tr>
	<tr>
		<td><%= teacher.getTeacherId() %></td>
		
		<td><%= teacher.getTeacherName() %></td>
		<td><%= teacher.getTeacherGender() %></td>
		<td><%= teacher.getMail() %></td>
		<td><%= teacher.getDomain() %></td>
		
	</tr>
</table>
<tr>
<th height="48" scope="row"><a href="teacherregistercourse.jsp">注册课程</a></th>
<th height="48" scope="row"><a href="showteachercourse.jsp">我的课程</a></th>
<th height="48" scope="row"><a href="1.jsp">我的学生</a></th>
<th height="48" scope="row"><a href="showandchangeteacherinfo.jsp">个人信息修改</a></th>
<th height="48" scope="row"><a href = "servlet/ExitServlet" >退出</a></th>

</tr>
<br/>
<p align="center">
</p>
<%} %>
</body>
</html>