package servicio;

import Modelo.Usuarios;
import persistencia.UsuariosHelper;

/**
 * Clase para validar los usuarios que se conectan a la 
 * aplicaci�n web
 * @author admin
 *@version 02/05/2018
 */
public class Validate {

	private static UsuariosHelper usuario = new UsuariosHelper(); 
	
	/**
	 * M�todo est�tico que comprueba si el usuario
	 * est� regstrado y si la contrase�a introducida es correcta
	 * @param dni DNI del usuario que quiere acceder a la aplicaci�n
	 * @param pass Contrase�a de acceso del usuario
	 * @return Booleano que indica si el proceso de autenticaci�n ha sido correcto o no
	 */
	public static boolean checkUser(int dni, String pass) {
		
		boolean correcto = false;
		
		try {
			Usuarios usuario2Check = usuario.search(dni);
			if(usuario2Check.getPasswordUsuarios().equals(pass)) {
				correcto = true;
			}else {
				correcto = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return correcto;
	}
	
	/**
	 * M�todo para buscar el usuario en la BBDD
	 * @param dni DNI del usuario que quiere acceder a la web
	 * @return Objeto usuario con ese DNI
	 */
	public static Usuarios getUser(int dni) {
		return usuario.search(dni);
	}
}
