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
 * Servlet que implementa la clase SigninServlet
 * Esta clase es el controlador que gestiona las peticiones
 * de registrar a un nuevo usuario en la aplicación
 * Esta clase hereda de HttpServlet
 * @author admin
 * @version 02/05/2018
 */
@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ControladorUsuario user = new ControladorUsuario();
    /**
     * Constructor por defecto
     * @see HttpServlet#HttpServlet()
     */
    public SigninServlet() {
        super();
    }

	/**
	 * Método que gestiona las peticiones Get que se generan en el cliente
	 * En este caso no se gestionan peticiones de este tipo 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**Método para las peticiones Post que se generan en el cliente
	 * En este caso se genera la petición de un nuevo usuario de registrarse
	 * El usuario mete sus datos en el formulario de inscripción y comprueba si el
	 * usuario ya existe o no en la BBDD.
	 * En el caso de que no exista, se procede a su registro y se informa al usuario
	 * Si durante este proceso se produce un error se avisa al usuario por pantalla
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dni = request.getParameter("dni");
		String pwd = request.getParameter("password");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String mail = request.getParameter("correo");
		String edad = request.getParameter("edad");
		String telefono = request.getParameter("telefono");
		String cp = request.getParameter("cp");
		
		short comprobarUser = (short) user.crearUsuario(Integer.parseInt(dni), nombre, apellidos, mail, pwd, Integer.parseInt(edad), telefono, cp);
		if( comprobarUser == 0) {
			PrintWriter out= response.getWriter();
			out.println("<font color=blue>Se ha registrado correctamenteo</font>");
		}
		if (comprobarUser == 1){
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Usuario ya registrado</font>");
		}
		if(comprobarUser == -1) {
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Error al registrar usuario</font>");
		}
		
	}

}
