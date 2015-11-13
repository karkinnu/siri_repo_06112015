<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>Company</title>

<style>
.error {
	color: #ff0000;
}
</style>

<script>
</script>

</head>

<body>
	<h2>Edit Company Data</h2>

	<form:form method="POST" modelAttribute="company">

		<table>
			<tr>
				<td><form:input type="hidden" path="yritysId" id="yritysId" /></td>
			</tr>
			<tr>
				<td><label for="nimi">Name: </label></td>
				<td><form:input type="text" path="nimi" id="nimi" /></td>
				<td><form:errors path="nimi" cssClass="nimi" /></td>
			</tr>
			<tr>
				<td><label for="puhelin">Phone: </label></td>
				<td><form:input path="puhelin" id="puhelin" /></td>
				<td><form:errors path="puhelin" cssClass="puhelin" /></td>
			</tr>
			<tr>
				<td><label for="osoite">Address: </label></td>
				<td><form:input path="osoite" id="osoite" /></td>
				<td><form:errors path="osoite" cssClass="osoite" /></td>
			</tr>
			<tr>
				<td><label for="nettisivu">Website: </label></td>
				<td><form:input path="nettisivu" id="nettisivu" /></td>
				<td><form:errors path="nettisivu" cssClass="nettisivu" /></td>
			</tr>
			<tr>
				<td><label for="ytunnus">VAT number: </label></td>
				<td><form:input path="ytunnus" id="ytunnus" /></td>
				<td><form:errors path="ytunnus" cssClass="ytunnus" /></td>
			</tr>
		</table>
		<br/>
		<input type="submit" value="save" />
		<br/>
		<br/>
		<a class="button" href="<c:url value='/companies/list/' />">Back</a>
	</form:form>
</body>
</html>