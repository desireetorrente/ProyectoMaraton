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
import persistencia.CarrerasHelper;

/**
 * Servlet que implementa la clase ListarCarreras
 * Esta clase es el controlador que gestiona las peticiones
 * de los usuarios de ver las carreras que hay disponibles en este
 * momento. Dichas peticiones se realizan a través del navegador
 * Esta clase hereda de HttpServlet
 * @author admin
 * @version 02/05/2018 
 */
@WebServlet("/ListarCarreras")
public class ListarCarreras extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CarrerasHelper ch = new CarrerasHelper();
    
    /**
     * Constructor por defecto
     * @see HttpServlet#HttpServlet()
     */
    public ListarCarreras() {
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
	 * Método para las peticiones Post que se generan en el cliente
	 * En este caso entra la petición de listar las carreras disponibles
	 * Se recibe una lista con las carreras disponibles en la BBDD y se imprime la respuesta
	 * que saldrá por el navegador
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
