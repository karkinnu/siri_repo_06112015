<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Companies</title>
</head>
<body>

	<h1>List of Companies</h1>

   	<div>
		<a href="form">Add new company</a>
		<br/>
		<a href="<c:url value='/users/login'/>">Back</a>
	</div>
	<br/>
	<br/>


	<form method="get" action="order.jsp">
    <table width="100%">
		<tr>
		<th style="text-align: left">Name</th>
		<th style="text-align: left">Phone</th>
		<th style="text-align: left">Address</th>
		<th style="text-align: left">Website</th>
		<th style="text-align: left">VAT</th>
		<th style="text-align: left">Edit</th>
		<th style="text-align: left">Delete</th>
		</tr>
		<c:forEach var="company" items="${companies}">
	    	<tr>
				<td style="text-align: left">${company.nimi}</td>
				<td style="text-align: left">${company.puhelin}</td>
 				<td style="text-align: left">${company.osoite}</td>
 				<td style="text-align: left">${company.nettisivu}</td>
 				<td style="text-align: left">${company.ytunnus}</td>
            	<td>
                	<a href="<c:url value="edit?id=${company.yritysId}" />">Edit</a>
            	</td>
            	<td>
		            <a href="<c:url value="delete?id=${company.yritysId}" />">Delete</a>
            	</td>
            </tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>