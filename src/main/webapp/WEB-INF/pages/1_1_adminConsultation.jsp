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
<<<<<<< HEAD
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>" />
<link rel="text/javascript"
	href="<c:url value='/assets/js/bootstrap.js'/>" />
<link rel="text/javascript"
	href="<c:url value='/assets/jquery/jquery-3.5.1.js'/>" />
=======

<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>"/>
<script src="<c:url value='/assets/jquery/jquery-3.5.1.js'/>"></script>
<script src="<c:url value='/assets/js/bootstrap.js'/>"></script>

>>>>>>> b787c1314b8995f6d910a2f322a84f5c815c4e91


</head>
<body>

	<!-- inclure le header -->
	<%@ include file="/template/header.html"%>

	<div class="container">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading"
				style="color: red; font-weight: bold; padding: 10px 0px 10px 0px; text-align: center; font-size: large;">Liste
				des catégories</div>

			<!-- Table -->
			<table class="table">
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Photo</th>
					<th>Description</th>
					<th>Opération</th>
				</tr>
				<c:forEach var="c" items="${categories}">
					<tr>
						<td>${c.idCategorie}</td>
						<td>${c.nomCategorie}</td>
						<td>${c.photo}</td>
						<td>${c.description}</td>
						<td><a
							href="c:url value='/admin/catctrl/submitDeleteCat?pId=${c.idCategorie}'/>">Supprimer</a>
							| <a
							href="c:url value='/admin/catctrl/submitSearchCat?pNom=${c.nomCategorie}&pLien=oui'/>">Modifier</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<br />

	<div class="container">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading"
				style="color: red; font-weight: bold; padding: 10px 0px 10px 0px; text-align: center; font-size: large;">Liste
				des produits</div>

			<!-- Table -->
			<table class="table">
				<tr>
					<th>ID</th>
					<th>Designation</th>
					<th>Description</th>
					<th>Prix</th>
					<th>Quantite</th>
					<th>Photo</th>
					<th>Opération</th>
				</tr>
				<c:forEach var="p" items="${produits}">
					<tr>
						<td>${p.idProduit}</td>
						<td>${p.designation}</td>
						<td>${p.description}</td>
						<td>${p.prix}</td>
						<td>${p.quantite}</td>
						<td>${p.photo}</td>
						<td><a
							href="c:url value='/admin/prodctrl/submitDeleteProd?pId=${p.idProduit}'/>">Supprimer</a>
							| <a
							href="c:url value='/admin/prodctrl/submitSearchProd?pNom=${p.designation}&pLien=oui'/>">Modifier</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<br />

	<div class="container">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading"
				style="color: red; font-weight: bold; padding: 10px 0px 10px 0px; text-align: center; font-size: large;">Liste
				des clients</div>

			<!-- Table -->
			<table class="table">
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Adresse</th>
					<th>Email</th>
					<th>Tel</th>
					<th>Opération</th>
				</tr>
				<c:forEach var="cl" items="${clients}">
					<tr>
						<td>${cl.idClient}</td>
						<td>${cl.nomClient}</td>
						<td>${cl.adresse}</td>
						<td>${cl.email}</td>
						<td>${cl.tel}</td>
						<td><a
							href="c:url value='/admin/clctrl/submitDeleteCl?pId=${cl.idClient}'/>">Supprimer</a>
							| <a
							href="c:url value='/admin/clctrl/submitSearchCl?pId=${cl.idClient}&pLien=oui'/>">Modifier</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<br />

	<div class="container">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading"
				style="color: red; font-weight: bold; padding: 10px 0px 10px 0px; text-align: center; font-size: large;">Liste
				des commandes</div>

			<!-- Table -->
			<table class="table">
				<tr>
					<th>ID</th>
					<th>Date</th>
					<th>Opération</th>
				</tr>
				<c:forEach var="cd" items="${commandes}">
					<tr>
						<td>${cd.idCommande}</td>
						<td>${cd.dateCommande}</td>
						<td><a
							href="c:url value='/admin/comctrl/submitDeleteCom?pId=${cd.idCommande}'/>">Supprimer</a>
							| <a
							href="c:url value='/admin/comctrl/submitSearchCom?pId=${cd.idCommande}&pLien=oui'/>">Modifier</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<br />

	<div class="container">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading"
				style="color: red; font-weight: bold; padding: 10px 0px 10px 0px; text-align: center; font-size: large;">Liste
				des lignes de commandes</div>

			<!-- Table -->
			<table class="table">
				<tr>
					<th>ID</th>
					<th>Quantite</th>
					<th>Prix</th>
					<th>Opération</th>
				</tr>
				<c:forEach var="lc" items="${lignesCommandes}">
					<tr>
						<td>${lc.id}</td>
						<td>${lc.quantite}</td>
						<td>${lc.prix}</td>
						<td><a
							href="c:url value='/admin/lcctrl/submitDeleteLc?pId=${lc.id}'/>">Supprimer</a>
							| <a
							href="c:url value='/admin/lcctrl/submitSearchLc?pId=${lc.id}&pLien=oui'/>">Modifier</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>


</body>
</html>