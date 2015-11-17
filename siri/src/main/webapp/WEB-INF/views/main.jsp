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
	<a href="<c:url value='/customers/list/' />"><button class="main_menu" type= button>Customer Management</button></a>
		<a href="<c:url value='/companies/list/' />"><button class="main_menu" type= button>Company Management</button></a>
</div>
<br/>
<br/>
<div class="main2">
	<a href="<c:url value='/admin' />"><button class="main_menu" type= button>Administrator Tools</button></a>
	<a href="<c:url value='/' />"><button class="main_menu" type= button>Logout</button></a>
</div>
</div>
</body>
</html>