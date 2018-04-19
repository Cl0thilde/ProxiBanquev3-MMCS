<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des clients</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<br />
	<br />
	<table>
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Adresse</th>
			<th>Ville</th>
			<th>Code Postal</th>
			<th>Téléphone</th>
			<th>Afficher</th>
			<th>Modifier</th>
			<th>Supprimer</th>
			<th>AjoutCompte</th>
			
		</tr>
		<c:forEach items="${listeclients}" var="client">
			<tr>
				<td><c:out value="${client.idClient}" /></td>
				<td><c:out value="${client.nom}" /></td>
				<td><c:out value="${client.prenom}" /></td>
				<td><c:out value="${client.adresse}" /></td>
				<td><c:out value="${client.ville}" /></td>
				<td><c:out value="${client.codePostal}" /></td>
				<td><c:out value="${client.telephone}" /></td>
				<td><a href="AffichageClient?idclient=${client.idClient}">a</a></td>
				<td><a
					href="LienModificationClient?idclient=${client.idClient}">m</a></td>
				<td><a href="SuppressionClient?idclient=${client.idClient}">x</a></td>
				<td><a href="AjoutCompte?idclient=${client.idClient}">+</a></td>
			</tr>

		</c:forEach>
	</table>
	<br />
	<br />
	<a href="Accueil.jsp">Retour à l'accueil</a>
	<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>