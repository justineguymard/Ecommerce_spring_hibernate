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
</head>
<body>

	<nav class="navbar navbar-inverse">
		<ul class="nav nav-pills">
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/admin/actrl/liste">Accueil</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/admin/catctrl/displayAddCat">Ajout
					Catégorie</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/admin/catctrl/displayUpdateCat">Modif
					Catégorie</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/admin/catctrl/displayDeleteCat">Suppr
					Catégorie</a></li>
		</ul>
	</nav>

	<h1 style="color: red; text-align: center;">Formulaire</h1>
	<div class="container">
		<form Class="form-horizontal" method="post"
			action="submitDeleteCat">

			<div class="form-group">
				<label for="idCategorie" class="col-sm-2 control-label">Id:</label>
				<div class="col-sm-10">
					<input type="number" Class="form-control" id="idCategorie"
						placeholder="IdCategorie" name="pId" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Valider</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>