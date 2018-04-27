package servicio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controlador.ControladorUsuario;

/**
 * Servlet implementation class EliminarUsuarioSV
 */
@WebServlet("/EliminarUsuarioSV")
public class EliminarUsuarioSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ControladorUsuario cu = new ControladorUsuario();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarUsuarioSV() {
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
		doGet(request, response);
		
		String user = request.getParameter("dniUser");
		String pwd = request.getParameter("pwdUser");
		int dni = Integer.parseInt(user);
		if(Validate.checkUser(Integer.parseInt(user), pwd)){ 
			HttpSession session = request.getSession();
			session.setAttribute("user", Validate.getUser(Integer.parseInt(user)).getDniUsuarios());
			cu.eliminarUsuario(dni);
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>La contraseña o el usuario es incorrecto</font>");
			rd.include(request, response);
		}
		
	}

}
