package servicio;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Modelo.Carrera;
import persistencia.CarrerasHelper;
import servicio.ServicioCarreras;
 
@WebServlet("/SVListaCarreras")
public class SVListaCarreras extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ServicioCarreras ServicioCarreras = new ServicioCarreras();
 
    public SVListaCarreras() {
        super();
    
    }

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	       //obtenemos la información que necesita la vista
			List<Carrera>carreras = ServicioCarreras.listarCarreras();
			//dejamos la información en un lugar acordado para que la vista la recoja
			request.setAttribute("listadoCarreras", carreras);
			
			//Pasamos el control de la petición a la vista (JSP)
			request.getRequestDispatcher("listadoCoches_JSTL.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
