package servicio;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.corba.se.spi.protocol.RequestDispatcherRegistry;

import Modelo.Usuarios;
import controlador.ControladorUsuario;

/**Servlet :Esta clase es el controlador que gestiona las peticiones que llegan desde la web
 * @author admin
 * @version 13/04/2018
 */
@WebServlet("/SVWeb")
public class SVWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ControladorUsuario controladorUsuario = new ControladorUsuario();
       
    /**Contructor que hereda la clase HttpServlet
     * @see HttpServlet#HttpServlet()
     */
    public SVWeb() {
        super();
        
    }

	/**M�todo para las peticiones get que tienen lugar desde el cliente
	 * Por el doget entrar�n las peticiones de:
	 * Mostrar el formulario de inscripci�n vacio (Nuevo) para nuevos usuarios
	 * Mostrar el listador de usuarios (verListadoCorredores)
	 * Se a�ade el par�met ro acci�n para diferenciar las diferentes tareas que entran por el doGEt
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idcarrera = request.getParameter("idcarrera");
		String nombreCarrera =request.getParameter("nombreCarrera");
		String distanciaCarrera = request.getParameter("distanciaCarrera");
		String altitudCarrera = request.getParameter("altitudCarrera");
	
		//condicional que seg�n lo que hemos recogido en acci�n hace una cosa u otra.
	}

	/**M�todo para las peticiones post que llegan desde el cliente
	 * por el doPost entrar�n las siguientes peticiones:
	 * Insertar un usuario
	 * Modificar un usuario
	 * Borrar un usuario
	 * Elegir carrera
	 * Se a�ade el par�metro acci�n para diferenciar las diferentes tareas que entran por el doPost
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dni = Integer.parseInt(request.getParameter("dni"));
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String telefono = request.getParameter("telefono");
		String cp = request.getParameter("cp");
		
		String accion = request.getParameter("accion");
		String vista= "";
		if (accion != null) {
		switch (accion) {
		 	case "Insertar":
		 		
		 		controladorUsuario.crearUsuario(dni, nombre, apellidos, mail, password, edad, telefono, cp);
		 		break;
		 	case "Modificar":
		 		break;
		 	case "Eliminar":
		 		controladorUsuario.eliminarUsuario(dni);
		 		break;
		 	case "ElegirCarrera":
		} 
	
		}
		response.sendRedirect("SVWeb?accion="+vista);
	}

}
