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


	
	<br/>

	<div
		style="displey: flex; margin: auto; width: 50%; margin-top: 100px;">
		<form method="post" action="connexion">
			<fieldset>
				<legend style="text-align: center;">Connectez-vous :</legend>

				<div class="form-group">
					<label for="disabledSelect">Mail*:</label> <input type="text"
						name="j_username" class="form-control" />
				</div>

				<div class="form-group">
					<label for="disabledSelect">Mot-de-passe*:</label> <input
						type="text" name="j_password" class="form-control" />
				</div>

				<button type="submit" class="btn btn-primary">Soumettre</button>
			</fieldset>
		</form>
	</div>

	<h3 style="color: red; text-align: center;">${msg}</h3>

</body>
</html>