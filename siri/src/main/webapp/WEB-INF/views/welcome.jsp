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
	<!-- <img src="file:///home/oppi2/Projekti_workspace/siri_repo_06112015/siri/siri.jpeg"/> -->
	<!-- img src="<c:url value="${siri/src/main/resources/images/siri.jpeg}"/> "/-->
	<h2>SIRI - Customer Management System</h2>
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
	<a href="<c:url value='/admin' />">Administrator</a>
	<br/>
</body>
</html>