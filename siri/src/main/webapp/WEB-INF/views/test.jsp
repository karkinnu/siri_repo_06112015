<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>Test</title>

<link href="<c:url value="/resources/styles/common.css" />" rel="stylesheet">
</head>
<body>
	<img id=logo src="<c:url value="/resources/images/siri.jpeg" />"/>
	<P class="logoText">Test Page</P>
	<br/>
	<br/>
	<a class=loginButton href="<c:url value='/' />">Back</a>
</body>
</html>