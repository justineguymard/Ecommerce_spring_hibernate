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
				href="${pageContext.request.contextPath}/admin/catctrl/displayAddCat">Ajout
					Catégorie</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/admin/catctrl/displayUpdateCat">Modif
					Catégorie</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/admin/catctrl/displayDeleteCat">Suppr
					Catégorie</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/admin/catctrl/displaySearchCat">Recherche
					Catégorie</a></li>
		</ul>
	</nav>

	<h1 style="color: red; text-align: center;">Formulaire</h1>
	<div class="container">
		<form:form cssClass="form-horizontal" method="post"
			action="submitAddCat" modelAttribute="catajout">

			<div class="form-group">
				<label for="idNom" class="col-sm-2 control-label">Nom:</label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control" id="idNom"
						placeholder="Nom" path="nomCategorie" />
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
				<input type="file" class="custom-file-input" id="customFile">
				<label class="custom-file-label" for="customFile">Choose
					file</label>
			</div>

			<div class="form-group">
				<label for="idDescription" class="col-sm-2 control-label">Description:</label>
				<div class="col-sm-10">
					<form:input type="text" cssClass="form-control" id="idDescription"
						placeholder="Description" path="description" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Valider</button>
				</div>
			</div>
		</form:form>
	</div>

	<script>
		// Add the following code if you want the name of the file appear on select
		$(".custom-file-input").on(
				"change",
				function() {
					var fileName = $(this).val().split("\\").pop();
					$(this).siblings(".custom-file-label").addClass("selected")
							.html(fileName);
				});
	</script>


</body>
</html>