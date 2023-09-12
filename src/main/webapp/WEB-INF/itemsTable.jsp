<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adventure Exchange</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body class="allItemView">
	<div class="viewAllNav">
		<div class="allHeading">
			<h1 class = "siteTitle">Adventure Exchange</h1>
			<h5>Turn your imagination into EXPLORATION!</h5>
		</div>
		<a href="/logout">Sign Out</a>
	</div>
	<h5> Available Items:</h5>
	<table class="allItems">
		<tbody>
			<tr>
				<th class="allheader">Item</th>
				<th class="allheader">Category</th>
				<th class="allheader">Owner</th>
				<th class="allheader">Cost</th>
				<th class="allheader">Actions</th>
			</tr>
			<c:forEach var="equipment" items="${equipment }">
				<tr>
					<td class="allData">
						<c:out value="${equipment.item }"/>
					</td>
					<td class="allData">
						<c:out value="${equipment.category }"/>
					</td>
					<td class="allData">
						<c:out value="${equipment.user.firstName} ${equipment.user.lastName }"/>
					</td>
					<td class="allData">
						<c:out value="${equipment.cost}"/>
					</td>
					<td class="allData">
						<a href="/adventure/${equipment.id}/view">View |</a>
						<a href="">Request</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/dashboard">Return to my dashboard</a>
	
	
</body>
</html>

