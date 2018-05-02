package servicio;

import Modelo.Usuarios;
import persistencia.UsuariosHelper;

public class Validate {

	private static UsuariosHelper usuario = new UsuariosHelper(); 
	
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
	
	public static Usuarios getUser(int dni) {
		return usuario.search(dni);
	}
}
