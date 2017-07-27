<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Villes</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/ServletVille" method="post">
		Country :<input type="text" value="${country}" name="country"/><br>
		<input type="submit" name="valider" value="Valider" />
	</form>
	
	<p class="error">${erreur}</p>
	
	<c:choose>
		<c:when test="${empty listeVilles}">
            Pas de ville
    	</c:when>

		<c:when test="${!empty listeVilles}">
			<div class="cities">
				<h2>Cities of ${paysChoisi}:</h2>
				<c:forEach items="${listeVilles}" var="ville">
						<p>${ville.nom}</p>
				</c:forEach>
			</div>
		</c:when>
	</c:choose>
</body>
</html>