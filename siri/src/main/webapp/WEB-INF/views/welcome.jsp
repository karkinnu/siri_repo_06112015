<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>Welcome</title>

<link rel="stylesheet" href="resources/styles/common.css" type="text/css" />
<link rel="stylesheet" href="resources/styles/form.css" type="text/css" />

</head>

<body>
	<img id=logo src="resources/images/siri.jpeg"/>
	<P class="blocktext">SIRI - Customer Management System</P>
	<br/>
	<br/>
	<a href="<c:url value='/login' />">Login</a>
	<br/>
	<br/>
	<br/>
	Temporary links:
	<br/>
	<a href="<c:url value='/main' />">Customer management</a>
	<br/>
	<a href="<c:url value='/admin' />">Administrator Tools</a>
	<br/>
</body>
</html>