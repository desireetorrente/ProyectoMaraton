
package controlador;

import Modelo.Usuarios;
import persistencia.UsuariosHelper;

/**
 * Esta clase se encarga de gestionar los usuarios
 * @author sergio
 * @version 10/04/2018
 */
public class ControladorUsuario {
	
	UsuariosHelper helper = new UsuariosHelper();
	
	/**
	 * Crea un nuevo usuario
	 * @param dni DNI usuario
	 * @param nombre Nombre usuario
	 * @param apellidos Apellidos usuario
	 * @param mail Correo electronico usuario
	 * @param password Contraseña de usuario
	 * @param edad Año de nacimiento usuario
	 * @param telefono Telefono usuario
	 * @param cp Codigo postal usuario
	 * @return Booleeano que indica si la operacion se realiza bien 
	 */
	public int crearUsuario(int dni, String nombre, String apellidos, String mail, String password, int edad, String telefono, String cp) {
		try {
			Usuarios nuevoUsuario = new Usuarios(dni, nombre, apellidos, mail, password, edad, telefono, cp);
			if(helper.insertar(nuevoUsuario) == 0) {
				return 0;
			}else {
				return 1;
			}
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * Elimina un usuario
	 * @param dni Identificador (DNI) del usuario que se quiere eliminar
	 * @return Booleano indicando si se ha realizado correctamente la operacion de borrado
	 */
	public boolean eliminarUsuario(int dni) {
		try {
			helper.delete(dni);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Cambia el nombre, apellidos, mail, password, edad, teléfono y código postal del usuario
	 * @param dni Identificador (DNI) del usuario que se quiere modificar
	 * @param nombreNuevo Nuevo nombre del usuario
	 * @param apellidos Nuevos apellidos del usuario
	 * @param mail Nueva dirección de correo electrónico del usuario
	 * @param password Nueva constraseña del usuario
	 * @param edad Nuevo año de nacimiento
	 * @param telefono Nuevo teléfono del usuario
	 * @param cp Nuevo código postal del usuario
	 * @return Booleano indicando si se ha reliado correctamente el cambio
	 */
	public boolean cambiar(int dni, String nombreNuevo, String apellidos, String mail, String password, int edad, 
			String telefono, String cp) {
		try {
			helper.change(dni, nombreNuevo, apellidos, mail, password, edad, telefono, cp);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Busca un usuario concreto entre la lista de usuarios que hay en la BBDD
	 * @param dni DNI del usuario que se quiere buscar
	 * @return Retorna el objeto usuario buscado
	 */
	public Usuarios buscar(int dni) {
		return helper.search(dni);
	}
	
}
