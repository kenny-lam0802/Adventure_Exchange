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
	<div class="dashNav">
		<h1 class="dashHead">Welcome <c:out value="${loggedInUser.firstName}"/>!</h1>
		<p class="logOut"><a href="/logout">Sign Out</a></p>
	</div>
	<div>
		<a href="/adventure">Explore</a> |
		<a href="/adventure/create">Place item to loan</a> | 
		<a href=""> Messages</a> | 
	</div>
	
	<div class="dashContainer">
		<h5>My items to loan:</h5>
		<table class="myItem">
			<tbody>
				<tr>
					<th class="itemHeader">Item</th>
					<th class="itemHeader">Category</th>
					<th class="itemHeader">Date Posted</th>
					<th class="itemHeader">Cost</th>
					<th class="itemHeader">Actions</th>
				</tr>
				<c:forEach var="equipment" items="${equipment}">
					<tr>
						<c:choose>
						<c:when test="${equipment.user.id == currentUser}">
							<td class="itemData">
								<a href="/adventure/${equipment.id}/view"><c:out value="${equipment.item}"/></a>
							</td>
							<td class="itemData">
								<c:out value="${equipment.category}"/>
							</td>
							<td class="itemData">
								<c:out value="${equipment.createdAt}"/>
							</td>
							<td class="itemData">
								$<c:out value="${equipment.cost}"/> /day
							</td>
							<td class="itemData">
								<a href= "adventure/${equipment.id}/edit">Edit |</a>
								<a href="/adventure/delete/${equipment.id}">Delete</a>
							</td>
						</c:when>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>

