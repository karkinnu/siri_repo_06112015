<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>Edit Customer</title>

<style>
.error {
	color: #ff0000;
}
</style>

<script>
</script>

</head>

<body>
Logged as user : ${sessionScope.user}
	<h2>Edit Customer Data</h2>
	
	<form:form method="POST" modelAttribute="asiakas" enctype="multipart/form-data" >
		<img src="/siri/myImage/imageDisplay?id=${asiakas.asiakasId}" width="100" height="100"/>
		File to upload: <input type="file" name="valokuvafile"><br/>
		<table>
			<tr>
				<td><form:input type="hidden" path="asiakasId" id="asiakasId" /></td>
			</tr>
			<tr>
				<td><label for="nimi">Name: </label></td>
				<td><form:input path="nimi" id="nimi" /></td>
				<td><form:errors path="nimi" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="puhelin">Phone: </label></td>
				<td><form:input path="puhelin" id="puhelin" /></td>
				<td><form:errors path="puhelin" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="sahkoposti">Email: </label></td>
				<td><form:input path="sahkoposti" id="sahkoposti" /></td>
				<td><form:errors path="sahkoposti" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="maa">Country: </label></td>
				<td><form:input path="maa" id="maa" /></td>
				<td><form:errors path="maa" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="osoite">Address: </label></td>
				<td><form:input path="osoite" id="osoite" /></td>
				<td><form:errors path="osoite" cssClass="error" /></td>
			</tr>
		</table>
		<br/>
		<input type="submit" value="save" />
		<br/>
		<br/>
		<a class="button" href="<c:url value='/customers/list/' />">Back</a>
	</form:form>
</body>
</html>