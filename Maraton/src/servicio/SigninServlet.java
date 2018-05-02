package servicio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controlador.ControladorUsuario;

/**
 * Servlet implementation class SigninServlet
 */
@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ControladorUsuario user = new ControladorUsuario();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
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
