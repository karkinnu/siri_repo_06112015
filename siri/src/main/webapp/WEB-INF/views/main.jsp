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

	<h2>CUSTOMER MANAGEMENT PAGE</h2>

	<br/>
	<br/>
	<a href="<c:url value='/customers/list' />">Customers</a>
	<br/>
	<br/>
	<a href="<c:url value='/companies/list/' />">List of Companies</a>
	<br/>
	<br/>
	<a href="<c:url value='/users' />">Admin</a>
	<br/>
	<br/>
	<a href="<c:url value='/'/>">Back</a>
	<br/>
</body>
</html>