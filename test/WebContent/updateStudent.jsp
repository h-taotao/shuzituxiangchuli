<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/updateStudent.do" method="get">
		<input type="hidden" name="studentNo" value="${requestScope.update_student.studentNo}" />
		Student name:<input type="text"  name="studentName" value="${requestScope.update_student.studentName}"/><br>
		Student no:<input type="text"  disabled="disabled" name="studentNo" value="${requestScope.update_student.studentNo}"/><br>
		Student sex:<input type="text"  name="studentSex" value="${ requestScope.update_student.sex}"/><br>
		Student brithday:<input type="text"  name="studentBrithday" value="${ requestScope.update_student.brithDay}"/><br>
		Student email:<input type="text"  name="studentEmail" value="${ requestScope.update_student.email}"/><br>
		Student class:<input type="text"  name="studentClass" value="${ requestScope.update_student.classNo}"/><br>
		<input type="submit" value="change">
	</form>
	<a href="listStudent.do">return listpage</a>
</body>
</html>