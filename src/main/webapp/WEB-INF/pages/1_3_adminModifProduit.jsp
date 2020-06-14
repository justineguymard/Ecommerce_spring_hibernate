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
<title>Insert title here</title>

<!--  ajouter Bootstrap -->
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>" />

</head>
<body>
	
	<nav class="navbar navbar-inverse">
		<ul class="nav nav-pills">
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/admin/actrl/liste">Accueil</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/admin/prodctrl/displayAddProd">Ajout
					Produit</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/admin/prodctrl/displayUpdateProd">Modif
					Produit</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/admin/prodctrl/displayDeleteProd">Suppr
					Produit</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/admin/prodctrl/displaySearchProdByCat">Recherche
					Produit</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/admin/prodctrl/displaySearchProdByName">Recherche
					Produit</a></li>
		</ul>
	</nav>
	
	<h1 style="color: red; text-align: center;">Formulaire</h1>
	<div class="container">
		<form:form cssClass="form-horizontal" method="post"
			action="submitUpdateProd" modelAttribute="prodmodif">
			
			<div class="form-group">
				<label for="idProduit" class="col-sm-2 control-label">Id:</label>
				<div class="col-sm-10">
					<form:input type="number" cssClass="form-control" id="idProduit"
						placeholder="IdProduit" path="idProduit" />
				</div>
			</div>

			<div class="form-group">
				<label for="idDesignation" class="col-sm-2 control-label">Designation:</label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control" id="idDesignation"
						placeholder="Designation" path="designation" />
				</div>
			</div>

			<div class="form-group">
				<label for="idDescription" class="col-sm-2 control-label">Description:</label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control" id="idDescription"
						placeholder="Description" path="description" />
				</div>
			</div>

			<div class="form-group">
				<label for="idPrix" class="col-sm-2 control-label">Prix:</label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control" id="idPrix"
						placeholder="Prix" path="prix" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="idQuantite" class="col-sm-2 control-label">Quantite:</label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control" id="idQuantite"
						placeholder="Quantite" path="quantite" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="idSelectionne" class="col-sm-2 control-label">Selectionne:</label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control" id="idSelectionne"
						placeholder="Selectionne" path="selectionne" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="idPhoto" class="col-sm-2 control-label">Photo:</label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control" id="idPhoto"
						placeholder="Photo" path="photo" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Valider</button>
				</div>
			</div>
		</form:form>
	</div>

</body>
</html>