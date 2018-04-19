<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Affichage Client</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<br />
	<br />
	<fieldset>
		<legend>Données personnelles</legend>
		ID : ${client.idClient}<br /> Nom : ${client.nom}<br /> Prénom :
		${client.prenom}<br /> Adresse : ${client.adresse}<br /> Code Postal
		: ${client.codePostal}<br /> Ville : ${client.ville}<br /> Téléphone
		: ${client.telephone}
	</fieldset>
	<br />
	<fieldset>
		<legend>Compte Courant</legend>
		<%
			if (("${comptecourant.numCompte}").isEmpty()) {
		%><h1>AUCUN</h1>
		<%
			} else {
		%>
		N° compte : ${comptecourant.numCompte}<br /> Solde :
		${comptecourant.solde} €<br /> Découvert autorisé :
		${comptecourant.decouvertAutorise} €<br /> Carte Visa :
		${comptecourant.carteVisa}<br /> Date D'ouverture :
		${comptecourant.dateOuverture}<%
			}
		%>
	</fieldset>
	<br />
	<fieldset>
		<legend>Compte Epargne</legend>
		N° compte : ${compteepargne.numCompte}<br /> Solde :
		${compteepargne.solde} €<br /> Taux de rémunération :
		${compteepargne.tauxRemuneration} %<br /> Date D'ouverture :
		${compteepargne.dateOuverture}
	</fieldset>
	<br />
	<a href="SelectAllClients">Retour au menu de gestion</a>

	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>