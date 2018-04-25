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
	 * Cambia nombre de una carrera
	 * @param carreraCambiarNombre Objeto carrera a modificar
	 * @param nuevoNombre Nuevo nombre para la carrera
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
	 * @param juezInsertar Juez que se quiere introducir en la carrera
	 * @param carrera Carrera a la cual se quiere introducir el juez
	 * @return Booleano que indica si se ha realizado bien la operacion de inserccion 
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
	 * @param juezDesvincular Objeto tipo juez que se quiere desvincular
	 * @param carrera Carrera a la cual queremos desvincular el juez
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
	 * Añade corredor a la carrera
	 * @param corredorVincular Corredor que se va a añadir
	 * @param carrera Carrrera a la cual se va a añadir
	 * @return Booleano a la cual
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
	
	public boolean desasignarCorredor(int dniUsuario, int idCarrera) {
		try{
			helperParticipante.delete(dniUsuario, idCarrera);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
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
