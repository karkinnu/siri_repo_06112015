<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>Main</title>
<link href="<c:url value="/resources/styles/common.css" />" rel="stylesheet">
<style>
.error {
	color: #ff0000;
}
</style>

</head>

<body background="<c:url value="/resources/images/siri.jpeg" />">
<div class=main>
<div class="header">
	<h2>Tools</h2>
	</div>

<div class="main1">
	<a class="main_menu" href="<c:url value='/customers/list/' />">Customer Management</a>
	<a class="main_menu" href="<c:url value='/companies/list/' />">Company Management</a>
</div>
<br/>
<br/>
<div class="main2">
	<a class="main_menu" href="<c:url value='/admin' />">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Administrator Tools</a>
	<a class="main_menu" href="<c:url value='/'/>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Logout&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
</div>
</div>
</body>
</html>