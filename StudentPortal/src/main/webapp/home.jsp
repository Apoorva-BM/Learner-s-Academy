<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>Hi ,${sessionScope.user.username}   Welcome to Home Page</h1>
	<h2>Developer: Apoorva BM</h2>
	<h3>Developing a Backend Admin for Learners Academy.</h3>
	<a href="AddTeacher.jsp">Add Teacher</a><br>
	<a href="AddStudent.jsp">Add Student</a><br>
	<a href="AddSubject.jsp">Add Subject</a><br>
	<a href="AddClass.jsp">Add Class</a><br>
	<a href="Report.jsp">Class Report</a>
	<h1>${msg}</h1>
</body>
</html>