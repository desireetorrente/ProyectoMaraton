package servicio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.ControladorUsuario;


/**
 * Servlet implementation class ModificarUsuario
 * Es el controlador que gestiona las modificicaciones realizadas
 * por un usuario sobre su perfil personal
 * @author admin
 * @version 02/05/2018
 */
@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ControladorUsuario cu = new ControladorUsuario();   
    /**
     * Constructor por defecto
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
        super();
    }

	/**Método que gestiona las peticiones Get que se generan en el cliente
	 * se gestionan las peticiones siguientes
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**Método paras las petiones Post que se generan en el cliente
	 * En este caso la peticion de modificación de los datos de usuario
	 * Recibe el contenido introducido en el formulario web, el cual incluye
	 * las nuevas modificaciones que haya realizado el usuario, a continuacion se hace 
	 * una llamada al controlador de usuario, el cual tiene el metodo para cambiar el contenido de
	 * usuarios, en el caso de que se realice correctamente, aparecera un mensaje con respuesta
	 * de modicicion correcta y en el caso contrario un mensaje de que no se han podido realizar las 
	 * modificaciones
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String dni= request.getParameter("dniUser");
		String nombre = request.getParameter("nombreUser");
		String apellidos = request.getParameter("apellidosUser");
		String email = request.getParameter("emailUser");
		String pwd = request.getParameter("pwdUser");
		String edad = request.getParameter("edadUser");
		String cp = request.getParameter("cpUser");
		String telf = request.getParameter("telefonoUser");
		PrintWriter out= response.getWriter();
		
		if(cu.cambiar(Integer.parseInt(dni), nombre, apellidos, email, pwd, Integer.parseInt(edad), cp, telf)) {
			out.println("<font color=green>Usuario modificado correctamente</font>");
		}else {
			out.println("<font color=red>No se pudo modificar el usuario</font>");
		}
	}

}
