package servicio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Carrera;
import Modelo.Participantes;
import persistencia.CarrerasHelper;

/**
 * Servlet implementation class ListarCarreras
 */
@WebServlet("/ListarCarreras")
public class ListarCarreras extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CarrerasHelper ch = new CarrerasHelper();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCarreras() {
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
		
		List<Carrera> carreras = ch.listarCarrera();
		out.println("Carreras: ");
		out.println("<br>");
		out.println("---------");
		out.println("<br>");
		for(int i = 0; i < carreras.size(); i++) {
			out.println("ID: " + carreras.get(i).getIdcarreraCarrera() + ";   Nombre: " + carreras.get(i).getNombreCarrera() +
					";   Distancia: " + carreras.get(i).getDistanciaCarrera() + "Km");
			out.println("<br>");
		}


	}


}
