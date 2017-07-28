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
	<form action="${pageContext.request.contextPath}/ServletVille"
		method="post">
		<label for="country">Country :</label><input type="text" value="${country}" name="country" /><br> 
		<input type="submit" name="valider" value="Valider" />
	</form>
	<c:if test="${!empty country}">
		<p>You selected: ${country}.</p>
	</c:if>
	<c:if test="${!empty listeVilles}">
		<c:forEach items="${listeVilles}" var="ville" varStatus="status">
			<p>${status.first?ville.pays:""}</p>
			<p>${ville.nom}</p>
		</c:forEach>
	</c:if>
	<p class="error">${erreur}</p>

</body>
</html>