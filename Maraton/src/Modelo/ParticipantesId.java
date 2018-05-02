package Modelo;
// Generated 18-abr-2018 14:18:14 by Hibernate Tools 4.3.1.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase derivada de la tabla Participantes, generada por Hibernate
 * Para el uso de Hibernate se ha separado la tabla auxilar Participantes en:
 * -Clase Participantes y 
 * -Clase ParticipantesID
 */
@Embeddable
public class ParticipantesId implements java.io.Serializable {

	//Atributos
	private int dniUsuarios;
	private int idcarreraCarrera;
	private int dorsalParticipantes;
	private Integer tiempoParticipantes;
	private Date timestampParticipantes;

	/**
	 * Constructor po defecto de la calse ParticipantesID
	 */
	public ParticipantesId() {
	}

	/**
	 * Constructor por parámetros de la clase ParticipantesId.
	 * Crea un nuevo ParticipanteId a partir de los siguientes parámetros:
	 * @param dniUsuarios. DNI del participante
	 * @param idcarreraCarrera. ID de la carrera
	 * @param dorsalParticipantes. Número de dorsal del participante
	 */
	public ParticipantesId(int dniUsuarios, int idcarreraCarrera, int dorsalParticipantes) {
		this.dniUsuarios = dniUsuarios;
		this.idcarreraCarrera = idcarreraCarrera;
		this.dorsalParticipantes = dorsalParticipantes;
	}

	/**
	 * Constructor por parámetros de la clase ParticipantesId.
	 * Crea un nuevo ParticipanteId a partir de los siguientes parámetros:
	 * @param dniUsuarios. DNI del participante
	 * @param idcarreraCarrera. ID de la carrera
	 * @param dorsalParticipantes. Número de dorsal del participante
	 * @param tiempoParticipantes. Tiempo que ha realizado el participante en la carrera
	 */
	public ParticipantesId(int dniUsuarios, int idcarreraCarrera, int dorsalParticipantes, Integer tiempoParticipantes) {
		this.dniUsuarios = dniUsuarios;
		this.idcarreraCarrera = idcarreraCarrera;
		this.dorsalParticipantes = dorsalParticipantes;
		this.tiempoParticipantes = tiempoParticipantes;
	}

	/**
	 * Método para leer el DNI del participante
	 * @return DNI del participante
	 */
	@Column(name = "dni_usuarios", nullable = false)
	public int getDniUsuarios() {
		return this.dniUsuarios;
	}

	/**
	 * Método para asignar DNI al participante
	 * @param dniUsuarios. DNI del participante
	 */
	public void setDniUsuarios(int dniUsuarios) {
		this.dniUsuarios = dniUsuarios;
	}
	
	/**
	 * Método para consultar el Id de la carrera
	 * @return Id de la carrera
	 */
	@Column(name = "idcarrera_carrera", nullable = false)
	public int getIdcarreraCarrera() {
		return this.idcarreraCarrera;
	}

	/**
	 * Método para asignarle un Id de carrera
	 * @param idcarreraCarrera. Id de carrera
	 */
	public void setIdcarreraCarrera(int idcarreraCarrera) {
		this.idcarreraCarrera = idcarreraCarrera;
	}

	/**
	 * Método para leer el dorsal del participante
	 * @return número de dorsal
	 */
	@Column(name = "dorsal_participantes")
	public int getDorsalParticipantes() {
		return this.dorsalParticipantes;
	}

	/**
	 * Método para asignar el dorsal al participante
	 * @param dorsalParticipantes. Número de dorsal a asignar
	 */
	public void setDorsalParticipantes(int dorsalParticipantes) {
		this.dorsalParticipantes = dorsalParticipantes;
	}

	/**
	 * Método para consultar el tiempo que ha realizado el participante
	 * en la carrera
	 * @return Tiempo del participante
	 */
	@Column(name = "tiempo_participantes")
	public Integer getTiempoParticipantes() {
		return this.tiempoParticipantes;
	}

	/**
	 * Método para asignar el tiempo a un participante
	 * @param tiempoParticipantes. Tiempo que ha realizado el participante
	 */
	public void setTiempoParticipantes(Integer tiempoParticipantes) {
		this.tiempoParticipantes = tiempoParticipantes;
	}
	/**
	 * Método que retorna el TimeStamp del participante. Este parámetro lo controla Hibernate para
	 * manejar las versiones de los datos introducidos en la BBDD
	 * @return Time Stamp en el que ha sido creado/modificado
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "version")
	public Date getTimestampParticipantes() {
		return this.timestampParticipantes;
	}

	/**
	 * Método para asignar el TimeStamp al participante
	 * @param timestampParticipantes. Nuevo TimeStamp que se quiere dar al participante
	 */
	public void setTimestampParticipantes(Date timestampParticipantes) {
		this.timestampParticipantes = timestampParticipantes;
	}

	/**
	 * Método generado por Hibernate
	 */
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ParticipantesId))
			return false;
		ParticipantesId castOther = (ParticipantesId) other;

		return (this.getDniUsuarios() == castOther.getDniUsuarios())
				&& (this.getIdcarreraCarrera() == castOther.getIdcarreraCarrera())
				&& (this.getDorsalParticipantes() == castOther.getDorsalParticipantes())
				&& ((this.getTiempoParticipantes() == castOther.getTiempoParticipantes())
						|| (this.getTiempoParticipantes() != null && castOther.getTiempoParticipantes() != null
								&& this.getTiempoParticipantes().equals(castOther.getTiempoParticipantes())))
				&& ((this.getTimestampParticipantes() == castOther.getTimestampParticipantes())
						|| (this.getTimestampParticipantes() != null && castOther.getTimestampParticipantes() != null
								&& this.getTimestampParticipantes().equals(castOther.getTimestampParticipantes())));
	}

	/**
	 * Método generado por Hibernate
	 */
	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getDniUsuarios();
		result = 37 * result + this.getIdcarreraCarrera();
		result = 37 * result + this.getDorsalParticipantes();
		result = 37 * result + (getTiempoParticipantes() == null ? 0 : this.getTiempoParticipantes().hashCode());
		result = 37 * result + (getTimestampParticipantes() == null ? 0 : this.getTimestampParticipantes().hashCode());
		return result;
	}

}
