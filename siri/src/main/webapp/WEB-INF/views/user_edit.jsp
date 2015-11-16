<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>User</title>

<style>
.error {
	color: #ff0000;
}
</style>

<script>
</script>

</head>

<body>
	<h2>Edit User Data</h2>

	<form:form method="POST" modelAttribute="user">

		<table>
			<tr>
				<td><form:input type="hidden" path="userId" id="userId" /></td>
				<td><form:input type="hidden" path="password" id="password" /></td>
			</tr>
			<tr>
				<td><label for="username">Name: </label></td>
				<td><form:input type="text" path="username" id="username" /></td>
				<td><form:errors path="username" cssClass="username" /></td>
			</tr>
			<tr>
				<td><label for="newPassword">New Password: </label></td>
				<td><form:input type="password" path="newPassword" id="newpassword" /></td>
				<td><form:errors path="newPassword" cssClass="newPassword" /></td>
			</tr>
			<tr>
				<td><label for="enabled">Enabled: </label></td>
				<td><form:checkbox path="enabled" id="enabled" /></td>
				<td><form:errors path="enabled" cssClass="enabled" /></td>
			</tr>
		</table>
		<br/>
		<input type="submit" value="save" />
		<br/>
		<br/>
		<a class="button" href="<c:url value='/users/list/' />">Back</a>
	</form:form>
</body>
</html>