package servicio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.ControladorUsuario;


/**
 * Servlet implementation class ModificarUsuario
 */
@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ControladorUsuario cu = new ControladorUsuario();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		String dniString = request.getParameter("dniUser");
		int dni = Integer.parseInt(dniString);
		String nombre = request.getParameter("nombreUser");
		String apellidos = request.getParameter("apellidosUser");
		String email = request.getParameter("emailUser");
		String pwd = request.getParameter("pwdUser");
		String edadString = request.getParameter("edadUser");
		int edad = Integer.parseInt(edadString);
		String cp = request.getParameter("cpUser");
		String telf = request.getParameter("telefonoUser");
		
		cu.cambiar(dni, nombre, apellidos, email, pwd, edad, cp, telf);
	}

}
