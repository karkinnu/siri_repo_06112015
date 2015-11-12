<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>New customer</title>

<style>
.error {
	color: #ff0000;
}
</style>
</head>
<body>
	<h2>New customer</h2>
	<form:form method="POST" modelAttribute="asiakas">
<table>
			<tr>
				<td><label for="nimi">Name: </label></td>
				<td><form:input path="nimi" id="nimi" /></td>
				<td><form:errors path="nimi" cssClass="nimi" /></td>
			</tr>
			<tr>
				<td><label for="puhelin">Phone: </label></td>
				<td><form:input path="puhelin" id="puhelin" /></td>
				<td><form:errors path="puhelin" cssClass="puhelin" /></td>
			</tr>
			<tr>
				<td><label for="sahkoposti">E-mail: </label></td>
				<td><form:input path="sahkoposti" id="sahkoposti" /></td>
				<td><form:errors path="sahkoposti" cssClass="sahkoposti" /></td>
			</tr>
			<tr>
				<td><label for="maa">E-mail: </label></td>
				<td><form:input path="maa" id="maa" /></td>
				<td><form:errors path="maa" cssClass="maa" /></td>
			</tr>
			<tr>
				<td><label for="osoite">Address: </label></td>
				<td><form:input path="osoite" id="osoite" /></td>
				<td><form:errors path="osoite" cssClass="osoite" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="save" /></td>
				<td><input type="button" value="auto fill" /></td>
			</tr>

		</table>
	</form:form>
	<br />
	<br />
	<a href="<c:url value='/customers/list' />">All customers</a>
</body>
</html>