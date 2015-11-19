<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>Administrator</title>
<link href="<c:url value="/resources/styles/common.css" />" rel="stylesheet">
<style>
.error {
	color: #ff0000;
}
</style>

</head>

<body>
Logged as user : ${sessionScope.user}
	<h2>Administrator Tools</h2>
	<br />
	<a href="<c:url value='/users/list/' />"><button class="siri_menu" type= button>User Management</button></a>
	<a href="<c:url value='/main' />"><button class="siri_menu" type= button>Back</button></a>
	<a href="<c:url value='/' />"><button class="siri_menu" type= button>Logout</button></a>
</body>
</html>