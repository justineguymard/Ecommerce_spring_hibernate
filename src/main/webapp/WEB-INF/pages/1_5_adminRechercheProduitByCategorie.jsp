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

</body>
</html>