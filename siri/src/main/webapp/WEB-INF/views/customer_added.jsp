<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>New customer added</title>

</head>
<body>
	<h1>New customer added</h1>

	<p>${asiakas.nimi} ${asiakas.puhelin} ${asiakas.sahkoposti} ${asiakas.osoite} ${asiakas.maa}</p>
	<p>
		<a href="<c:url value='/customers/list' />">All customers</a>
	</p>
</body>
</html>