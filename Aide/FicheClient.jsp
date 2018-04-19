<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fiche Client</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<br />
	<br />
	<fieldset>
		<legend>Fiche Client</legend>
		Nom : ${client.nom}<br /> Prénom :
		${client.prenom}<br /> Adresse : ${client.adresse}<br /> Code Postal
		: ${client.codePostal}<br /> Ville : ${client.ville}<br /> Téléphone
		: ${client.telephone}<br />
	</fieldset>
	<br />
	<a href="SelectAllClients">Aller au menu de gestion</a>
	<jsp:include page="Footer.jsp"></jsp:include>
	
</body>
</html>