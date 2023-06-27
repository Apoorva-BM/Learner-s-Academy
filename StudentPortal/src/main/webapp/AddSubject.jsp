<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subjects</title>
</head>
<body>
<form action="./addSubject?action=add" method="post">
		Subject Name<input type="text" name="name"></br>
		Marks<input type="text" name="marks"><br>
		Class<input type="text" name="className"><br>
		<input type="submit" value="Submit">
	</form>
	
	<form action="./addSubject?action=delete" method="post">
		Subject Name<input type="text" name="name1"></br>
		<input type="submit" value="Delete">
	</form>
</body>
</html>