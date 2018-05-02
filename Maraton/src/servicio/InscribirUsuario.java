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
 * Servlet implementation class InscribirUsuario
 */
@WebServlet("/InscribirUsuario")
public class InscribirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ControladorCarrera cc = new ControladorCarrera();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscribirUsuario() {
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
		response.setContentType("text/html;charset=UTF-8");
		 
		PrintWriter out = response.getWriter();
		String dni = request.getParameter("dni");
		String idcarrera = request.getParameter("idcarrera");
		
		cc.asignarCorredor(Integer.parseInt(dni), Integer.parseInt(idcarrera));
		out.println("Se ha inscrito en la carrera: " + idcarrera);
	}

}
