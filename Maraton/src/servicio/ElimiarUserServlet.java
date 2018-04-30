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
import persistencia.UsuariosHelper;

/**
 * Servlet implementation class ElimiarUserServlet
 */
@WebServlet("/ElimiarUserServlet")
public class ElimiarUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElimiarUserServlet() {
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
		PrintWriter out = response.getWriter();
		String dni = request.getParameter("dni");
		String password = request.getParameter("password");
		UsuariosHelper helperUser = new UsuariosHelper();
		
		if(Validate.checkUser(Integer.parseInt(dni), password)) {
			helperUser.totalDelete(Integer.parseInt(dni));
			//Mensaje de delete correcto
		}else {
			//Password incorrecta, no existe usuario... etc
		}
		
	}
}
