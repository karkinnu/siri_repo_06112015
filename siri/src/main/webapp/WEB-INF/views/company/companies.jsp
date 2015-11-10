<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Companies</title>

</head>
<body>
	<h1>Companies</h1>
	<c:forEach var="company" items="${companies}">
		<p>${company.nimi} ${company.puhelin}</p>
	</c:forEach>

	<p>
		<a href="form">New company</a>
</body>
</html>