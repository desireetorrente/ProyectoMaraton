<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Zona Usuario</title> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <link href="csssignin.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="zonausuario.css">
 </head>       
<body>
<div id="botones">
	<button onclick="ocultaInsert()">Inscripcion</button>
	<button onclick="ocultaListaCarrera()"> listar carrera</button>
	<button onclick="ocultaListaCorredor()"> listar corredor</button>
	<button onclick="ocultaEditar()"> editar</button>
	<button onclick="ocultaEliminar()"> eliminar</button>
</div>

<div id="insert">
	<form action="" method="post">
		<p>DNI: </p>
		<input type="text" name="dni"></input>
		<p>Carrera:</p>
		<input type="text" name="dni"></input>
		<br>
		<input type="submit" value="Enviar">
	</form>
</div>

<div id="listaCarrera">
	
	<form action="" method="post">
		<p>ID Carrera: </p>
		<input type="text" name="idcarrera"></input>
		<p>Nombre de la Carrera:</p>
		<input type="text" name="nombreCarrera"></input>
		<p>Distancia:</p>
		<input type="text" name="distancia"></input>
		<p>Altitud:</p>
		<input type="text" name="juez"></input>
		<p>Participantes:</p>
		<input type="text" name="juez"></input>
		<p>Juez:</p>
		<input type="text" name="juez"></input>
	</form>

</div>

<div id="listaCorredor">
	lista corredor
</div>

<div id="editar">
	<form action="" method="post">
		<p>DNI Usuario: </p>
		<input type="text" name="dniUser"></input>
		<p>Nombre:</p>
		<input type="text" name="nombreUser"></input>
		<p>Apellidos:</p>
		<input type="text" name="apellidosUser"></input>
		<p>Email:</p>
		<input type="text" name="emailUser"></input>
		<p>Contraseña:</p>
		<input type="text" name="pwdUser"></input>
		<p>Edad:</p>
		<input type="text" name="edadUser"></input>
		<p>Codigo postal:</p>
		<input type="text" name="cpUser"></input>
		<p>Telefono:</p>
		<input type="text" name="telefonoUser"></input>
		<br>
		<input type="submit" value="Enviar">
	</form>
</div>

<div id="eliminar">
	borra
</div>

<script>
function ocultaInsert(x) {
	if(document.getElementById("insert").style.visibility == "visible"){
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}else{
		document.getElementById("insert").style.visibility = "visible";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}	
}

function ocultaListaCarrera(x) {
	if(document.getElementById("listaCarrera").style.visibility == "visible"){
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}else{
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "visible";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}	
}

function ocultaListaCorredor(x) {
	if(document.getElementById("listaCorredor").style.visibility == "visible"){
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}else{
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "visible";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}	
}

function ocultaEditar(x) {
	if(document.getElementById("editar").style.visibility == "visible"){
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}else{
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "visible";
		document.getElementById("eliminar").style.visibility = "hidden";
	}	
}

function ocultaEliminar(x) {
	if(document.getElementById("eliminar").style.visibility == "visible"){
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}else{
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "visible";
	}	
}
</script>






</body>
</html>