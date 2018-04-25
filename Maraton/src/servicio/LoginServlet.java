package servicio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controlador.ControladorUsuario;

/**
 * 
 */


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String userDNI = "admin";
	private final String password = "password";
	private ControladorUsuario userControl = new ControladorUsuario();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// get request parameters userID contraseña
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		if(Validate.checkUser(Integer.parseInt(userDNI), password)){
			HttpSession session = request.getSession();
			session.setAttribute("user", "David");
			//La sesion expira en 30 min
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("user", user);
			response.addCookie(userName);
			String encodedURL = response.encodeRedirectURL("LoginSuccess.jsp");
			response.sendRedirect(encodedURL);
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>La contraseña o el usuario es incorrecto</font>");
			rd.include(request, response);
		}

	}

}
