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

<h1 style="color: red; text-align: center;">Formulaire</h1>
	<div class="container">
	<form:form cssClass="form-horizontal" method="post" action="submitDelete" modelAttribute="esuppr">
	
		<div class="form-group">
			<label for="idId" class="col-sm-2 control-label">Id:</label>
			<div class="col-sm-10">
				<form:input type="number" cssClass="form-control" id="idId" placeholder="Id" path="id"/>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Valider</button>
			</div>
		</div>
	</form:form>
	</div>

</body>
</html>