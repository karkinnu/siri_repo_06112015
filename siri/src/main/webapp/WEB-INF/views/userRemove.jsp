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
	<h1>Remove user</h1>
	<form:form method="POST" modelAttribute="user">
		<table>
			<tr>
				<td><label for="username">USERNAME: </label></td>
				<td><form:input path="username" id="username" /></td>
				<td><form:errors path="username" cssClass="username" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="remove"  /></td>
			</tr>

		</table>
	</form:form>
	<br />
	<br />
	<a href="<c:url value='//main' />">All customers</a>
</body>
</html>