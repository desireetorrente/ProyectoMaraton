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
 * Participantes generated by hbm2java
 */
@Entity
@Table(name = "participantes", catalog = "bbdd_g2")
public class Participantes implements java.io.Serializable {

	private ParticipantesId id;
	private Carrera carrera;
	private Usuarios usuarios;

	public Participantes() {
	}

	public Participantes(ParticipantesId id, Carrera carrera, Usuarios usuarios) {
		this.id = id;
		this.carrera = carrera;
		this.usuarios = usuarios;
	}

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

	public void setId(ParticipantesId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcarrera_carrera", nullable = false, insertable = false, updatable = false)
	public Carrera getCarrera() {
		return this.carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dni_usuarios", nullable = false, insertable = false, updatable = false)
	public Usuarios getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

}
