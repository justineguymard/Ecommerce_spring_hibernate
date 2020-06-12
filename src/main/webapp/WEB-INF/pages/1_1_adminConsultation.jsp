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
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>"/>
<link rel="text/javascript" href="<c:url value='/assets/js/bootstrap.js'/>"/>
<link rel="text/javascript" href="<c:url value='/assets/jquery/jquery-3.5.1.js'/>"/>


</head>
<body>


<!-- inclure le header -->
	<%@ include file="/template/header.html" %>


	<h1 style="color: red; text-align: center;">Liste des catégories</h1>
	<div class="container">
		<table class="table table-bordered">
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
						href="c:url value='/ectrl/submitDelete?pId=${c.idCategorie}'/>">Supprimer</a>
						| <a
						href="c:url value='/ectrl/submitSearch?pId=${c.idCategorie}&pLien=oui'/>">Modifier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<br />

	<h1 style="color: red; text-align: center;">Liste des produits</h1>
	<div class="container">
		<table class="table table-bordered">
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
						href="c:url value='/ectrl/submitDelete?pId=${p.idProduit}'/>">Supprimer</a>
						| <a
						href="c:url value='/ectrl/submitSearch?pId=${p.idProduit}&pLien=oui'/>">Modifier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<br />

	<h1 style="color: red; text-align: center;">Liste des clients</h1>
	<div class="container">
		<table class="table table-bordered">
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
						href="c:url value='/ectrl/submitDelete?pId=${cl.idClient}'/>">Supprimer</a>
						| <a
						href="c:url value='/ectrl/submitSearch?pId=${cl.idClient}&pLien=oui'/>">Modifier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<br />

	<h1 style="color: red; text-align: center;">Liste des commandes</h1>
	<div class="container">
		<table class="table table-bordered">
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
						href="c:url value='/ectrl/submitDelete?pId=${cd.idCommande}'/>">Supprimer</a>
						| <a
						href="c:url value='/ectrl/submitSearch?pId=${cd.idCommande}&pLien=oui'/>">Modifier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<br />

	<h1 style="color: red; text-align: center;">Liste des lignes de
		commandes</h1>
	<div class="container">
		<table class="table table-bordered">
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
					<td><a href="c:url value='/ectrl/submitDelete?pId=${lc.id}'/>">Supprimer</a>
						| <a
						href="c:url value='/ectrl/submitSearch?pId=${lc.id}&pLien=oui'/>">Modifier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>


</body>
</html>