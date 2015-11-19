<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<title>User</title>
</head>
<body>
	<h1>User Management</h1>

   	<div>
		<a href="<c:url value='add' />"><button type= button>Add new user</button></a>
		<br/>
		<a href="<c:url value='/admin' />"><button type= button>Back</button></a>
	</div>
	<br/>

	<form method="get">
    <table width="100%">
		<tr>
		<th style="text-align: left">Id</th>
		<th style="text-align: left">Name</th>
		<!-- <th style="text-align: left">Password</th>-->
		<th style="text-align: left">Enabled</th>
		<th style="text-align: left">Admin</th>
		<th style="text-align: left">User</th>
		<th style="text-align: left">DbAdmin</th>
		<th style="text-align: left">Edit</th>
		<th style="text-align: left">Delete</th>
		</tr>
		<c:forEach var="kayttaja" items="${kayttajat}">
	    	<tr>
				<td style="text-align: left">${kayttaja.userId}</td>
				<td style="text-align: left">${kayttaja.username}</td>
				<!-- <td style="text-align: left">${kayttaja.password}</td>-->
				<td style="text-align: left">${kayttaja.enabled}</td> 
				<td style="text-align: left">${kayttaja.role_admin}</td>
				<td style="text-align: left">${kayttaja.role_user}</td>
				<td style="text-align: left">${kayttaja.role_dbadmin}</td>
            	<td>
                	<a href="<c:url value="edit?id=${kayttaja.userId}" />">Edit</a>
            	</td>
            	<td>
		            <a href="<c:url value="delete?id=${kayttaja.userId}" />">Delete</a>
            	</td>
            </tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>