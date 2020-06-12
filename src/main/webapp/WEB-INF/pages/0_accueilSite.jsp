<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- ajouter la librairie de core de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<nav class="navbar navbar-default navbar-static-top">
  <div class="container">
    <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Catégorie <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Ajouter</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Modifier</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Supprimer</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Rechercher</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Produits <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Ajouter</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Modifier</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Supprimer</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Rechercher</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Commandes <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Ajouter</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Modifier</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Supprimer</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Rechercher</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Clients <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Ajouter</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Modifier</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Supprimer</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Rechercher</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
        <a href="<c:url value='/admin/actrl/liste'/>">Se Connecter</a>
      </form>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
  </div>
</nav>

<%-- <a href='<c:url value="/admin/magasin"/>'>Se Connecter</a><br/> --%>
<%-- <a href="<c:url value='/public/client'/>">Bienvenu</a> --%>

<h3 style="color: red; text-align: center;">${msg}</h3>

</body>
</html>