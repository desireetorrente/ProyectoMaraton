package servicio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Participantes;
import persistencia.ParticipantesHelper;

/**
 * Servlet implementation class ListarCorredoresServlet
 */
@WebServlet("/ListarCorredoresServlet")
public class ListarCorredoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ParticipantesHelper ph = new ParticipantesHelper();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCorredoresServlet() {
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
		
		String idcarrera = request.getParameter("carrera");
		List<Participantes> corredores= ph.corredoresEnCarrera(Integer.parseInt(idcarrera));
		PrintWriter out = response.getWriter();
		for(int i = 0; i< corredores.size(); i++) {
			out.println("<font color = red> corredores.get(i).getUsuarios().getNombreUsuarios()</font>");
		}
	}

}
