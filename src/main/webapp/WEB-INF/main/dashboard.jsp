<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div
			class="collapse navbar-collapse col-7 d-flex justify-content-between"
			id="navbarSupportedContent">
			<c:if test="${user_id !=null}">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						href="/build/create">Create a Build</a></li>
				</ul>
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						href="/user/logout">Logout</a></li>
				</ul>
			</c:if>
			<c:if test="${user_id == null }">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active" href="/user">Register
							/ Login</a></li>
				</ul>
			</c:if>
		</div>
	</div>
	<div class="container">
		<c:if test="${user_id != null }">
			<h1 class="mt-3 text-center">
				Welcome
				<c:out value="${loggedInUser.userName }" />
			</h1>
		</c:if>
		<h1></h1>
		<h4 class="mt-3">Check out the builds below!</h4>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Build Name</th>
					<th>Hero</th>
					<th>Description</th>
					<th>Author</th>
					<th>Votes</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="build" items="${allBuilds }">
					<tr>
						<td><a href="/build/${build.id}"><c:out
									value="${build.name }" /></a></td>
						<td><c:out value="${build.hero }" /></td>
						<td><c:out value="${build.description }" /></td>
						<td><c:out value="${build.user.userName }" /></td>
						<td><c:out value="${build.votes }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>