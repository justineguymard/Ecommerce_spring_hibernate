<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!--  ajouter la lib core de jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- ajouter la taglib form de spring MVC -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout client</title>

<!--  ajouter Bootstrap -->

<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>" />
<link rel="stylesheet" href="<c:url value='/assets/css/footer.css'/>" />
<script src="<c:url value='/assets/jquery/jquery-3.5.1.js'/>"></script>
<script src="<c:url value='/assets/js/bootstrap.js'/>"></script>


</head>
<body>

	<!-- inclure le header -->
	<%@ include file="/template/header.html"%>


	<h1 style="color: red; text-align: center;">Rechercher des clients par leurs noms</h1>
	<div class="container">


	<form class="form-horizontal" method="get" action="submitSearchNameCl">

			<div class="form-group">
				<label for="idID" class="col-sm-2 control-label">Nom du client:</label>
				<div class="col-sm-10">
					<input type="text" Class="form-control" id="idID" placeholder="ID" name="pNom" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Rechercher</button>
				</div>
			</div>
		</form>

		<h1>${msg}</h1>
	</div>
  	<c:if test="${clOut != null}">
	<div class="container">
		<table class="table table-bordered">
		<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Adresse</th>
				<th>Email</th>
				<th>Tel</th>
			</tr>
		<c:forEach items="${clOut}" var="cl"  >
			
			<tr>
			
				<td>${cl.idClient}</td>
				<td>${cl.nomClient}</td>
				<td>${cl.adresse}</td>
				<td>${cl.email}</td>
				<td>${cl.tel}</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
	</c:if>
	

	<!-- Footer -->
	<%@ include file="/template/footer.html"%>

</body>

</html>
