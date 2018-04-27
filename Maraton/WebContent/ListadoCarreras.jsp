<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Modelo.Carrera"%> 
<%@ page import="java.util.List"%> 
<%@ page import="persistencia.CarrerasHelper"%>
<%@ page import="servicio.ServicioCarreras"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">
		Listado de Carreras
	</h1>
	
	<table align="center" border = "1" width="500">
		<thead>
			<tr>
				<th>idcarreraCarrera</th>
				<th>nombreCarrera</th>
				<th>distanciaCarrera</th>
			</tr>
		</thead>
		<tbody>
			<%
			
			List<Carrera>carreras = (List<Carrera>)request.getAttribute("ListadoCarreras");
			for (int a = 0; a<carreras.size(); a++){
				Carrera cAux = Carrera.get(a);
				out.println("<tr>");
				out.println("<td>"+cAux.getidcarreraCarrera()+"</td>");
				out.println("<td>"+cAux.getCarrera()+"</td>");
				out.println("<td>"+cAux.getdistanciaCarreraa()+"</td>");
				out.println("</tr>");	
			}
			%>
		</tbody>	
	</table>

</body>
</html>