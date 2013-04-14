<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Course"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Student"  %>
<jsp:useBean id="student" class = "com.bean.homework.Student" scope= "session" ></jsp:useBean>
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
		<td width="10%">学号号</td>
		<td width="25%">姓名</td>
		<td width="25%">性别</td>
		<td width="25%">年级</td>
		<td width="25">班级</td>
		<td width="25">专业</td>
		<td width="25">邮箱</td>
	</tr>
<% 
		Student students = (Student)request.getSession().getAttribute("student");;		
%>
	<tr>
		<td><%= students.getStudentId() %></td>
		
		<td><%= students.getStudentName() %></td>
		<td><%= students.getStudentGender() %></td>
		<td><%= students.getGrade() %></td>
		<td><%= students.getClasses() %></td>
		<td><%= students.getStudentSdept() %></td>
		<td><%= students.getMail() %></td>
		
	</tr>
</table>
<br/>
<form name="form1" action="servlet/UpdateStudentServlet" method="post">  
<table width="547" border="0" align="center" cellpadding="0" cellspacing="0">
  修改个人信息
  <!-- 
  <tr>
    <td width="172" height="22" align="right">Username:</td>
    <td width="328" height="22"><input name="StudentId" type="text"  id="StudentId" maxlength="50" />
  </tr>
  <tr>
    <td height="22" align="right">Name:</td>
    <td height="22"><input name="Name" type="text" id="Name" size="30" maxlength="50" /></td>
  </tr>
  -->
  <tr>
    <td height="22" align="right">Gender:</td>
    <td height="22"><select name="Gender" id="Gender">
      <option value="0">男</option>
      <option value="1">女</option>
    </select>    </td>
  </tr>
  <tr>
    <td height="22" align="right">Password:</td>
    <td height="22"><input name="Password" type="password"  id="Password" maxlength="50" /></td>
  </tr>
  <tr>
    <td height="22" align="right">Grade:</td>
    <td height="22"><input name="Grade" type="text" id="Grade" size="30" maxlength="50" /></td>
  </tr>
  <tr>
    <td height="22" align="right">Classes:</td>
    <td height="22"><input name="Classes" type="text" id="Classes" size="30" maxlength="50" /></td>
  </tr>
  <tr>
    <td height="22" align="right">StudentSdept:</td>
    <td height="22"><input name="StudentSdept" type="text" id="StudentSdept" size="30" maxlength="50" /></td>
  </tr>
  <tr>
    <td height="22" align="right">Mail:</td>
    <td height="22"><input name="Mail" type="text" id="Mail" size="30" maxlength="50" /></td>
  </tr>
  
        <tr>
			<td><input type="submit" value="提交"></td>
			<td><input type="reset" value="重置"></td>
		</tr>
  

</table>  
</form>
<p align="center">
</p>

</body>
</html>