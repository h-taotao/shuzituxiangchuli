<%@page import="com.dgut.mvc.bean.Student"%>
<%@page import=" java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>listPage</title>
</head>
<body>
<hr>
	查询学生表：<br>
	
	<form action="${pageContext.request.contextPath}/searchStudent.do" method="post">
		姓名：<input type="text" name="studentName"><br>
		学号：<input type="text" name="studentNo"><br>
		班级：<input type="text" name="classNo"><br>
		<input type="submit" value="查询">	
	</form>
<hr>
<table border="1" cellspacing="0" cellspadding="5">
	<tr>
		<td>studentNo</td>
		<td>studentName</td>
		<td>sex</td>
		<td>brithday</td>
		<td>classNo</td>
		<td>email</td>
		<td>UPDATE</td>
		<td>DELETE</td>
	</tr>
	<%
		List<Student> students=(List<Student>)request.getAttribute("students");
		for(Student student:students)
		{
	%>
			<tr>
				<td><%=student.getStudentNo() %></td>
				<td><%=student.getStudentName() %></td>
				<td><%=student.getSex() %></td>
				<td><%=student.getBrithDay() %></td>
				<td><%=student.getClassNo() %></td>
				<td><%=student.getEmail() %></td>
				<td><a href= "edtorStudent.do?id1=<%=student.getStudentNo()%>">update</a></td>
				<td><a href="deleteStudent.do?id=<%=student.getStudentNo()%>">delete</a></td>
			</tr>
	<%  }%>
		add students:<a href="inputStudent.do"> add </a>
</table>
</body>
</html>