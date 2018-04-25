package controlador;

import Modelo.Administradores;
import persistencia.AdministradoresHelper;

/**
 * Gestiona los comportamientos de la clase Administrador
 * Esta clase hereda de la clase Controlador
 * @author admin
 * @version 10/04/2018
 */
public class ControladorAdministrador {
	
	
	AdministradoresHelper helper = new AdministradoresHelper();
	/**
	 * Metodo para crear un administrador y añadirlo a la coleccion
	 * @param dni. El dni se utilizará como identificador único de cada administrador.
	 * @param nombre. Nombre de usuario
	 * @param password. Contraseña del administrador para poder acceder a la aplicación.
	 * @param timeStamp. TimeSTamp que mostrará el momento en el que se ha creado el Administrador.
	 * @return Booleano indicando si ese administrador se ha podido añadir o no porque ya se encuentra en la colecion.
	 */
	public boolean crearAdministrador(int dni, String nombre, String password) {
		try {
			Administradores nuevoAdmin = new Administradores(dni, nombre, password);
			helper.insertar(nuevoAdmin);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false; 		
		}
		
	}
	
	/**
	 * Cambio de nombre de usuario para un administrador.
	 * @param dni DNI del administrador que se quiere cambiar el nombre.
	 * @param nuevoNombre Nuevo nombre de usuario.
	 * @see Clase Controlador.buscar().
	 */
	public boolean cambiar(int dni, String nuevoNombre, String password){
		try{
			helper.modificar(dni, nuevoNombre, password); //Actualizar nombre administrador y contrasena
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	/**
	 * Eliminar un administrador. 
	 * @param dni DNI del administrador que se quiere eliminar.
	 * @return Booleano indicando si se ha podido realizar la operacion.
	 * @see Clase Controlador.buscar().
	 */
	public boolean eliminarAdministrador(int dni) {
		try {
			helper.delete(dni); 
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public void imprimirAdministradores() {
		//Retorna una lista con los administradores registrados en la base de datos
		try {
			helper.listar();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
