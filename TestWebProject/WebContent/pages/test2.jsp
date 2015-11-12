<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Test Page1</h1>
	<%
		String title = "Accessing Request Param";
	%>
	<h2>
		<%
			out.println(title);
		%>
	</h2>
	<h3>
		<%
			out.println("Your IP address is " + request.getRemoteAddr());
		%>
	</h3>
	<p>${header["user-agent"]}</p>
	<br />
	<br />
	<br />




	<form method="GET" action="../myapp">
		<input type="text" name="username" /><br /> <input type="text"
			name="fullname" /><br /> <input type="password" name="password" /><br />
		<input type="submit" />
	</form>

	<form action="../redirect" method="get">
		<input type="text" name="username" /><br /> <input type="text"
			name="fullname" /><br /> <input type="submit" value="Next" />
	</form>

	<br />
	<br />
	<H3>Register</H3>
	<form action="../redirect" method="post">
		Username:<input type="text" name="username" /><br /> Fullname:<input
			type="text" name="fullname" /><br /> Password:<input
			type="password" name="password" /><br /> <input type="submit"
			value="Register" />
	</form>



	<h2>Servlet for New version</h2>
	<form action="../ServletAboutNewVersion" method="post">
		Username:<input type="text" name="username" /><br /> Fullname:<input
			type="text" name="fullname" /><br /> Password:<input
			type="password" name="password" /><br /> <input type="submit"
			value="Register" />
	</form>


</body>
</html>