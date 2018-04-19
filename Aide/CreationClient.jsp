<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Création client</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<br />
	<br />
	<form action="CreationClient" method="post">
		<fieldset>
			<legend>Création Client</legend>
			<input type="text" name="nom" placeholder="Nom" required><br />
			<input type="text" name="prenom" placeholder="Prénom" required><br />
			<input type="text" name="adresse" placeholder="Adresse" required><br />
			<input type="number" max="99999" min="0" name="codePostal"
				placeholder="Code Postal" required><br /> <input
				type="text" name="ville" placeholder="Ville" required><br />
			<input type="text" name="telephone" placeholder="Téléphone" required><br />
			<p />
			<input type="submit" value="Créer"> <input type="reset"
				value="Effacer"> <a href="Accueil.jsp"><input
				type="button" value="Annuler"></a>
		</fieldset>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>