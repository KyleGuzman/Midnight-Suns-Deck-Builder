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
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
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
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active"
					href="/user/logout">Logout</a></li>
			</ul>
		</div>
	</div>
	<div class="container text-center">
		<h4 class="mt-3">Create a New Build</h4>
		<form:form action="/build/process/create" method="post"
			modelAttribute="newBuild">
			<form:input type="hidden" path="votes" value="0" />
			<form:input type="hidden" path="user" value="${user_id }" />
			<div class="d-flex justify-content-between">
				<div class="col-6">
					<div class="form-group d-flex justify-content-between mt-5">
						<label>Build Name:</label>
						<form:input type="text" path="name" class="col-8" />
					</div>
					<form:errors path="name" class="text-danger" />
					<div class="form-group d-flex justify-content-between mt-3">
						<label>Build Description:</label>
						<form:textarea path="description" class="col-8"></form:textarea>
					</div>
					<form:errors path="description" class="text-danger" />
				</div>
				<div class="col-5">
					<div class="form-group d-flex justify-content-between mt-5">
						<form:select path="hero" class="col-8" id="hero">
							<option selected disabled>Select Hero</option>
							<option>Hunter</option>
							<option>Blade</option>
							<option>Captain America</option>
							<option>Captain Marvel</option>
							<option>Deadpool</option>
							<option>Doctor Strange</option>
							<option>Ghost Rider</option>
							<option>Hulk</option>
							<option>Iron Man</option>
							<option>Magik</option>
							<option>Morbius</option>
							<option>Nico Minoru</option>
							<option>Scarlet Witch</option>
							<option>Spider-Man</option>
							<option>Storm</option>
							<option>Venom</option>
							<option>Wolverine</option>
						</form:select>
					</div>
					<form:errors path="hero" class="text-danger" />
					<div class="d-flex justify-content-start">
						<button class="btn btn-primary mt-5">Submit</button>
					</div>
				</div>
			</div>
			<table class="table table-striped mt-3">
				<thead>
					<tr>
						<th>Abilities</th>
						<th>Type</th>
						<th>Description</th>
						<th>Damage</th>
						<th>Heroism Gain / Cost</th>
						<th>Modifier</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><select id="ability1" name="ability1">
								<option selected disabled>Ability 1</option>
						</select></td>
						<td id="type1"></td>
						<td id="desc1"></td>
						<td id="dmg1"></td>
						<td id="heroism1"></td>
						<td><select id="mod1" name="modOne">
						</select></td>
					</tr>
					<tr>
						<td><select id="ability2" name="ability2">
								<option selected disabled>Ability 2</option>
						</select></td>
						<td id="type2"></td>
						<td id="desc2"></td>
						<td id="dmg2"></td>
						<td id="heroism2"></td>
						<td><select id="mod2" name="modTwo">
						</select></td>
					</tr>
					<tr>
						<td><select id="ability3" name="ability3">
								<option selected disabled>Ability 3</option>
						</select></td>
						<td id="type3"></td>
						<td id="desc3"></td>
						<td id="dmg3"></td>
						<td id="heroism3"></td>
						<td><select id="mod3" name="modThree">
						</select></td>
					</tr>
					<tr>
						<td><select id="ability4" name="ability4">
								<option selected disabled>Ability 4</option>
						</select></td>
						<td id="type4"></td>
						<td id="desc4"></td>
						<td id="dmg4"></td>
						<td id="heroism4"></td>
						<td><select id="mod4" name="modFour">
						</select></td>
					</tr>
					<tr>
						<td><select id="ability5" name="ability5">
								<option selected disabled>Ability 5</option>
						</select></td>
						<td id="type5"></td>
						<td id="desc5"></td>
						<td id="dmg5"></td>
						<td id="heroism5"></td>
						<td><select id="mod5" name="modFive">
						</select></td>
					</tr>
					<tr>
						<td><select id="ability6" name="ability6">
								<option selected disabled>Ability 6</option>
						</select></td>
						<td id="type6"></td>
						<td id="desc6"></td>
						<td id="dmg6"></td>
						<td id="heroism6"></td>
						<td><select id="mod6" name="modSix">
						</select></td>
					</tr>
					<tr>
						<td><select id="ability7" name="ability7">
								<option selected disabled>Ability 7</option>
						</select></td>
						<td id="type7"></td>
						<td id="desc7"></td>
						<td id="dmg7"></td>
						<td id="heroism7"></td>
						<td><select id="mod7" name="modSeven">
						</select></td>
					</tr>
					<tr>
						<td><select id="ability8" name="ability8">
								<option selected disabled>Ability 8</option>
						</select></td>
						<td id="type8"></td>
						<td id="desc8"></td>
						<td id="dmg8"></td>
						<td id="heroism8"></td>
						<td><select id="mod8" name="modEight">
						</select></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<div id="test1"></div>
	</div>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$('#hero').change(function() {
			let value1 = $(this).val();
			$.ajax({
				url : 'http://localhost:8080/ability',
				type : 'get',
				data : [],
				success : function(data) {
					let options = "<option selected disabled>Ability 1</option>";
					for (let i = 0; i < data.length; i++) {
						if (data[i].hero == value1) {
							options += "<option>" + data[i].name + "</option>"
							}
						}
					$('#ability1').html(options);
					}
			});
			});
		});
	$(document).ready(function() {
		$('#ability1').change(function() {
			let value1 = $(this).val();
			$.ajax({
				url : 'http://localhost:8080/ability',
				type : 'get',
				data : [],
				success : function(data) {
					let options = "<option selected disabled>Modifier</option>";
					for (let i = 0; i < data.length; i++) {
						if (data[i].name == value1) {
							$('#type1').html(data[i].type);
							$('#desc1').html(data[i].description);
							$('#dmg1').html(data[i].damage);
							$('#heroism1').html(data[i].heroism);
							for(let j = 0; j < data[i].mods.length; j++){
								options += "<option>" + data[i].mods[j] + "</option>"
								}
							$('#mod1').html(options);
							}
						}
					}
			});
			});
		});
	$(document).ready(function() {
		$('#ability2').change(function() {
			let value1 = $(this).val();
			$.ajax({
				url : 'http://localhost:8080/ability',
				type : 'get',
				data : [],
				success : function(data) {
					let options = "<option selected disabled>Modifier</option>";
					for (let i = 0; i < data.length; i++) {
						if (data[i].name == value1) {
							$('#type2').html(data[i].type);
							$('#desc2').html(data[i].description);
							$('#dmg2').html(data[i].damage);
							$('#heroism2').html(data[i].heroism);
							for(let j = 0; j < data[i].mods.length; j++){
								options += "<option>" + data[i].mods[j] + "</option>"
								}
							$('#mod2').html(options);
							}
						}
					}
			});
			});
		});
	$(document).ready(function() {
		$('#ability3').change(function() {
			let value1 = $(this).val();
			$.ajax({
				url : 'http://localhost:8080/ability',
				type : 'get',
				data : [],
				success : function(data) {
					let options = "<option selected disabled>Modifier</option>";
					for (let i = 0; i < data.length; i++) {
						if (data[i].name == value1) {
							$('#type3').html(data[i].type);
							$('#desc3').html(data[i].description);
							$('#dmg3').html(data[i].damage);
							$('#heroism3').html(data[i].heroism);
							for(let j = 0; j < data[i].mods.length; j++){
								options += "<option>" + data[i].mods[j] + "</option>"
								}
							$('#mod3').html(options);
							}
						}
					}
			});
			});
		});
	$(document).ready(function() {
		$('#ability4').change(function() {
			let value1 = $(this).val();
			$.ajax({
				url : 'http://localhost:8080/ability',
				type : 'get',
				data : [],
				success : function(data) {
					let options = "<option selected disabled>Modifier</option>";
					for (let i = 0; i < data.length; i++) {
						if (data[i].name == value1) {
							$('#type4').html(data[i].type);
							$('#desc4').html(data[i].description);
							$('#dmg4').html(data[i].damage);
							$('#heroism4').html(data[i].heroism);
							for(let j = 0; j < data[i].mods.length; j++){
								options += "<option>" + data[i].mods[j] + "</option>"
								}
							$('#mod4').html(options);
							}
						}
					}
			});
			});
		});
	$(document).ready(function() {
		$('#ability5').change(function() {
			let value1 = $(this).val();
			$.ajax({
				url : 'http://localhost:8080/ability',
				type : 'get',
				data : [],
				success : function(data) {
					let options = "<option selected disabled>Modifier</option>";
					for (let i = 0; i < data.length; i++) {
						if (data[i].name == value1) {
							$('#type5').html(data[i].type);
							$('#desc5').html(data[i].description);
							$('#dmg5').html(data[i].damage);
							$('#heroism5').html(data[i].heroism);
							for(let j = 0; j < data[i].mods.length; j++){
								options += "<option>" + data[i].mods[j] + "</option>"
								}
							$('#mod5').html(options);
							}
						}
					}
			});
			});
		});
	$(document).ready(function() {
		$('#ability6').change(function() {
			let value1 = $(this).val();
			$.ajax({
				url : 'http://localhost:8080/ability',
				type : 'get',
				data : [],
				success : function(data) {
					let options = "<option selected disabled>Modifier</option>";
					for (let i = 0; i < data.length; i++) {
						if (data[i].name == value1) {
							$('#type6').html(data[i].type);
							$('#desc6').html(data[i].description);
							$('#dmg6').html(data[i].damage);
							$('#heroism6').html(data[i].heroism);
							for(let j = 0; j < data[i].mods.length; j++){
								options += "<option>" + data[i].mods[j] + "</option>"
								}
							$('#mod6').html(options);
							}
						}
					}
			});
			});
		});
	$(document).ready(function() {
		$('#ability7').change(function() {
			let value1 = $(this).val();
			$.ajax({
				url : 'http://localhost:8080/ability',
				type : 'get',
				data : [],
				success : function(data) {
					let options = "<option selected disabled>Modifier</option>";
					for (let i = 0; i < data.length; i++) {
						if (data[i].name == value1) {
							$('#type7').html(data[i].type);
							$('#desc7').html(data[i].description);
							$('#dmg7').html(data[i].damage);
							$('#heroism7').html(data[i].heroism);
							for(let j = 0; j < data[i].mods.length; j++){
								options += "<option>" + data[i].mods[j] + "</option>"
								}
							$('#mod7').html(options);
							}
						}
					}
			});
			});
		});
	$(document).ready(function() {
		$('#ability8').change(function() {
			let value1 = $(this).val();
			$.ajax({
				url : 'http://localhost:8080/ability',
				type : 'get',
				data : [],
				success : function(data) {
					let options = "<option selected disabled>Modifier</option>";
					for (let i = 0; i < data.length; i++) {
						if (data[i].name == value1) {
							$('#type8').html(data[i].type);
							$('#desc8').html(data[i].description);
							$('#dmg8').html(data[i].damage);
							$('#heroism8').html(data[i].heroism);
							for(let j = 0; j < data[i].mods.length; j++){
								options += "<option>" + data[i].mods[j] + "</option>"
								}
							$('#mod8').html(options);
							}
						}
					}
			});
			});
		});
	</script>
</body>
</html>