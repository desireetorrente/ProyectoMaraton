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


/**
 * Servlet que implementa la clase LoginServlet
 * Es el controlador que se encarga de gestionar las peticiones
 * de acceso a la página web mediante contraseña
 * Hereda de HttpServlet
 * @author admin
 * @version 02/05/2018
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Método para las peticiones Post generadas en el cliente
	 * Se encarga de recibir los parametros insertados por el cliente
	 * DNI y Contraseña, comprueba el contenido contra la BBDD, en el 
	 * caso en que la comprobación sea correcta, manda la respuesta y al programa
	 * de nuevo y envia al cliente a la zona_usuarios que es la página cuando 
	 * cliente esa registrado, en el caso contrario marcara en rojo los parametros
	 * introducidos y mostrara el menesaje de que los parametros son incorrectos
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// get request parameters userID contraseña
		String user = request.getParameter("dni");
		String pwd = request.getParameter("password");
		
		if(Validate.checkUser(Integer.parseInt(user), pwd)){ 
			HttpSession session = request.getSession();
			session.setAttribute("user", Validate.getUser(Integer.parseInt(user)).getDniUsuarios());
			//La sesion expira en 30 min
			session.setMaxInactiveInterval(30*60);
			String encodedURL = response.encodeRedirectURL("Zona_usuarios.jsp");
			response.sendRedirect(encodedURL);
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>La contraseña o el usuario es incorrecto</font>");
			rd.include(request, response);
		}

	}

}
