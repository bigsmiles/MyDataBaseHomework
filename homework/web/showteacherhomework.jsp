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
		
		<td width="25">分数</td>
		-->
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
		
		<td><%= homeworks.getScore() %></td>
		-->
		<td>
		<!-- 
         <a href="uploadhomework.jsp?homeworkid=<%=homeworks.getHomeworkId()%>&courseid=<%=homeworks.getCourseId()%>&teacherid=<%=homeworks.getTeacherId()%>">上传作业</a>
         -->
		<form action="servlet/UpLoadHomeworkServlet?homeworkid=<%=homeworks.getHomeworkId()%>&<%=request.getQueryString()%>" method="post" enctype="multipart/form-data" name="form2">
                        选择上传文件<input type="file" name="file_to_upload">
                    <input type="" name="havefile" ">
            <br>
              <input type="submit" value="提交">
              <input type="reset" value="重置">

        </form>
		</td>
	</tr>

<%} %>
</table>
<br/>
<form name="form1" action="servlet/AddServlet?<%=request.getQueryString() %>" method="post"> 
<table width="547" border="0" align="center" cellpadding="0" cellspacing="0">
 <tr>
    <td width="172" height="22" align="right">homeworkid:</td>
    <td width="328" height="22"><input name="homeworkid" type="text"  id="homeworkid" maxlength="50" />
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