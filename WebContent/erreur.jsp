<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type" />
<title>Villes - Erreur</title>
</head>
<body>
	<div id="page">
		<div id="entete">
			<h1>Ville - Erreur</h1>
		</div>
		<div id="contenu">
			<div class="erreur">
				<h2>Erreur</h2>
				<jsp:useBean id="erreur" class="java.lang.Exception"
					type="java.lang.Exception" scope="request" />
				<p>
					Une erreur s'est produite :
					<jsp:getProperty name="erreur" property="message" /></p>
			</div>
		</div>
	</div>
</body>
</html>