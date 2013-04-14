<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Course"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Student"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Team"  %>
<jsp:useBean id="student" class = "com.bean.homework.Student" scope= "session" ></jsp:useBean>
<jsp:useBean id="mycourse" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
<jsp:useBean id="myteam" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
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
		<td width="10%">小组号</td>
		<td width="20%">小组名</td>
		<td width="20%">小组课程</td>
		<td width="20%">组长学号</td>
		<td width="20%">组长名字</td>
		<td width="40">操作</td>
	</tr>
<% 
	Iterator it = myteam.iterator();
	while (it.hasNext())
	{
		Team teams = (Team)it.next();	
%>
	<tr>
		<td><%= teams.getTeamId()%></td>
		<td><%= teams.getTeamName() %></td>
		<td><%= teams.getTeamCour() %></td>
		<td><%= teams.getTeamMonitorid() %></td>
		<td><%= teams.getTeamMonitor() %></td>
		<td>
		   <a href = "servlet/DeleteTeamOrMemberServlet?teamid=<%=teams.getTeamId()%>&monitorid=<%=teams.getTeamMonitorid()%>">退出小组(组长将删掉整个小组)</a>
	  
		    <a href = "servlet/ShowTeamAndMemberServlet?flag=0&teamid=<%=teams.getTeamId()%>&monitorid=<%=teams.getTeamMonitor()%>">查看小组</a>
		</td>
	</tr>

<%} %>
</table>

<br/>
<p align="center">
</p>
<form name="form1" action="servlet/StudentAddServlet?flag=0" method="post"> 
<table width="547" border="0" align="center" cellpadding="0" cellspacing="0">
<tr>
    <td width="172" height="22" align="right">teamkid:</td>
    <td width="328" height="22"><input name="teamid" type="text"  id="teamid" maxlength="50" />
    <td width="172" height="22" align="right">teamkname:</td>
    <td width="328" height="22"><input name="teamname" type="text"  id="teamname" maxlength="50" />
    <td width="172" height="22" align="right">课程号:</td>
    <td width="328" height="22"><input name="teamcour" type="text"  id="teamcour" maxlength="50" />
     <td width="172" height="22" align="right">教师号:</td>
    <td width="328" height="22"><input name="teamteacherid" type="text"  id="teamteacherid" maxlength="50" />
    <td width="172" height="22" align="right">组长学号:</td>
    <td width="328" height="22"><input name="teammonitorid" type="text"  id="teammonitorid" maxlength="50" />
    <td width="172" height="22" align="right">组长名字:</td>
    <td width="328" height="22"><input name="teammonitor" type="text"  id="teammonitor" maxlength="50" />
  </tr>
  
  <tr>
			<td><input type="submit" value="提交"></td>
			<td><input type="reset" value="重置"></td>
		</tr>

</table>  
</form>
<form name="form2" action="servlet/StudentAddServlet?flag=1" method="post"> 
<table width="547" border="0" align="center" cellpadding="0" cellspacing="0">
<tr>
   <td width="172" height="22" align="right">加入studentid:</td>
   <td width="328" height="22"><input name="studentid" type="text"  id="studentid" maxlength="50" /></td>
</tr>
<tr>
   <td width="172" height="22" align="right">加入teamid:</td>
   <td width="328" height="22"><input name="myteamid" type="text"  id="myteamid" maxlength="50" /></td>
</tr>
 <tr>
			<td><input type="submit" value="提交"></td>
			<td><input type="reset" value="重置"></td>
		</tr>

</table>  
</form>
</body>
</html>