package Modelo;
// Generated 18-abr-2018 14:18:14 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Clase derivada de la tabla Jueces, generada por Hibernate
 */
@Entity
@Table(name = "jueces", catalog = "bbdd_g2")
public class Jueces implements java.io.Serializable {

	//Atributos
	private int dniJueces;
	private String nombreJueces;
	private String apellidosJueces;
	private String telefonoJueces;
	private int idcarreraJueces;
	private Date timestampJueces;
	private Set<Carrera> carreras = new HashSet<Carrera>(0); //?

	/**
	 * 	Contructor por defecto de la clase Jueces
	 */
	public Jueces() {
	}

	/**
	 * Contructor por par�metros de la clase Jueces.
	 * Crea un nuevo juez a partir de los siguientes par�metros:
	 * @param dniJueces. DNI del juez
	 * @param nombreJueces. Nombre dle juez
	 * @param apellidosJueces. Apellidos del juez
	 * @param telefonoJueces. Tel�fono del juez
	 */
	public Jueces(int dniJueces, String nombreJueces, String apellidosJueces, String telefonoJueces) {
		this.dniJueces = dniJueces;
		this.nombreJueces = nombreJueces;
		this.apellidosJueces = apellidosJueces;
		this.telefonoJueces = telefonoJueces;
	}

	/**
	 * Contructor por par�metros de la clase Jueces.
	 * Crea un nuevo juez a partir de los siguientes par�metros:
	 * @param dniJueces. DNI del juez
	 * @param nombreJueces. Nombre del juez
	 * @param apellidosJueces. Apellidos del juez
	 * @param telefonoJueces. Tel�fono del juez
	 * @param idcarreraJueces. Id de la carrea
	 * @param carreras. Set de carreras
	 */
	public Jueces(int dniJueces, String nombreJueces, String apellidosJueces, String telefonoJueces,
			int idcarreraJueces, Set<Carrera> carreras) {
		this.dniJueces = dniJueces;
		this.nombreJueces = nombreJueces;
		this.apellidosJueces = apellidosJueces;
		this.telefonoJueces = telefonoJueces;
		this.idcarreraJueces = idcarreraJueces;
		this.carreras = carreras;
	}

	/**
	 * M�todo de selecci�n/lectura del Identificador del juez
	 * Esta clase tiene el DNI del juez como clave unica y no puede ser null
	 * @return el identificador(DNI) del juez
	 */
	@Id
	@Column(name = "DNI_jueces", unique = true, nullable = false)
	public int getDniJueces() {
		return this.dniJueces;
	}

	/**
	 * M�todo para asignar el ID al juez
	 * @param dniJueces. DNI del juez
	 */
	public void setDniJueces(int dniJueces) {
		this.dniJueces = dniJueces;
	}

	/**
	 * M�todo de selecci�n/lectura del nombre del juez
	 * @return Nombre del juez
	 */
	@Column(name = "nombre_jueces", nullable = false, length = 45)
	public String getNombreJueces() {
		return this.nombreJueces;
	}

	/**
	 * M�todo para asignar el nombre al juez
	 * @param nombreJueces. Nuevo nombre que se le da al juez
	 */
	public void setNombreJueces(String nombreJueces) {
		this.nombreJueces = nombreJueces;
	}

	/**
	 * M�todo de selecci�n/lectura de los apellidos del juez
	 * @return Apellidos del juez
	 */
	@Column(name = "apellidos_jueces", nullable = false, length = 70)
	public String getApellidosJueces() {
		return this.apellidosJueces;
	}

	/**
	 * M�todo para asignar apellidos al juez
	 * @param apellidosJueces. Recibe por par�metro los apellidos del juez
	 */
	public void setApellidosJueces(String apellidosJueces) {
		this.apellidosJueces = apellidosJueces;
	}

	/**
	 * M�todo de selecci�n/lectura del tel�fono del juez
	 * @return Tel�fono del juez
	 */
	@Column(name = "telefono_jueces", nullable = false, length = 15)
	public String getTelefonoJueces() {
		return this.telefonoJueces;
	}

	/**
	 * M�todo para asignar tel�fono al juez
	 * @param telefonoJueces. Recibe por par�metro el tel�fono del juez
	 */
	public void setTelefonoJueces(String telefonoJueces) {
		this.telefonoJueces = telefonoJueces;
	}

	/**
	 * M�todo de selecci�n/lectura del ID de la carrera del juez
	 * @return ID de la carrera
	 */
	@Column(name = "idcarrera_jueces", nullable = false)
	public int getIdcarreraJueces() {
		return this.idcarreraJueces;
	}

	/**
	 * M�todo para asignar un id de carrera al juez
	 * @param idcarreraJueces. Id de la carrea a asignar
	 */
	public void setIdcarreraJueces(int idcarreraJueces) {
		this.idcarreraJueces = idcarreraJueces;
	}

	/**
	 * M�todo que retorna el TimeStamp del juez. Este par�metro lo controla Hibernate para
	 * manejar las versiones de los datos introducidos en la BBDD
	 * @return Time Stamp en el que ha sido creado/modificado
	 */
	@Version@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "version", nullable = false)
	public Date getTimestampJueces() {
		return this.timestampJueces;
	}

	/**
	 * M�todo para asignar el TimeStamp al juez
	 * @param timestampJueces. Nuevo TimeStamp que se quiere dar al juez
	 */
	public void setTimestampJueces(Date timestampJueces) {
		this.timestampJueces = timestampJueces;
	}

	/**
	 * M�todo para leer un Ser de carreras dek juez
	 * Relaci�n Lazy entre las entidades de Carrera y Jueces. Esta relaci�n es
	 * del tipo uno a muchos.
	 * @return Set de carreras del juez
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jueces")
	public Set<Carrera> getCarreras() {
		return this.carreras;
	}

	/**
	 * M�todo par asignar un Set de carreras al juez
	 * @param carreras. REcibe el set de carreras a asignar
	 */
	public void setCarreras(Set<Carrera> carreras) {
		this.carreras = carreras;
	}

}
