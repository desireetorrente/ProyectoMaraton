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
 * Clase derivada de la tabla Usuarios, generada por Hibernate
 */
@Entity
@Table(name = "usuarios", catalog = "bbdd_g2")
public class Usuarios implements java.io.Serializable {

	//Atributos
	private int dniUsuarios;
	private String nombreUsuarios;
	private String apellidosUsuarios;
	private String emailUsuarios;
	private String passwordUsuarios;
	private int edadUsuarios;
	private String cpUsuarios;
	private String telefonoUsuarios;
	private Date timestampUsuarios;
	private Set<Participantes> participanteses = new HashSet<Participantes>(0);

	/**
	 * 	Contructor por defecto de la clase Usuarios
	 */
	public Usuarios() {
	}

	/**
	 * Contructor por par�metros de la clase Usuarios.
	 * Crea un nuevo usuario a partir de los siguientes par�metros:
	 * @param dniUsuarios. Dni del usuario
	 * @param nombreUsuarios. Nombre del usuario
	 * @param apellidosUsuarios. Apellidos del usuario
	 * @param emailUsuarios. Email del usuario
	 * @param passwordUsuarios. Contrase�a del usuario
	 * @param edadUsuarios. Edad del usuario
	 * @param cpUsuarios. C�digo Postal del usuario
	 * @param telefonoUsuarios. Tel�fono del usuario
	 */
	public Usuarios(int dniUsuarios, String nombreUsuarios, String apellidosUsuarios, String emailUsuarios,
			String passwordUsuarios, int edadUsuarios, String cpUsuarios, String telefonoUsuarios) {
		this.dniUsuarios = dniUsuarios;
		this.nombreUsuarios = nombreUsuarios;
		this.apellidosUsuarios = apellidosUsuarios;
		this.emailUsuarios = emailUsuarios;
		this.passwordUsuarios = passwordUsuarios;
		this.edadUsuarios = edadUsuarios;
		this.cpUsuarios = cpUsuarios;
		this.telefonoUsuarios = telefonoUsuarios;
	}

	/**
	 * Contructor por par�metros de la clase Usuarios.
	 * Crea un nuevo usuario a partir de los siguientes par�metros:
	 * @param dniUsuarios. Dni del usuario
	 * @param nombreUsuarios. Nombre del usuario
	 * @param apellidosUsuarios. Apellidos del usuario
	 * @param emailUsuarios. Email del usuario
	 * @param passwordUsuarios. Contrase�a del usuario
	 * @param edadUsuarios. Edad del usuario
	 * @param cpUsuarios. C�digo Postal del usuario
	 * @param telefonoUsuarios. Tel�fono del usuario
	 * @param participanteses. Set de participantes
	 */
	public Usuarios(int dniUsuarios, String nombreUsuarios, String apellidosUsuarios, String emailUsuarios,
			String passwordUsuarios, int edadUsuarios, String cpUsuarios, String telefonoUsuarios, Set<Participantes> participanteses) {
		this.dniUsuarios = dniUsuarios;
		this.nombreUsuarios = nombreUsuarios;
		this.apellidosUsuarios = apellidosUsuarios;
		this.emailUsuarios = emailUsuarios;
		this.passwordUsuarios = passwordUsuarios;
		this.edadUsuarios = edadUsuarios;
		this.cpUsuarios = cpUsuarios;
		this.telefonoUsuarios = telefonoUsuarios;
		this.participanteses = participanteses;
	}

	/**
	 * M�todo de selecci�n/lectura del DNI (identificador) del usuario.
	 * Esta clase tiene el DNI del usuario como clave unica y no puede ser null
	 * @return el identificador(DNI) del usuario
	 */
	@Id
	@Column(name = "DNI_usuarios", unique = true, nullable = false)
	public int getDniUsuarios() {
		return this.dniUsuarios;
	}

	/**
	 * M�todo para asignar el DNI al usuario
	 * @param dniUsuarios. DNI dle usuario
	 */
	public void setDniUsuarios(int dniUsuarios) {
		this.dniUsuarios = dniUsuarios;
	}

	/**
	 * M�todo de selecci�n/lectura del nombre del usuario
	 * @return. Nombre del usuario
	 */
	@Column(name = "nombre_usuarios", nullable = false, length = 45)
	public String getNombreUsuarios() {
		return this.nombreUsuarios;
	}

	/**
	 * M�todo para asignar el nombre al usuario
	 * @param nombreUsuarios. Nuevo nombre que se le da al usuario
	 */
	public void setNombreUsuarios(String nombreUsuarios) {
		this.nombreUsuarios = nombreUsuarios;
	}

	/**
	 * M�todo de selecci�n/lectura de los apellidos del usuario
	 * @return Apellidos del usuario
	 */
	@Column(name = "apellidos_usuarios", nullable = false, length = 70)
	public String getApellidosUsuarios() {
		return this.apellidosUsuarios;
	}

	/**
	 * M�todo para asignar apellidos al usuario
	 * @param apellidosUsuarios. Recibe por par�metros los apellidos del usuario
	 */
	public void setApellidosUsuarios(String apellidosUsuarios) {
		this.apellidosUsuarios = apellidosUsuarios;
	}

	/**
	 * M�todo de selecci�n/lectura del email del usuario
	 * @return email del usuario
	 */
	@Column(name = "email_usuarios", nullable = false, length = 50)
	public String getEmailUsuarios() {
		return this.emailUsuarios;
	}

	/**
	 * M�todo de asignaci�n del email del usuario
	 * @param emailUsuarios. Recibe por par�metro el email del usuario
	 */
	public void setEmailUsuarios(String emailUsuarios) {
		this.emailUsuarios = emailUsuarios;
	}

	/**
	 * M�todo de selecci�n/lectura de la contrase�a del usuario
	 * @return contrase�a del usuario
	 */
	@Column(name = "password_usuarios", nullable = false, length = 45)
	public String getPasswordUsuarios() {
		return this.passwordUsuarios;
	}

	/**
	 * M�todo de asignaci�n de la contrase�a del usuario
	 * @param passwordUsuarios. Recibe por par�metro la contrase�a del usuario
	 */
	public void setPasswordUsuarios(String passwordUsuarios) {
		this.passwordUsuarios = passwordUsuarios;
	}

	/**
	 *  M�todo de selecci�n/lectura de la edad del usuario
	 * @return edad del usuario. 
	 */
	@Column(name = "edad_usuarios", nullable = false)
	public int getEdadUsuarios() {
		return this.edadUsuarios;
	}

	/**
	 * M�todo de asignaci�n de la edad del usuario
	 * @param edadUsuarios. Recibe por par�metro la edad del usuario
	 */
	public void setEdadUsuarios(int edadUsuarios) {
		this.edadUsuarios = edadUsuarios;
	}

	/**
	 * M�todo de selecci�n/lectura del C�digo Postal (CP) del usuario
	 * @return CP del usuario
	 */
	@Column(name = "cp_usuarios", nullable = false, length = 10)
	public String getCpUsuarios() {
		return this.cpUsuarios;
	}

	/**
	 * M�todo de asignaci�n del CP del usuario
	 * @param cpUsuarios. REcibe por par�metro el CP del usuario
	 */
	public void setCpUsuarios(String cpUsuarios) {
		this.cpUsuarios = cpUsuarios;
	}

	/**
	 * M�todo de selecci�n/lectura del tel�fono del usuario
	 * @return tel�fono del usuario
	 */
	@Column(name = "telefono_usuarios", nullable = false, length = 15)
	public String getTelefonoUsuarios() {
		return this.telefonoUsuarios;
	}

	/**
	 * M�todo de asignaci�n del tel�fono del usuario
	 * @param telefonoUsuarios. Recibe por par�metro el tel�fono del usuario
	 */
	public void setTelefonoUsuarios(String telefonoUsuarios) {
		this.telefonoUsuarios = telefonoUsuarios;
	}

	/**
	 * M�todo que retorna el TimeStamp del usuario. Este par�metro lo controla Hibernate para
	 * manejar las versiones de los datos introducidos en la BBDD
	 * @return TimeStamp en el que ha sido creado/modificado
	 */
	@Version@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "version", nullable = false)
	public Date getTimestampUsuarios() {
		return this.timestampUsuarios;
	}

	/**
	 * M�todo para asignar el TimeStamp al usuario
	 * @param timestampUsuarios. Recibe el TimeStamp por par�metro
	 */
	public void setTimestampUsuarios(Date timestampUsuarios) {
		this.timestampUsuarios = timestampUsuarios;
	}

	/**
	 * M�todo para leer un Set de participantes
	 * Relaci�n Lazy entre las entidades de Usuarios y Participantes. Esta relaci�n
	 * es de uno a muchos.
	 * @return Set de participantes
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
	public Set<Participantes> getParticipanteses() {
		return this.participanteses;
	}

	/**
	 * M�todo para asignar un Set de participantes
	 * @param participanteses. Recibe el Set de participantes
	 */
	public void setParticipanteses(Set<Participantes> participanteses) {
		this.participanteses = participanteses;
	}

}
