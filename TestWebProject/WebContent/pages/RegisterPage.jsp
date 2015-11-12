<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Register!</h1>
	<br />
	<br />
	<font color="red">${errorMessage}</font>
	<form action="../RegisterServlet" method="post">
		<span>Username:</span><input type="text" name="username" />
		<br /> 
		<span>Fullname:</span><input type="text" name="fullname" />
		<br />
		<span>Email:</span><input type="text" name="email" />
		<br /> 
		<span>Password:</span><input type="password" name="password" />
		<br />
		<span>Confirm Password:</span><input type="password" name="confirmPassword" />
		<br />
		<input type="submit" value="Register" />
	</form>
</body>
</html>