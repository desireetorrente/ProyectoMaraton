<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="es">
<head>

<title>Elija opcion</title>

<!-- Bootstrap core CSS -->
<link href="cssv2.css" rel="stylesheet">

</head>

<body>
<div id="cabeza">
<center>
<img src="https://www.accountancyage.com/wp-content/uploads/sites/3/2016/03/marathon-122.png"  width="500" height="220" />
</center>


</div>
	<div id="cuadro">
		<form action="Signin.jsp" method="post">
			<button type="submit" name="boton" id="boton" value="Enviar">Registrarse</button>
		</form>
		<br /> <br />
		<form action="Login.jsp" method="post">
			<button type="submit" name="button" id="boton" value="Enviar">Iniciar Sesión</button>
		</form>
	</div>
</body>
</html>