<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<link rel="stylesheet" href="StyleLog.css" />

</head>
<body>

	<img class="image" src="Logo.png" />

	<form action="ConnexionConseiller" method="post">
		<fieldset>
			<legend>Connexion</legend>
			<p />
			<div class="connexion">
				<input class="case1" type="text" name="login" placeholder="  Login" />
				<p />
				<input class="case2" type="password" name="pwd"
					placeholder="  Password">
			</div>

			<div class="button">
				<input class="case3" type="submit" value="Connexion">
				<p />
				<input class="case4" type="reset" value="Effacer" />
			</div>
		</fieldset>
	</form>
</body>
</html>