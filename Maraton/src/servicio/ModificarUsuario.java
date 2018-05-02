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
