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
<script src="<c:url value='/assets/jquery/jquery-3.5.1.js'/>"></script>
<script src="<c:url value='/assets/js/bootstrap.js'/>"></script>


</head>
<body>

	<!-- inclure le header -->
	<%@ include file="/template/header.html"%>


	<h1 style="color: red; text-align: center;">Ajouter un client</h1>
	<div class="container">



		<form:form cssClass="form-horizontal" method="post"
			action="submitAddCl" modelAttribute="clajout">

			<div class="form-group">
				<label for="idNom" class="col-sm-2 control-label">Nom:</label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control" id="idNom"
						placeholder="Nom" path="nomClient" />
				</div>
			</div>

			<div class="form-group">
				<label for="idAdresse" class="col-sm-2 control-label">Adresse:</label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control" id="idAdresse"
						placeholder="Adresse" path="adresse" />
				</div>
			</div>

			<div class="form-group">
				<label for="idEmail" class="col-sm-2 control-label">Adresse:</label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control" id="idEmail"
						placeholder="E-mail" path="email" />
				</div>
			</div>

			<div class="form-group">
				<label for="idTel" class="col-sm-2 control-label">Tel:</label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control" id="idTel"
						placeholder="Telephone" path="tel" />
				</div>
			</div>





			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Ajouter</button>
				</div>
			</div>
		</form:form>

		<h1>${msg}</h1>
	</div>
	
	
	<!-- Footer -->
	<%@ include file="/template/footer.html"%>

</body>

</html>
