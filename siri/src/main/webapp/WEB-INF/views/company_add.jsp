<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
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

<script>
function autoFill() {
    document.getElementById("nimi").value = "Company";
    document.getElementById("puhelin").value = "0401234567";
    document.getElementById("osoite").value = "Tikanmaja";
    document.getElementById("nettisivu").value = "www.apple.com";
    document.getElementById("ytunnus").value = "Y-12345";
}
</script>
<title><spring:message code="henk.create.title" /></title>

</head>

<body>
	<h2>Add New Company</h2>

	<form:form method="POST" modelAttribute="company">
		<fieldset>
		<legend><spring:message code="henk.create.legend" /></legend>
		<spring:hasBindErrors name="company">
			<p class="Virheotsikko"><spring:message code="henk.create.errors" />:</p>
			<div class="Virheblokki"><form:errors path="*"/></div>
		</spring:hasBindErrors>
		<table>
			<tr>
				<!--
				<td><label for="nimi">Name: </label></td>
				<td><form:input type="text" path="nimi" id="nimi" />
				<form:errors path="nimi" cssClass="nimi" /></td>
				-->
				<form:label	path="nimi"><spring:message code="henk.create.firstname" /></form:label>
				<form:input path="nimi" cssErrorClass="VirheellinenKentta"/>
				<form:errors path="nimi" cssClass="Virheteksti"/>
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
		<input type="button" value="auto fill" onclick="autoFill()"/>
		<br/>
		<br/>
		<a class="button" href="<c:url value='/companies/list/' />">Back</a>
	</fieldset>
	</form:form>
</body>
</html>