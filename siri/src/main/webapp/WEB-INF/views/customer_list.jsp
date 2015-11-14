<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer</title>

</head>
<body>
	<h1>Customer Management</h1>

   	<div>
		<a href="add">Add new customer</a>
		<br/>
		<a href="<c:url value='/main'/>">Back</a>
	</div>
	<br/>

	<form method="get">
    <table width="100%">
		<tr>
		<th style="text-align: left">Id</th>
		<th style="text-align: left">Name</th>
		<th style="text-align: left">Phone</th>
		<th style="text-align: left">Address</th>
		<th style="text-align: left">Email</th>
		<th style="text-align: left">Country</th>
		<th style="text-align: left">Edit</th>
		<th style="text-align: left">Delete</th>
		</tr>
		<c:forEach var="asiakas" items="${asiakkaat}">
	    	<tr>
				<td style="text-align: left">${asiakas.asiakasId}</td>
				<td style="text-align: left">${asiakas.nimi}</td>
				<td style="text-align: left">${asiakas.puhelin}</td>
 				<td style="text-align: left">${asiakas.osoite}</td>
 				<td style="text-align: left">${asiakas.sahkoposti}</td>
 				<td style="text-align: left">${asiakas.maa}</td>
            	<td>
                	<a href="<c:url value="edit?id=${asiakas.asiakasId}" />">Edit</a>
            	</td>
            	<td>
		            <a href="<c:url value="delete?id=${asiakas.asiakasId}" />">Delete</a>
            	</td>
            </tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>