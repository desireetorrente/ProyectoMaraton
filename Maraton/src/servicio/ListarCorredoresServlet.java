package servicio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modelo.Participantes;
import persistencia.ParticipantesHelper;

/**
 * Servlet implementation class ListarCorredoresServlet
 */
@WebServlet("/ListarCorredoresServlet")
public class ListarCorredoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ParticipantesHelper ph = new ParticipantesHelper();  
	private HttpSession session;
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
		
        response.setContentType("text/html;charset=UTF-8");
        
		PrintWriter out = response.getWriter();
		String idcarrera = request.getParameter("idcarrera");
		ArrayList<Participantes> corredores = (ArrayList<Participantes>) ph.corredoresEnCarrera(Integer.parseInt(idcarrera));
		/*if(idcarrera == "") {
			out.println("Campo no introducido");
		}
		
		out.println("Corredor: ");
		for(int i = 0; i< corredores.size(); i++) {
			out.println(corredores.get(i).getUsuarios().getNombreUsuarios());
		}*/
		
		request.setAttribute("corre", corredores);
		
		RequestDispatcher despachador = request.getRequestDispatcher("Zona_usuarios.jsp");
        despachador.forward(request, response);
	}
	
	
	


}
