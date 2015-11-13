<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>Main</title>

<style>
.error {
	color: #ff0000;
}
</style>

</head>

<body>

	<h2>Tools</h2>
	<br/>
	<a href="<c:url value='/customers/list/' />">Customer Management</a>
	<br/>
	<br/>
	<a href="<c:url value='/companies/list/' />">Company Management</a>
	<br/>
	<br/>
	<a href="<c:url value='/admin' />">Administrator Tools</a>
	<br/>
	<br/>
	<br/>
	<a href="<c:url value='/'/>">Logout</a>
</body>
</html>