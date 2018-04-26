<!doctype html>
<html lang="es">
<head>

<title>Inicio de sesion</title>

<!-- Bootstrap core CSS -->
<link href="cssv2.css" rel="stylesheet">

</head>

<body>
	<div id="cuadro">
		<form action="LoginServlet" method="post">
			<p id="titulo">Iniciar sesion</p>
			<hr>
			<br />
			<br /> <label id="subtitulo">DNI de usuario</label> <br />
			<br /> <input type="text" name="dni" class="entrada"> <br />
			<br /> <label id="subtitulo2">Contraseña</label> <br />
			<br /> <input type="password" name="password" class="entrada" /> <br />
			<br /> <input type="submit" value="Iniciar sesion" id="boton" />
			<a id="volver" href="index.jsp">Volver</a>
		</form>
	
	</div>
</body>
</html>