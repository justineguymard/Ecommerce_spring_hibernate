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

<h1 style="color: red; text-align: center;">Formulaire</h1>
	
	<form method="post" action="connexion">
		<label>Mail:</label>
		<input type="text" name="j_username"/>
		<br/>
		
		<label>mdp:</label>
		<input type="text" name="j_password"/>
		<br/>
		
		<input type="submit" value="Soumettre"/>
	</form>
	
	<h3 style="color: red; text-align: center;">${msg}</h3>

</body>
</html>