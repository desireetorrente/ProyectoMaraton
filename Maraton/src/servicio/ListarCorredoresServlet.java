package servicio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modelo.Participantes;
import persistencia.CarrerasHelper;
import persistencia.ParticipantesHelper;

/**
 * Servlet implementation class ListarCorredoresServlet
 */
@WebServlet("/ListarCorredoresServlet")
public class ListarCorredoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ParticipantesHelper ph = new ParticipantesHelper();
	CarrerasHelper ch = new CarrerasHelper();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCorredoresServlet() {
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
		String idcarrera = request.getParameter("idcarrera");


		if(ch.Buscar(Integer.parseInt(idcarrera)) == null) {
			out.println("No existe la carrera");
		}else {
			List<Participantes> corredores = ph.corredoresEnCarrera(Integer.parseInt(idcarrera));
			if(corredores == null) {
				out.println("La carrera no tiene ningun corredor");
			}else {
				out.println("Corredores " + corredores.size() + " Carrera: " + ch.Buscar(Integer.parseInt(idcarrera)).getNombreCarrera() + " ID:" + idcarrera);
				out.println("<br>");
				out.println("------------------------------");
				out.println("<br>");
				for(int i = 0; i< corredores.size(); i++) {
					out.println("Nombre: " + corredores.get(i).getUsuarios().getNombreUsuarios() + 
							"; Dorsal: " + corredores.get(i).getId().getDorsalParticipantes());
					out.println("<br>");
				}
			}
		}
}

	
	


}
