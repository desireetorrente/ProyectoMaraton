package servicio;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.UsuariosHelper;

/**
 * Servlet que implementa la clase ElimiarUserServlet
 * Esta clase es el controlador que gestiona las peticiones de eliminar
 * usuarios que llegan desde la Web
 * Esta clase heresa de HttpServlet
 * @author admin
 * @version 02/05/2018
 */
@WebServlet("/ElimiarUserServlet")
public class ElimiarUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Contructor por defecto
     * @see HttpServlet#HttpServlet()
     */
    public ElimiarUserServlet() {
        super();
    }

	/**
	 * Método que gestiona las peticiones Get que se generan en el cliente
	 * En este caso no se gestionan peticiones de este tipo 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * Método paras las petiones Post que se generan en el cliente
	 * En este caso entra la petición de eliminar un usuario totalmente, tanto 
	 * si sólo esta registrado como, si es participante en alguna carrera
	 * Este método recoge los parámetros introducidos en el formulario de eliminar de la zona
	 * de usuarios, se comprueba que el usuario existe en la BBDD y la contraseña introducida
	 * es correcta y, si todo es correcto se elimina el usuario
	 * El resultado de este proceso es mostrador en el navegador al usuario
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String dni = request.getParameter("dni");
		String password = request.getParameter("password");
		UsuariosHelper helperUser = new UsuariosHelper();
		
		if(Validate.checkUser(Integer.parseInt(dni), password)) {
			helperUser.totalDelete(Integer.parseInt(dni));
			out.println("<font color=green>Usuario eliminado correctamente</font>");
		}else {
			out.println("<font color=red>No se pudo eliminar el usuario</font>");
		}
	}
}
