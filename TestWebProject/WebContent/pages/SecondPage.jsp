<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Second Page</h1>
	<br />
	<br />
	<br /> ${param["username"]}
	<br />
	<%
		session.setAttribute("theName", "2222222222222222222222221111");
	%>
	<br /> ${sessionScope["name"]}
	<br />
	<p><%=session.getAttribute("theName")%></p>
	<p><%=request.getParameter("username")%></p>
	<br />
	<br />
	<hr />
	<table>
	<c:forEach items="${resultList}" var="element">
		<tr>
			<td>${element.username}</td>
			<td>${element.fullname}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>