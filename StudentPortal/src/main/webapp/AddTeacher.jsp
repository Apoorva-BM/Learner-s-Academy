<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teachers</title>
</head>
<body>
	<form action="./addTeacher?action=add" method="post">
		Name:<input type="text" name="name"><br>
		Qualification:<select name="qual">
			<option value="btech">Btech</option>
			<option value="mtech">Mtech</option>
		</select>
		<input type="submit" value="Submit">
	</form>
	
	<form action="./addTeacher?action=delete" method="post">
		Teacher Name<input type="text" name="name1"></br>
		<input type="submit" value="Delete">
	</form>
</body>
</html>