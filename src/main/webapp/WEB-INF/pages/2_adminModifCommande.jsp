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


	<h1 style="color: red; text-align: center;">Modifier une commande</h1>
	<div class="container">



		<form:form cssClass="form-horizontal" method="get" action="submitUpdateCom" >

			<div class="form-group">
				<label for="idIDc" class="col-sm-2 control-label">ID de la commande:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="idIDc"
						placeholder="ID de la commande" name="pId" />
				</div>
			</div>


			<div class="form-group">
				<label for="idDate" class="col-sm-2 control-label">Date:</label>
				<div class="col-sm-10">
					<input type="date" class="form-control" id="idDate"
						placeholder="Date" name="pDate" />
				</div>
			</div>

			<div class="form-group">
				<label for="idID" class="col-sm-2 control-label">ID du client:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="idID"
						placeholder="ID du client" name="pIdCl" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Modifier</button>
				</div>
			</div>
		</form:form>

		<h1>${msg}</h1>
	</div>
	
	
	<!-- Footer -->
	<%@ include file="/template/footer.html"%>

</body>

</html>
