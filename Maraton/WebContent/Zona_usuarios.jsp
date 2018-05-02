<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
			<button class="boton" onclick="ocultaEditar()"> editar</button>
			<button class="boton" onclick="ocultaEliminar()"> eliminar</button>
			<button class="boton" onclick="logout()"> Log Out</button>
		</div>
	
	<div id="formularios">
		<div id="insert">
				<form action="InscribirUsuario" method="post">
				<p>DNI Usuario: </p>
				<input type="text" name="dni"></input>
				<p>ID Carrera:</p>
				<input type="text" name="idcarrera"></input>
				<br>
				<br>
				<button id="busca" onclick="">Inscribirse</button>
			</form>
			</div>
			
			<div id="listaCarrera">				
				<form action="ListarCarreras" method="post">
					<div id="botonCarrera">
					<br>
					<br>
					<br>
						<button id="busca" onclick="">Mostrar carreras</button>
					</div>
					
				</form>
			</div>
			
			<div id="listaCorredor">
				<form action="ListarCorredoresServlet" method="post">
					<div class="campos">
						<p>Id carrera:</p>		
					</div>
					<br /> <input type="text" name="idcarrera" class="entrada"> <br />
					<div id="botonCarrera">
					<br>
						<input type="submit" id="busca" value="Buscar">
					</div>
				</form>
			</div>
				
			<div id="logEditar">		
				<form action="ModificarUsuario" method="post">
				<p>DNI Usuario: </p>
				<input type="text" name="dniUser"></input>
				<p>Nombre:</p>
				<input type="text" name="nombreUser"></input>
				<p>Apellidos:</p>
				<input type="text" name="apellidosUser"></input>
				<p>Email:</p>
				<input type="email" name="emailUser"></input>
				<p>Contraseña:</p>
				<input type="password" name="pwdUser"></input>
				<p>Edad:</p>
				<input type="text" name="edadUser"></input>
				<p>Codigo postal:</p>
				<input type="text" name="cpUser"></input>
				<p>Telefono:</p>
				<input type="text" name="telefonoUser"></input>
				<br>
				<br>
				<input type="submit" id="busca" value="Salvar nuevos campos">
			</form>
			</div>		
		

		<div id="eliminar">
			<form action="EliminarUserServlet" method="post">
				<p>DNI Usuario: </p>
				<input type="text" name="dni"></input>
				<p>Contraseña:</p>
				<input type="password" name="password"></input>
				<br>
				<br>
				<button id="busca" onclick="">Eliminar</button>
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
		document.getElementById("eliminar").style.visibility = "hidden";
	}else{
		document.getElementById("insert").style.visibility = "visible";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}	
}

function ocultaListaCarrera(x) {
	if(document.getElementById("listaCarrera").style.visibility == "visible"){
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}else{
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "visible";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}	
}

function ocultaListaCorredor(x) {
	if(document.getElementById("listaCorredor").style.visibility == "visible"){
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}else{
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "visible";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}	
}


function ocultaEditar(x) {
	if(document.getElementById("logEditar").style.visibility == "visible"){
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}else{
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "visible";
		document.getElementById("eliminar").style.visibility = "hidden";
	}	
}

function ocultaEliminar(x) {
	if(document.getElementById("eliminar").style.visibility == "visible"){
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "hidden";
	}else{
		document.getElementById("insert").style.visibility = "hidden";
		document.getElementById("listaCarrera").style.visibility = "hidden";
		document.getElementById("listaCorredor").style.visibility = "hidden";
		document.getElementById("logEditar").style.visibility = "hidden";
		document.getElementById("eliminar").style.visibility = "visible";
	}	

}

function logout(x){
	window.location.href = "index.jsp";
}
</script>






</body>
</html>