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
	<h1 class="registerHeader">Begin your adventure today!</h1>
	<div class="registerForm">
		<h5>Create Your Account</h5>
		<form:form action="/registration/process"></form:form><form:form action="/registration/process" method="post" modelAttribute="newUser">
			<div class="formFields">
				<p><form:errors path="firstName" class="validation"></form:errors></p>				
				<form:label path="firstName">First Name:</form:label>
				<form:input path="firstName"></form:input>
			</div>
			<div class="formFields">
				<p><form:errors path="lastName" class="validation"></form:errors></p>				
				<form:label path="lastName">Last Name:</form:label>
				<form:input path="lastName"></form:input>
			</div>
			<div class="formFields">
				<p><form:errors path="email" class="validation"></form:errors></p>				
				<form:label path="email">Email:</form:label>
				<form:input path="email"></form:input>
			</div>
			<div class="formFields">
				<p><form:errors path="password" class="validation"></form:errors></p>				
				<form:label path="password">Password:</form:label>
				<form:input type="password" path="password"></form:input>
			</div>
			<div class="formFields">
				<p><form:errors path="confirm" class="validation"></form:errors></p>				
				<form:label path="confirm">Confirm Password:</form:label>
				<form:input  type="password" path="confirm"></form:input>
			</div>
			<button class="registerBtn">Create</button>
		</form:form>
	</div>
	<p  class="registerLink"><a href="/">Already a member? Click to login</a></p>
</html>

