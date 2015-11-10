<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Customers</title>

</head>
<body>
	<h1>All customers</h1>
	<c:forEach var="asiakas" items="${asiakkaat}">
		<p>${asiakas.nimi} ${asiakas.puhelin} ${asiakas.sahkoposti}</p>
	</c:forEach>

	<p>
		<a href="lomake">Add new customer</a>
</body>
</html>