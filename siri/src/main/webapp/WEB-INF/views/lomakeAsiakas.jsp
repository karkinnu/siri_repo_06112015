<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>Uusi kone</title>

<style>
.error {
	color: #ff0000;
}
</style>

</head>

<body>

	<h2>Uusi asiakas</h2>

	<form:form method="POST" modelAttribute="asiakas">

		<table>
			<tr>
				<td><label for="nimi">Nimi: </label></td>
				<td><form:input path="nimi" id="nimi" /></td>
				<td><form:errors path="nimi" cssClass="nimi" /></td>
			</tr>
			<tr>
				<td><label for="puhelin">Puhelin: </label></td>
				<td><form:input path="puhelin" id="puhelin" /></td>
				<td><form:errors path="puhelin" cssClass="puhelin" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="uusi"  /></td>
			</tr>

		</table>
	</form:form>
	<br />
	<br />
	<a href="<c:url value='/asiakkaat/listaa' />">Listaa asiakkaat</a>
</body>
</html>