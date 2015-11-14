<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<title>Company</title>
</head>
<body>
	<h1>Company Management</h1>

   	<div>
		<a href="add">Add new company</a>
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
		<th style="text-align: left">Website</th>
		<th style="text-align: left">VAT</th>
		<th style="text-align: left">Edit</th>
		<th style="text-align: left">Delete</th>
		</tr>
		<c:forEach var="yritys" items="${yritykset}">
	    	<tr>
				<td style="text-align: left">${yritys.yritysId}</td>
				<td style="text-align: left">${yritys.nimi}</td>
				<td style="text-align: left">${yritys.puhelin}</td>
 				<td style="text-align: left">${yritys.osoite}</td>
 				<td style="text-align: left">${yritys.nettisivu}</td>
 				<td style="text-align: left">${yritys.ytunnus}</td>
            	<td>
                	<a href="<c:url value="edit?id=${yritys.yritysId}" />">Edit</a>
            	</td>
            	<td>
		            <a href="<c:url value="delete?id=${yritys.yritysId}" />">Delete</a>
            	</td>
            </tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>