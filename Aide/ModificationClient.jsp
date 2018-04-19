<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification client</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<br />
	<br />
	<form action="ModificationClient" method="post">
		<fieldset>
			<legend>Modification Client</legend>
			<input type="hidden" name="idclient" value="${client.idClient}" /> <input
				type="text" name="nom" value="${client.nom}"><br /> <input
				type="text" name="prenom" value="${client.prenom}"><br /> <input
				type="text" name="adresse" value="${client.adresse}"><br />
			<input type="text" name="codePostal" value="${client.codePostal}"><br />
			<input type="text" name="ville" value="${client.ville}"><br />
			<input type="text" name="telephone" value="${client.telephone}"><br />
			<p />
			<input type="submit" value="Modifier"> <a
				href="SelectAllClients"><input type="button" value="Annuler"></a>
		</fieldset>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>