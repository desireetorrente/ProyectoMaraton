<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ page import="Modelo.Carrera"%>
<%@ page import="persistencia.CarrerasHelper"%>
<%@ page import="java.util.*"%>

<!doctype html>
<html lang="es">
<head>
<title>Zona Usuario</title> 
        <link href="ZonaUsuario.css" rel="stylesheet">
 </head>       
<body>
	<div id="contenedor">
		<div id="botones">
			<button class="boton" onclick="ocultaInsert()" onclick="rellenaForm()">Inscripcion</button>
			<button class="boton" onclick="ocultaListaCarrera()"> listar carrera</button>
			<button class="boton" onclick="ocultaListaCorredor()"> listar corredor</button>
			<button class="boton" onclick="ocultaEditar()"> editar</button>
			<button class="boton" onclick="ocultaEliminar()"> eliminar</button>
		</div>
	
	<div id="formularios">
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
			
			<%
			
			
			Carrera carrera = new Carrera();
			CarrerasHelper carreraslistar = new CarrerasHelper();
			
			//List <Carrera> nombres;
			List<Carrera>nombresListar = new LinkedList<Carrera>();
			nombresListar=carreraslistar.listarCarrera();
			
			int posicion_listar;
		
			%>			
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
				<form action="" method="post">
					<p>Dorsal corredor: </p>
					<input type="text" name="dorsal"></input>
					<p>Carrera:</p>
					<input type="text" name="carrera"></input>
					<p>Usuarios:</p>
					<input type="text" name="Usuario"></input>
				</form>
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
				<input type="password" name="pwdUser"></input>
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
			<p id="peliminar">Inserta tu DNI: </p>
			<form action="" method="post">
				<p>DNI Usuario: </p>
				<input type="text" name="dniUser"></input>
				<p>Contraseña:</p>
				<input type="password" name="pwdUser"></input>
				<br>
				<input type="submit" value="Borrar">
			</form>
		</div>	
	</div>
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