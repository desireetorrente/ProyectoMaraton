<!doctype html>
<html lang="es">
<head>

<title>Registro</title>

<!-- Bootstrap core CSS -->
<link href="cssv3.css" rel="stylesheet">

</head>

<body>
	<div id="cuadro">
		<form action="LoginServlet" method="post">
			<p id="titulo">INICIAR SESION</p>
			<hr>
			<br />
			<br /> <label id="subtitulo">DNI de usuario</label> <br />
			<br /> <input type="text" name="dni" class="entrada"> <br />
			<br /> <label id="subtitulo2">Contraseña</label> <br />
			<br /> <input type="password" name="password" class="entrada" /> <br />
			<br /> <label id="subtitulo3">Nombre</label> <br />
			<br /> <input type="text" name="nombre" class="entrada" /> <br />
			<br /> <label id="subtitulo4">Apellidos</label> <br />
			<br /> <input type="text" name="apellidos" class="entrada" /> <br />
			<br /> <label id="subtitulo3">Correo electronico</label> <br />
			<br /> <input type="email" name="correo" class="entrada" /> <br />
			<br /> <label id="subtitulo3">Edad</label> <br />
			<br /> <input type="number" name="edad" class="entrada" /> <br />
			<br /> <label id="subtitulo3">Telefono</label> <br />
			<br /> <input type="text" name="telefono" class="entrada" /> <br />
			<br /> <label id="subtitulo3">Codigo postal</label> <br />
			<br /> <input type="text" name="cp" class="entrada" /> <br />
			
			<br /> <input type="submit" value="Registrarse" id="boton" />
		</form>
	</div>
</body>
</html>
