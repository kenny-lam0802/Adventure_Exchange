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
<body>
	<div class="viewPage">
		<h1 class="itemInfo"><c:out value="${equipment.item}"/></h1>
		<h4 class="itemInfo">Owner: <c:out value= "${equipment.user.firstName } ${equipment.user.lastName }"/></h4>
		<h4 class="itemInfo">Category: <c:out value="${equipment.category }"/></h4>
		<h4 class="itemInfo">Cost: $<c:out value="${equipment.cost }"/> /day</h4>
	</div>
	<div class="viewLinks">
		<a href="/adventure">Return to view all available items</a>
		<a href="/dashboard">Return to my dashboard</a>
		<a href="/logout">Sign Out</a>
		</div>	
	</div>
</body>
</html>

