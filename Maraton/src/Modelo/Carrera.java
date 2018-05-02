package Modelo;
// Generated 18-abr-2018 14:18:14 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Clase derivada de la tabla Carrera, generada por Hibernate
 */
@Entity
@Table(name = "carrera", catalog = "bbdd_g2")
public class Carrera implements java.io.Serializable {

	//Atributos
	private Integer idcarreraCarrera;
	private Jueces jueces;
	private String nombreCarrera;
	private String distanciaCarrera;
	private String altitudCarrera;
	private Date timestampCarrera;
	private Set<Participantes> participanteses = new HashSet<Participantes>(0);

	/**
	 * 	Contructor po defecto de la clase Carrera
	 */
	public Carrera() {
		
	}
	
	/**
	 * Contructor por parámetros de la clase Carrera.
	 * Crea una nueva carrera a partir de los siguientes parámetros:
	 * @param nombreCarrera. Nombre de la carrera
	 * @param distanciaCarrera. Distancia de la carrera
	 * @param altitudCarrera. Diferencia de altitud de la carrera
	 */
	public Carrera(String nombreCarrera, String distanciaCarrera, String altitudCarrera) {
		this.nombreCarrera = nombreCarrera;
		this.distanciaCarrera = distanciaCarrera;
		this.altitudCarrera = altitudCarrera;
	}

	/**
	 * Contructor por parámetros de la clase Carrera.
	 * Crea una nueva carrera a partir de los siguientes parámetros:
	 * @param jueces. Juez asignado a la carrera
	 * @param nombreCarrera.Nombre de la carrera
	 * @param distanciaCarrera. Distancia de la carrera
	 * @param altitudCarrera. Diferencia de altitud de la carrera
	 */
	public Carrera(Jueces jueces, String nombreCarrera, String distanciaCarrera, String altitudCarrera) {
		this.jueces = jueces;
		this.nombreCarrera = nombreCarrera;
		this.distanciaCarrera = distanciaCarrera;
		this.altitudCarrera = altitudCarrera;

	}

	/**
	 * ontructor por parámetros de la clase Carrera.
	 * Crea una nueva carrera a partir de los siguientes parámetros:
	 * @param jueces. Juez asignado a la carrera
	 * @param nombreCarrera. Nombre de la carrera
	 * @param distanciaCarrera. Distancia de la carrera
	 * @param altitudCarrera. Diferencia de altitud de la carrera
	 * @param participanteses. Set de participantes inscritos en la carrera
	 */
	public Carrera(Jueces jueces, String nombreCarrera, String distanciaCarrera, String altitudCarrera, Set<Participantes> participanteses) {

		this.jueces = jueces;
		this.nombreCarrera = nombreCarrera;
		this.distanciaCarrera = distanciaCarrera;
		this.altitudCarrera = altitudCarrera;
		this.participanteses = participanteses;
	}

	/**
	 * Método de selección/lectura del Identificador de la carrera
	 * Esta clase tiene el IdCarrera como clave unica y no puede ser null
	 * @return el Identificador(ID) de la carrera
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idcarrera_carrera", unique = true, nullable = false)
	public Integer getIdcarreraCarrera() {
		return this.idcarreraCarrera;
	}

	/**
	 * Método para asignar el ID a la carrera
	 * @param idcarreraCarrera. Recibe un Integer que será el nuevo ID de la carrera
	 */
	public void setIdcarreraCarrera(Integer idcarreraCarrera) {
		this.idcarreraCarrera = idcarreraCarrera;
	}

	/**
	 * Método de lectura del Juez asignado a la carrera.
	 * Relación Lazy entre las entidades de Carrera y Jueces. Esta relación es
	 * del tipo muchos a uno.
	 * @return retorna el juez
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DNI_jueces")
	public Jueces getJueces() {
		return this.jueces;
	}

	/**
	 * Método para introducir un juez en la carrera
	 * @param jueces. Recibe el juez a asignar
	 */
	public void setJueces(Jueces jueces) {
		this.jueces = jueces;
	}

	/**
	 * Método de selección/lectura del nombre de la carrera
	 * @return Nombre de la carrera
	 */
	@Column(name = "nombre_carrera", nullable = false, length = 45)
	public String getNombreCarrera() {
		return this.nombreCarrera;
	}

	/**
	 * Método para asignar el nombre a la carrera
	 * @param nombreCarrera. Nuevo nombre que se le da a la carrera
	 */
	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	/**
	 * Método de selección/lectura de la distancia de la carrera
	 * @return Distancia de la carrera
	 */
	@Column(name = "distancia_carrera", nullable = false, length = 11)
	public String getDistanciaCarrera() {
		return this.distanciaCarrera;
	}

	/**
	 * Método para asignar la distancia a la carrera
	 * @param distanciaCarrera. Recibe la nueva distancia que se le quiere dar a al carrera
	 */
	public void setDistanciaCarrera(String distanciaCarrera) {
		this.distanciaCarrera = distanciaCarrera;
	}

	/**
	 * Método de selección/lectura de la altura de la carrera
	 * @return Diferencia de altitud de la carrera
	 */
	@Column(name = "altitud_carrera", nullable = false, length = 11)
	public String getAltitudCarrera() {
		return this.altitudCarrera;
	}

	/**
	 * Método para asignar la diferencia de altitud a la carrera
	 * @param altitudCarrera. Recibe la nueva altura que se le quiere dar a al carrera
	 */
	public void setAltitudCarrera(String altitudCarrera) {
		this.altitudCarrera = altitudCarrera;
	}

	/**
	 * Método que retorna el TimeStamp de la carrera. Este parámetro lo controla Hibernate para
	 * manejar las versiones de los datos introducidos en la BBDD
	 * @return Time Stamp en la que la carrera ha sido creado/modificado
	 */
	@Version@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "version", nullable = false)
	public Date getTimestampCarrera() {
		return this.timestampCarrera;
	}
	
	/**
	 * Método para asignar el TimeStamp a la carrera
	 * @param timestampCarrera. Nuevo TimeStamp que se quiere dar a la carrera
	 */
	public void setTimestampCarrera(Date timestampCarrera) {
		this.timestampCarrera = timestampCarrera;
	}

	/**
	 * Método para leer un set de participantes de la carrera
	 * Relación Lazy entre las entidades de Carrera y Participantes. Esta relación es
	 * del tipo uno a muchos.
	 * @return Set de participantes en la carrera
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "carrera")
	public Set<Participantes> getParticipanteses() {
		return this.participanteses;
	}

	/**
	 * Método para asignar un set de participantes a la carrera
	 * @param participanteses. Recibe el Set de participantes a asignar
	 */
	public void setParticipanteses(Set<Participantes> participanteses) {
		this.participanteses = participanteses;
	}

}
