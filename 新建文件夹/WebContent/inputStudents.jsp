<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Input Student Page</title>
</head>
<body>
${requestScope.errorMessage}
	<form action="${pageContext.request.contextPath}/addStudent.do" method="get">
		Student name:<input type="text"  name="studentName" value="${ param.studentName}"><br>
		Student no:<input type="text"  name="studentNo" value="${ param.studentNo}"><br>
		Student sex:<input type="text"  name="studentSex" value="${ param.studentSex}"><br>
		Student brithday:<input type="text"  name="studentBrithday" value="${ param.studentBrithday}"><br>
		Student email:<input type="text"  name="studentEmail" value="${ param.studentEmail}"><br>
		Student class:<input type="text"  name="studentClass" value="${ param.studentClass}"><br>
		<input type="submit" value="submit" name="submit">
	</form>
</body>
</html>