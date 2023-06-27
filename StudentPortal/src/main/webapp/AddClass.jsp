<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Classes</title>
</head>
<body>
<form action="./addClass?action=add" method="post">
		Class<input type="text" name="className"><br>
		Subject<input type="text" name="Subject"><br>
		Teacher<input type="text" name="Teacher"><br>
		<input type="submit" value="Submit">
	</form>
	
	<form action="./addClass?action=delete" method="post">
		Subject Name<input type="text" name="name1"></br>
		<input type="submit" value="Delete">
	</form>
</body>
</html>