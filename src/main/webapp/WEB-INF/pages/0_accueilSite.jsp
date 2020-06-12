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

<div style="margin-top: 10%" class="container">
<div class="container-fluid">
        <a class="btn btn-info btn-lg btn-block" role="button"
         href="<c:url value='/admin/actrl/liste'/>">Se Connecter</a>

</div>
</div>

<h3 style="color: red; text-align: center;">${msg}</h3>

</body>
</html>