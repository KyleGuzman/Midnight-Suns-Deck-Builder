<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
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
		<h4 class="mt-3">
			<c:out value="${build.name }" />
			by
			<c:out value="${build.user.userName }" />
		</h4>
		<h4 class="mt-3">
			<c:out value="${build.hero }" />
		</h4>
		<div class="d-flex justify-content-between">
			<h4 class="mt-3">
				<c:out value="${build.description }" />
			</h4>
			<h4 class="mt-3">
				<c:out value="${build.votes }" />
				Votes
			</h4>
		</div>
		<div class="d-flex">
			<div class="col-10">
				<table class="table table-bordered table-striped mt-3">
					<thead>
						<tr>
							<th>Ability</th>
							<th>Type</th>
							<th>Description</th>
							<th>Damage</th>
							<th>Heroism</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ability" items="${build.abilities }">
							<tr>
								<td><c:out value="${ability.name }" /></td>
								<td><c:out value="${ability.type }" /></td>
								<td><c:out value="${ability.description }" /></td>
								<td><c:out value="${ability.damage }" /></td>
								<td><c:out value="${ability.heroism }" /></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-2">
				<table class="table table-bordered table-striped mt-3">
					<thead>
						<tr>
							<th>Modification</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="modifier" items="${mods }">
							<tr>
								<td><c:out value="${modifier }" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="d-flex justify-content-between mt-5">
			<c:if test="${user_id !=null }">
				<div class="d-flex gap-3">
				<c:if test="${canVote }">
					<form action="/build/vote/${build.id }" method="post">
						<input type="hidden" name="_method" value="put" />
						<button class="btn btn-success" type="submit">Vote</button>
						<input type="hidden" name="voters" value="${user_id }" />
					</form>
				</c:if>
					<button class="btn btn-primary">Comment</button>
				</div>
			</c:if>
			<c:if test="${user_id == build.user.id }">
				<div class="d-flex gap-3">
					<button class="btn btn-primary">Edit</button>
					<button class="btn btn-danger">Delete</button>
				</div>
			</c:if>
		</div>
		<div class="container mt-3">
			<h5 class="text-primary">Comments</h5>
		</div>
	</div>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>