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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css">

</head>
<body>

<!-- inclure le header -->
<%-- 	<%@ include file="/template/header.html" %> --%>

<h3>${msg} : ${login}</h3>

<br/>

<a href="${pageContext.request.contextPath}/deconnexion">Se déconnecter</a><br/>

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
					<td><a href="c:url value='/ectrl/submitDelete?pId=${c.idCategorie}'/>">Supprimer</a>
						| <a href="c:url value='/ectrl/submitSearch?pId=${c.idCategorie}&pLien=oui'/>">Modifier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>



</body>
</html>