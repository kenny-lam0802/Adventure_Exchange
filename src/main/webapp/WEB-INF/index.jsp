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
	<div class="heading">
		<h1 class = "siteTitle">Adventure Exchange</h1>
		<h5>Turn your imagination into EXPLORATION</h5>
		<p>Our Mission: Provide opportunity for everyone to enjoy the outdoors through equipment sharing at little to no cost!</p>
	</div>
	<p class="loginError"><c:out value="${accessDenied}"/></p>
	<div class="loginForm">
		<h4>Log In</h4>
		<form:form action="/login" method="post" modelAttribute="loginUser">
			<div class="formFields">
				<p><form:errors path="email" class="validation"></form:errors></p>				
				<form:label path="email">Email:</form:label>
				<form:input path="email"></form:input>
			</div>
			<div class="formFields">
				<p><form:errors path="password" class="validation"></form:errors></p>				
				<form:label path="password">Password:</form:label>				<form:input type= "password" path="password"></form:input>
			</div>
				<button class="loginBtn">Login</button>
		</form:form>
	</div>
	<p class="registerLink"><a href="/register">Create an account</a></p>
	
</body>
</html>

