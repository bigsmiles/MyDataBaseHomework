<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Course"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Student"  %>
<%@ page language="java" import="java.util.Iterator, com.bean.homework.Homework"  %>
<jsp:useBean id="student" class = "com.bean.homework.Student" scope= "session" ></jsp:useBean>
<jsp:useBean id="mycourse" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
<jsp:useBean id="myhomework" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
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
	Iterator it = myhomework.iterator();
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
		   
		   <a href = "servlet/DownLoadHomeworkServlet?flag=0homeworkfilename=<%=homeworks.getHomeworkFilename()%>">下载作业</a>
		   <br>
	       <form action="servlet/UpLoadHomeworkByPersonServlet?flag=<%=0%>&homeworkid=<%=homeworks.getHomeworkId()%>
	               &<%=request.getQueryString()%>" method="post" enctype="multipart/form-data" name="form2" >
                                 个人提交作业<br>                    
                                  选择上传文件<input type="file" name="file_to_upload">
                    <input type="hidden" name="havefile" ">
            <br>
              <input type="submit" value="提交">
              <input type="reset" value="重置">
        </form>
        <br>
        
         <form action="servlet/UpLoadHomeworkByPersonServlet?flag=1&homeworkid=<%=homeworks.getHomeworkId()%>
	               &<%=request.getQueryString()%>" method="post" enctype="multipart/form-data" name="form3" >
                                 小组提交作业<br>                    
                                  选择上传文件<input type="file" name="file_to_upload">
                    <input type="hidden" name="havefile" ">
            <br>
              <input type="submit" value="提交">
              <input type="reset" value="重置">

        </form>	
	</td>
		
	</tr>

<%} %>
</table>
<br/>
<p align="center">
</p>

</body>
</html>