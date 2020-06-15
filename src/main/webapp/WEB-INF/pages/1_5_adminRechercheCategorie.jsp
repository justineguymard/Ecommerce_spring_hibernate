<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  ajouter la lib core de jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!--  ajouter Bootstrap -->

<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>" />
<script src="<c:url value='/assets/jquery/jquery-3.5.1.js'/>"></script>
<script src="<c:url value='/assets/js/bootstrap.js'/>"></script>


</head>
<body>

	<!-- inclure le header -->
	<%@ include file="/template/header.html"%>


	<h1 style="color: red; text-align: center;">Formulaire</h1>
	<div class="container">
		<form class="form-horizontal" method="get" action="submitSearchCat">

			<div class="form-group">
				<label for="idNom" class="col-sm-2 control-label">Nom:</label>
				<div class="col-sm-10">
					<input type="text" Class="form-control" id="idNom"
						placeholder="Nom" name="pNom" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Valider</button>
				</div>
			</div>
		</form>
	</div>

	<h3 style="color: red; text-align: center;">${msg}</h3>

	<c:if test="${!not empty catsearch}"></c:if>
	<div class="container">
		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Photo</th>
				<th>Description</th>
			</tr>
			<tr>
				<td>${catsearch.idCategorie}</td>
				<td>${catsearch.nomCategorie}</td>
				<td>${catsearch.photo}</td>
				<td>${catsearch.description}</td>
			</tr>
		</table>
	</div>


</body>
</html>