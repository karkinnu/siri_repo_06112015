<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>New User</title>

<style>
.error {
	color: #ff0000;
}
</style>

<script>
</script>

</head>

<body>
	<h2>Add New User</h2>

	<form:form method="POST" modelAttribute="user">
		<table>
			<tr>
				<td><label for="username">Name: </label></td>
				<td><form:input type="text" path="username" id="username" /></td>
				<td><form:errors path="username" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="password">Password: </label></td>
				<td><form:input type="password" path="password" id="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="enabled">Enabled: </label></td>
				<td><form:checkbox path="enabled" id="enabled" /></td>
				<td><form:errors path="enabled" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="role_admin">Role_admin: </label></td>
				<td><form:checkbox path="role_admin" id="role_admin" /></td>
				<td><form:errors path="role_admin" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="role_user">Role_user: </label></td>
				<td><form:checkbox path="role_user" id="role_user" /></td>
				<td><form:errors path="role_user" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="role_dbadmin">Role_dbadmin: </label></td>
				<td><form:checkbox path="role_dbadmin" id="role_dbadmin" /></td>
				<td><form:errors path="role_dbadmin" cssClass="error" /></td>
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