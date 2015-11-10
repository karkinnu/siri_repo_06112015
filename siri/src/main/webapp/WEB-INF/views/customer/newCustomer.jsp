<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Lisätyn asiakkaan tiedot</title>

</head>
<body>
	<h1>Uusi asiakas syötetty</h1>

	<p>${asiakas.nimi} ja ${asiakas.puhelin}</p>


	<p>
		<a href="<c:url value='/customers/list' />">Listaa asiakkaat</a>
	</p>
</body>
</html>