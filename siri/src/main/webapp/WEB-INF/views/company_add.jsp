<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title>New Company</title>

<style>
.error {
	color: #ff0000;
}
</style>

<script src="<c:url value="/resources/js/company.js" />"></script>

<link href="<c:url value="/resources/styles/common.css" />" rel="stylesheet">

</head>

<body>
Logged as user : ${sessionScope.user}
	<h2>Add New Company</h2>

	<form:form method="POST" modelAttribute="yritys">
		<table>
			<tr>
				<td><label for="nimi">Name: </label></td>
				<td><form:input type="text" path="nimi" id="nimi" />
				<td><form:errors path="nimi" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="puhelin">Phone: </label></td>
				<td><form:input path="puhelin" id="puhelin" /></td>
				<td><form:errors path="puhelin" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="osoite">Address: </label></td>
				<td><form:input path="osoite" id="osoite" /></td>
				<td><form:errors path="osoite" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="nettisivu">Website: </label></td>
				<td><form:input path="nettisivu" id="nettisivu" /></td>
				<td><form:errors path="nettisivu" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="ytunnus">VAT number: </label></td>
				<td><form:input path="ytunnus" id="ytunnus" /></td>
				<td><form:errors path="ytunnus" cssClass="error" /></td>
			</tr>
		</table>
		<br/>
		<input type="submit" value="save" />
		<input type="button" value="auto fill" onclick="autoFill()"/>
		<br/>
		<br/>
		<a class="button" href="<c:url value='/companies/list/' />">Back</a>
	</form:form>
</body>
</html>