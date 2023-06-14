<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/">Home</a>
		</div>
	</div>
	<div class="container p-3">
		<h1 class="mt-3 text-center">Midnight Suns Deck Builder</h1>
		<h4 class="mt-3 text-center">Register or Login to Create your own build! Also
			be able to Vote and Comment on builds from other users!</h4>
		<div class="container d-flex gap-5 mt-5">
			<form:form class="p-3 col-5" action="/user/register" method="post"
				modelAttribute="newUser">
				<h2 class="">Register</h2>
				<div class="form-group d-flex justify-content-between mt-5">
					<label>Username:</label>
					<form:input type="text" path="userName" class="col-8" />
				</div>
				<form:errors path="userName" class="text-danger" />
				<div class="form-group d-flex justify-content-between mt-3">
					<label>Email:</label>
					<form:input type="text" path="email" class="col-8" />
				</div>
				<form:errors path="email" class="text-danger" />
				<div class="form-group d-flex justify-content-between mt-3">
					<label>Password:</label>
					<form:input type="password" path="password" class="col-8" />
				</div>
				<form:errors path="password" class="text-danger" />
				<div class="form-group d-flex justify-content-between mt-3">
					<label>Confirm PW:</label>
					<form:input type="password" path="confirm" class="col-8" />
				</div>
				<form:errors path="confirm" class="text-danger" />
				<div class="d-flex justify-content-end mt-4">
					<input type="submit" value="Submit" />
				</div>
			</form:form>
			<form:form class="form p-3 col-5" action="/user/login" method="post"
				modelAttribute="newLogin">
				<h2 class="">Login</h2>
				<div class="form-group d-flex justify-content-between mt-5">
					<label>Email:</label>
					<form:input type="text" path="email" class="col-8" />
				</div>
				<form:errors path="email" class="text-danger" />
				<div class="form-group d-flex justify-content-between mt-3">
					<label>Password:</label>
					<form:input type="password" path="password" class="col-8" />
				</div>
				<form:errors path="password" class="text-danger" />
				<div class="d-flex justify-content-end mt-4">
					<input type="submit" value="Submit" />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>