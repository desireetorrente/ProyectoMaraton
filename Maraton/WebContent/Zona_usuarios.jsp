<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="persistencia.CarrerasHelper" %>
<%@ page import="java.sql.*" %>
<%@ page import="Modelo.Carrera" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Zona Usuario</title> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        
        <link rel="stylesheet" type="text/css" href="ZonaUsuario.css">
 </head>       
<body>
	<div id="contenedor">
		<div id="botones">
			<button class="boton" onclick="ocultaInsert()" onclick="rellenaForm()">Inscripcion</button>
			<button class="boton" onclick="ocultaListaCarrera()"> listar carrera</button>
			<button class="boton" onclick="ocultaListaCorredor()"> listar corredor</button>
			<button class="boton" onclick="ocultaLogEditar()"> editar</button>
			<button class="boton" onclick="ocultaEliminar()"> eliminar</button>
			<button class="boton" onclick="LogoutServlet"> Log Out</button>
		</div>
	
	<div id="formularios">
		<div id="insert">
				<form action="InscribirUsuarioCarreraServlet" method="post">
					<p>DNI: </p>
					<input type="text" name="dni"></input>
					<p>Carrera:</p>
					<input type="text" name="dni"></input>
					<br>
					<input type="submit" value="Enviar">
				</form>
			</div>
			
			<div id="listaCarrera">				
				<form action="svlistarcarreras" method="post">
					<div class="campos">
						<p>ID Carrera: </p>
						<input type="text" name="idcarrera"></input>
						<p>Nombre de la Carrera:</p>
						<input type="text" name="nombreCarrera"></input>
						<p>Distancia:</p>
						<input type="text" name="distancia"></input>
						<p>Altitud:</p>
						<input type="text" name="juez"></input>
						<p>Juez:</p>
						<input type="text" name="juez"></input>
					</div>
					<div class="space">
					</div>
					<div id="botonCarrera">
						<button id="busca" onclick=""> Buscar</button>
					</div>
					
				</form>
			</div>
			
			<div id="listaCorredor">
				<form action="" method="post">
					<div class="campos">
						<p>Id carrera:</p>
						<input type="text" name="carrera"></input>
						<p>Corredores</p>
						<textarea name="corredores"></textarea>				
					</div>
					<div class="space">
					</div>
					<div id="botonCarrera">
						<input type="submit" id="busca" value="Buscar">
					</div>
				</form>
			</div>
				
			<div id="logEditar">		
				<form action="" method="post">
					<p>DNI Usuario: </p>
					<input type="text" name="dniUser"></input>
					<p>Contraseņa:</p>
					<input type="password" name="pwdUser"></input>
					<br>
					<input class="boton" onclick="ocultaEditar()" value="Enviar">
				</form>	
			</div>		
		
		<div id="editar">
			<form action="ModificarUsuario" method="post">
				<p>DNI Usuario: </p>
				<input type="text" name="dniUser"></input>
				<p>Nombre:</p>
				<input type="text" name="nombreUser"></input>
				<p>Apellidos:</p>
				<input type="text" name="apellidosUser"></input>
				<p>Email:</p>
				<input type="text" name="emailUser"></input>
				<p>Contraseņa:</p>
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
			<form action="EliminarUsuarioSV" method="post">
				<p>DNI Usuario: </p>
				<input type="text" name="dniUser"></input>
				<p>Contraseņa:</p>
				<input type="password" name="pwdUser"></input>
				<br>
				<input type="submit" value="Borrar">
			</form>
		</div>	
	</div>


<%--   Intento con JDBC

		CarrerasHelper listaA=new CarrerasHelper();

     String idcarrera = request.getParameter("idcarrera");
		String nombreCarrera =request.getParameter("nombreCarrera");
		String distanciaCarrera = request.getParameter("distanciaCarrera");
		String altitudCarrera = request.getParameter("altitudCarrera");
		
		Class.forName("com.mysql.jdbc.Driver");
			

		try{
		Connection miConexion=java.sql.DriverManager.getConnection("jdbc:mysql://192.168.203.4:3306/bbdd_g2","admin_g2","a4384"); 
		
		Statement miStatement=miConexion.createStatement();
		
	    String Sql="SELECT ALL FROM CARRERA";
				
		miStatement.executeUpdate(Sql);
		
		out.println("idcarrera");
				
		 }catch(Exception e){
			
			out.println("Ha habido un error");
			
		}
		
			//(idcarrera_carrera, nombre_carrera, distancia_carrera, altitud-carrera";

		--%>

<script>
function ocultaInsert(x) {
	if(document.getElementById("insert").style.visibility == "visible"){
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}else{
		document.getElementById("insert").style.visibility = "visible";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}	
}

function ocultaListaCarrera(x) {
	if(document.getElementById("listaCarrera").style.visibility == "visible"){
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}else{
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "visible";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}	
}

function ocultaListaCorredor(x) {
	if(document.getElementById("listaCorredor").style.visibility == "visible"){
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}else{
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "visible";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}	
}

function ocultaLogEditar(x) {
	if(document.getElementById("logEditar").style.visibility == "visible"){
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}else{
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "visible";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}	
}

function ocultaEditar(x) {
	if(document.getElementById("editar").style.visibility == "visible"){
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}else{
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "visible";
		document.getElementById("eliminar").style.visibility = "hidden";
	}	
}

function ocultaEliminar(x) {
	if(document.getElementById("eliminar").style.visibility == "visible"){
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}else{
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("editar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "visible";
	}	
}
</script>






</body>
</html>