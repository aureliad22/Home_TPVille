<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Villes de France</title>
</head>
<body>
	<div class="country">
		Country : <input type="text" id="country" name="country"><br>
		<input type="submit" id="valider" value="Valider" />
	</div>
	
    <p class="error">${erreur}</p>
    
	<div class="cities">
	<h2>Cities of France:</h2>
	<c:forEach items="${listeVilles}" var="ville">
		<form action="${pageContext.request.contextPath}/ServletVille">
			<p>${ville.nom}</p>
		</form>
	</c:forEach>
	</div>
</body>
</html>