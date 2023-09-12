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
	<div class="editContainer">
		<h1>Edit this Item</h1>
		<form:form action="/adventure/${editGear.id}/edit" method="put" modelAttribute="editGear" class="editForm">
			<form:input type="hidden" value="${loggedInUser.id}" path="user"/>
				<div class="editInput">
					<p><form:errors path="item" class="validation"></form:errors></p>
					<form:label path="item">Item:</form:label>
					<form:input path="item"/>
				</div>
				<div class="editInput">
					<p><form:errors path="category" class="validation"></form:errors></p>
					<form:label path="category">Category:</form:label>
					<form:select path="category">
						<form:option value="Hiking"></form:option>
						<form:option value="Camping"></form:option>
						<form:option value="Water Sport"></form:option>
						<form:option value="Other"></form:option>
					</form:select>
				</div>
				<div class="editInput">
					<p><form:errors path="cost" class="validation"></form:errors></p>
					<form:label path="cost">Cost:</form:label>
					<p>$<form:input path="cost" type="float"/>/day</p>
				</div>
				<div class="editInput">
					<p><form:errors path="description" class="validation"></form:errors></p>
					<form:label path="description">Description: </form:label>
					<p><form:textarea path="description" rows="4" cols="30"/></p>
				</div>
				<button class="editBtn">Save Changes</button>
			</form:form>
		</div>
		<div class="editLink">
			<a href="/adventure/delete/${editGear.id}" class="deleteBtn">Delete Item</a>
			<a href="/dashboard" class="cancelBtn">Cancel Changes</a>
		</div>
</body>
</html>

