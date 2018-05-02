package servicio;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.ControladorCarrera;

/**
 * Servlet que implementa la clase InscribirUsuario
 * Esta clase es el controlador que gestiona las peticiones
 * de inscribir a un usuario en una carrera
 * Esta clase hereda de HttpServlet
 * @author admin
 * @version 02/05/2018
 */
@WebServlet("/InscribirUsuario")
public class InscribirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ControladorCarrera cc = new ControladorCarrera();
    /**
     * Constructor por defecto
     * @see HttpServlet#HttpServlet()
     */
    public InscribirUsuario() {
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

	/**
	 * Método paras las petiones Post que se generan en el cliente
	 * En este caso entra la patición de inscribir a un usuario en una carrera
	 * El usuario introduce su DNi y el identificador de la carrera a la que quiere
	 * inscribirse y se llama al Controlador Carrera que genera el resto de la lógica
	 * de negocio para realizar la inscripción
	 * Se avisa al usuario por el navegador de que se ha realizado la inscripción
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		 
		PrintWriter out = response.getWriter();
		String dni = request.getParameter("dni");
		String idcarrera = request.getParameter("idcarrera");
		
		cc.asignarCorredor(Integer.parseInt(dni), Integer.parseInt(idcarrera));
		out.println("Se ha inscrito en la carrera: " + idcarrera);
	}

}
