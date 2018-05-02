package Modelo;
// Generated 18-abr-2018 14:18:14 by Hibernate Tools 4.3.1.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *  Clase derivada de la tabla Participantes, generada por Hibernate
 */
@Entity
@Table(name = "participantes", catalog = "bbdd_g2")
public class Participantes implements java.io.Serializable {

	//Atributos
	private ParticipantesId id;
	private Carrera carrera;
	private Usuarios usuarios;

	/**
	 * 	Contructor por defecto de la clase Participantes
	 */
	public Participantes() {
	}

	/**
	 * Contructor por parámetros de la clase Participantes.
	 * Crea un nuevo juez a partir de los siguientes parámetros:
	 * @param id. Objeto del tipo ParticipantesID
	 * @param carrera. Objeto del tipo Carrera
	 * @param usuarios. Objeto del tipo Usuario
	 */
	public Participantes(ParticipantesId id, Carrera carrera, Usuarios usuarios) {
		this.id = id;
		this.carrera = carrera;
		this.usuarios = usuarios;
	}

	/**
	 * Esta clase Participantes embebe la calse participantesId en la que están
	 * los datos del participante como su DNI, dorsal...
	 * El método recoge/lee los datos del participantesId
	 * @return Retorna el objeto del tipo participanteId
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "dniUsuarios", column = @Column(name = "dni_usuarios", nullable = false)),
			@AttributeOverride(name = "idcarreraCarrera", column = @Column(name = "idcarrera_carrera", nullable = false)),
			@AttributeOverride(name = "dorsalParticipantes", column = @Column(name = "dorsal_participantes", nullable = false)),
			@AttributeOverride(name = "tiempoParticipantes", column = @Column(name = "tiempo_participantes")),
			@AttributeOverride(name = "valor", column = @Column(name = "valor")) })
	public ParticipantesId getId() {
		return this.id;
	}

	/**
	 * Método para asignar Id
	 * @param id. Objeto id del tipo ParticipantesID
	 */
	public void setId(ParticipantesId id) {
		this.id = id;
	}

	/**
	 * Método para leer el objeto del tipo Carrera que hay dentro de Participantes
	 * @return Retorna el objeto del tipo carrera
	 * Relación Lazy de muchas a uno entre carrera y participantes
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcarrera_carrera", nullable = false, insertable = false, updatable = false)
	public Carrera getCarrera() {
		return this.carrera;
	}

	/**
	 * Método para asignar un objeto del tipo Carrera al participante
	 * @param carrera. Recibe el objeto del tipo Carrera por parámetro
	 */
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	/**
	 * Método para leer el objeto del tipo Usuarios que hay en Partcipantes
	 * Relación lazy de muchos a uno entre Usuarios y Participantes
	 * @return Retorna un objeto del tipo Usuarios
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dni_usuarios", nullable = false, insertable = false, updatable = false)
	public Usuarios getUsuarios() {
		return this.usuarios;
	}

	/**
	 * Método para asignar un objeto del tipo Usuarios a Participantes
	 * @param usuarios. Objeto Usuarios a asignar
	 */
	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

}
