<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students</title>
</head>
<body>
	<form action="./addStudent?action=add" method="post">
		StudentName<input type="text" name="name"></br>
		Address<input type="text" name="address"><br>
		<input type="submit" value="Submit">
	</form>
	
	<form action="./addStudent?action=delete" method="post">
		StudentName<input type="text" name="name1"></br>
		<input type="submit" value="Delete">
	</form>
</body>
</html>l>