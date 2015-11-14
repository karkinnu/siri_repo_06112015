<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Login</title>
 <link href="<c:url value="/resources/styles/common.css" />" rel="stylesheet">
</head>

<body>
<div class=login>
	<h1>Login</h1>
	<form:form method="POST" modelAttribute="user">
		<table>
			<tr>
				<td><label for="username">USERNAME: </label></td>
				<td><form:input path="username" id="username" /></td>
				<td><form:errors path="username" cssClass="username" /></td>
			</tr>
			<tr>
			    <td><label for="password">PASSWORD: </label></td>             
				<td><form:input type="password" path="password" id="password" /></td>  
				<td><form:errors path="password" cssClass="assword" /></td>  
			</tr>
			<tr> 
				<td><input type="submit" value="login"  /></td>
			</tr>

		</table>
	</form:form>
	<br/>
	<a href="<c:url value='/main' />">Main Page</a>
	<br/>
	<br/>
	<a href="<c:url value='/' />">Back</a>
</div>
</body>
</html>	
