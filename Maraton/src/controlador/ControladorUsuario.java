
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
	public boolean crearUsuario(int dni, String nombre, String apellidos, String mail, String password, int edad, String telefono, String cp) {
		try {
			Usuarios nuevoUsuario = new Usuarios(dni, nombre, apellidos, mail, password, edad, telefono, cp);
			helper.insertar(nuevoUsuario);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Elimina un usuario
	 * @param usuarioEliminar Objeto tipo usuario que se quiere eliminar
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
	 * Cambia el nombre del usuario
	 * @param usuario Objeto tipo usuario al cual se quere cambiar el nombre
	 * @param nombreNuevo Nuevo nombre del usuario
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
	
	public Usuarios buscar(int dni) {
		return helper.search(dni);
	}
	
}
