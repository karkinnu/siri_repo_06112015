<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Asiakkaiden tiedot</title>

</head>
<body>
	<h1>Asiakkaat listattuna JPA-tietokannasta</h1>
	<c:forEach var="asiakas" items="${asiakkaat}">
		<p>${asiakas.nimi} ${asiakas.puhelin}</p>
	</c:forEach>

	<p>
		<a href="lomake">Syötä uusi</a>
</body>
</html>