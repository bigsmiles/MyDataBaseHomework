<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Teacher"  %>
<jsp:useBean id="teacher" class = "com.bean.homework.Teacher" scope= "session" ></jsp:useBean>
<html>
<head>
<title> Login Ok!<%= teacher.getTeacherName()%></title>
</head>
<body>
<%if (teacher.getTeacherId() == null){ %>
您尚未登陆，请返回<a href="index.html">登录</a>
<%}else{ %>
<p>
Welcome, <%= teacher.getTeacherName()%>
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
<br/>
<body>
<form name="form1" action="servlet/UpdateTeacherServlet" method="post">  
<table width="547" border="0" align="center" cellpadding="0" cellspacing="0">
<!-- 
  <tr>
    <td width="172" height="22" align="right">职工号:</td>
    <td width="328" height="22"><input name="TeacherId" type="text"  id="TeacherId" maxlength="50" />
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
    <td height="22" align="right">专业方向:</td>
    <td height="22"><input name="Domain" type="text" id="Doamin" size="30" maxlength="50" /></td>
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
<%} %>
</body>
</html>