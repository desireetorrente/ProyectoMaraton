package controlador;


import Modelo.Carrera;
import Modelo.Jueces;
import persistencia.CarrerasHelper;
import persistencia.ParticipantesHelper;

/**
 * Clase encargada de gestionar las carreras
 * @author admin
 * @version 10/04/2018 
 */
public class ControladorCarrera {	
	
	CarrerasHelper helperCarrera = new CarrerasHelper();
	ParticipantesHelper helperParticipante = new ParticipantesHelper();
	
	/**
	 * Crear carrera y asignarle sus parametros
	 * @param nombreCarrera Nombre de la carrera
	 * @param distanciaCarrera Distancia de la carrera
	 * @param altitudCarrera Diferencia de altura en la carrera
	 */
	public void crearCarrera(String nombreCarrera, String distanciaCarrera, String altitudCarrera) {
		Carrera nuevaCarrera = new Carrera(nombreCarrera, distanciaCarrera, altitudCarrera);
		helperCarrera.insertar(nuevaCarrera); //Upload el objeto carrera
	}
	
	/**
	 * Borrar carrera
	 * @param idCarrera ID de la carrera que se quiere borrar
	 * @return Booleano indicando si la operacion ha sido correcta
	 */
	public boolean eliminarCarrera(int idCarrera) {
		try {
			helperCarrera.delete(idCarrera);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Cambia nombre, distacia y altitud de una carrera
	 * @param idCarrera Identificador de la carrera que se quiere modificar
	 * @param nuevoNombre Nuevo nombre para la carrera
	 * @param nuevaDistancia Nueva distancia que se da a la carrera
	 * @param nuevaAltitud Nueva altitud que se da a la carrera
	 * @return Booleano indicando si se ha podido realizar la operacion
	 */
	public boolean cambiar(int idCarrera, String nuevoNombre, String nuevaDistancia, String nuevaAltitud) {
		try {
			helperCarrera.cambiar(idCarrera, nuevoNombre, nuevaDistancia, nuevaAltitud); //Cambiar nombre de la carrera
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Adjudica un juez a una carrera
	 * @param juez Objeto Juez que se quiere introducir en la carrera
	 * @param idCarrera identificador de la carrera a la cual se quiere introducir el juez
	 * @return Booleano que indica si se ha realizado bien la operacion
	 */
	public boolean asignarJuez(Jueces juez, int idCarrera) {
		try{
			helperCarrera.insertar_juez(juez, idCarrera); //Asignar un juez a una carrera [En la tabla carrera introducir el dni del juez que se quiere asignar]
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Desvincula un juez de la carrera
	 * @param idCarrera identificador de la carrera a la cual queremos desvincular el juez
	 * @return Booleano indicando si la operacion se ha realizado correctamente
	 */
	public boolean desasignarJuez(int idCarrera) {
		try {
			helperCarrera.desasignar_juez(idCarrera); //Borra el dni del juez de la tabla carrera
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Añade usuario (corredor) a la carrera
	 * @param dniUsuario identificador (DNI) del corredor que se va a añadir a la carrera
	 * @param idCarrera identificador de la carrera a la cual se va a añadir el corredor
	 * @return Booleano indicando si la operacion se ha realizado correctamente
	 */
	public boolean asignarCorredor(int dniUsuario, int idCarrera) {
		try{
			helperParticipante.insertar(dniUsuario, idCarrera); 
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Elimina un usuario (corredor) de una carrera
	 * @param dniUsuario DNI del corredor que se quiere desasignar
	 * @param idCarrera identificador de la carrera de la que se quiere eliminar al corredor
	 * @return Booleano indicando si la operacion se ha realizado correctamente
	 */
	public boolean desasignarCorredor(int dniUsuario, int idCarrera) {
		try{
			helperParticipante.delete(dniUsuario, idCarrera);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Introduce el tiempo que un usuario (corredor) ha hecho en la carrera
	 * @param dniUsuario DNI del corredor que ha hecho el tiempo
	 * @param idCarrera identificador de la carrera en la que ha corrido el corredor anterior
	 * @param tiempo tiempo realizado por el corredor
	 * @return Booleano indicando si la operacion se ha realizado correctamente
	 */
	public boolean introducirTiempo(int dniUsuario, int idCarrera, int tiempo) {
		try {
			helperParticipante.insertarTiempo(dniUsuario, idCarrera, tiempo);  
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
