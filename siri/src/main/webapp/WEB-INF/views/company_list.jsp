<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<title>Company</title>
<link href="<c:url value="/resources/styles/common.css" />" rel="stylesheet">
</head>
<body>
Logged as user : ${sessionScope.user}
	<h1>Company Management</h1>

   	<div>
   	<table>
	<tr><a href="<c:url value='add' />"><button class="siri_menu" type= button>Add new company</button></a></tr>
	<tr><a href="<c:url value='/main' />"><button class="siri_menu" type= button>Back</button></a></tr>
	<tr><a href="<c:url value='/' />"><button class="siri_menu" type= button>Logout</button></a></tr>
	</table>
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
		<c:forEach var="company" items="${companies}">
	    	<tr>
				<td style="text-align: left">${company.yritysId}</td>
				<td style="text-align: left">${company.nimi}</td>
				<td style="text-align: left">${company.puhelin}</td>
 				<td style="text-align: left">${company.osoite}</td>
 				<td style="text-align: left">${company.nettisivu}</td>
 				<td style="text-align: left">${company.ytunnus}</td>
            	<td>
                	<a href="<c:url value="edit?id=${company.yritysId}" />"><button class="menu" type= button>Edit</button></a>
            	</td>
            	<td>
		            <a href="<c:url value="delete?id=${company.yritysId}" />"><button class="menu" type= button>Delete</button></a>
            	</td>
            </tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>