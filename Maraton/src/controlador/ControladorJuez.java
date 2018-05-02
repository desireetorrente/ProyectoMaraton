package controlador;

import Modelo.Jueces;
import persistencia.JuecesHelper;

public class ControladorJuez {

	JuecesHelper helper = new JuecesHelper();
	
	/**
	 * Crear y añadir un juez
	 * @param dni DNI juez
	 * @param nombre Nombre juez
	 * @param apellidos Apellidos juez
	 * @param telefono Telefono juez
	 * @return Boolean indicando si se ha relizado correctamente la operacion
	 */
	public boolean aniadirJuez(int dni, String nombre, String apellidos, String telefono) {
		try {
			Jueces nuevoJuez = new Jueces(dni, nombre, apellidos, telefono);
			helper.insertar(nuevoJuez);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * Elimina un juez
	 * @param dniJuez Identificador (DNI) del juez que se quiere eliminar
	 * @return Booleano que indica si se ha realizado correctamente la operacion
	 */
	public boolean eliminarJuez(int dniJuez) {
		try {
			helper.delete(dniJuez);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Modifica los atributos de un juez
	 * @param dni DNI del juez que se quiere modificar
	 * @param nombre Nuevo nombre que se quiere dar al juez
	 * @param apellidos Nuevos apellidos del juez
	 * @param telefono Nuevo teléfono del juez
	 * @return Booleano indicando si la operacion se ha realizado correctamente
	 */
	public boolean cambiar(int dni, String nombre, String apellidos, String telefono) {
		try {
			helper.change(dni, nombre, apellidos, telefono);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
