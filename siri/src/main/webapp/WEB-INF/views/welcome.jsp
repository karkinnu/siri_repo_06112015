<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>Welcome</title>

<style>
.error {
	color: #ff0000;
}
</style>

</head>

<body>

	<h2>Hieno kuva</h2>

	<br />
	<br />
	<a href="<c:url value='/login' />">Login</a>
	<br/>
</body>
</html>