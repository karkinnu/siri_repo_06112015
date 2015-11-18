<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Customer</title>
<link href="<c:url value="/resources/styles/common.css" />" rel="stylesheet">
</head>
<body>
	<h1>Customer Management</h1>

   	<div>
		<a href="<c:url value='add'/>"><button class="siri_menu" type= button>Add new customer</button></a>
		<br/>
		<br/>
		<a href="<c:url value='/main'/>"><button class="siri_menu" type= button>Back</button></a>
		<br/>
		<br/>
		<a href="<c:url value='/' />"><button class="siri_menu" type= button>Logout</button></a>
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
		<th style="text-align: left">Picture</th>
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
 				<td><img src="/siri/myImage/imageDisplay?id=${asiakas.asiakasId}"/></td>
            	<td>
                	<a href="<c:url value="edit?id=${asiakas.asiakasId}" />"><button class="main_edit" type= button>Edit</button></a>
            	</td>
            	<td>
		            <a href="<c:url value="delete?id=${asiakas.asiakasId}" />"><button class="main_edit" type= button>Delete</button></a>
            	</td>
            </tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>