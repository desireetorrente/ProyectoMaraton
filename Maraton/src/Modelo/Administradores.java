package Modelo;
// Generated 18-abr-2018 14:18:14 by Hibernate Tools 4.3.1.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Clase derivada de la tabla Administradores generada por Hibernate
 */
@Entity
@Table(name = "administradores", catalog = "bbdd_g2")
public class Administradores implements java.io.Serializable {

	//Atributos
	private int dniAdministradores;
	private String nombreAdministradores;
	private String passwordAdministradores;
	private Date timeStamp;

	/**
	 * Contructor po defecto de la clase Administradores
	 */
	public Administradores() {
	}

	/**
	 * Contructor por parámetros de la clase Administradores.
	 * Crea un nuevo administrador a partir de los siguientes parámetros:
	 * @param dniAdministradores. DNI del Administrador
	 * @param nombreAdministradores. Nombre del Administrador
	 * @param passwordAdministradores. Contraseña que elige el Administrador
	 */
	public Administradores(int dniAdministradores, String nombreAdministradores, String passwordAdministradores) {
		this.dniAdministradores = dniAdministradores;
		this.nombreAdministradores = nombreAdministradores;
		this.passwordAdministradores = passwordAdministradores;
	}

	/**
	 * Método de selección/lectura del DNI del administrador
	 * Esta clase tiene el DNI como clave unica y no puede ser null
	 * @return Te retorna el DNI administrador.
	 */
	@Id
	@Column(name = "DNI_administradores", unique = true, nullable = false)
	public int getDniAdministradores() {
		return this.dniAdministradores;
	}

	/**
	 * Método para asignar el DNI del administador
	 * @param dniAdministradores. recibe un int que será el nuevo DNI que se lequiere asignar.
	 */
	public void setDniAdministradores(int dniAdministradores) {
		this.dniAdministradores = dniAdministradores;
	}

	/**
	 * Método de selección/lectura del nombre del administrador
	 * Esta clase tiene selecionado que el nombre no puede ser null
	 * @return Te retorna el nombre administrador.
	 */
	@Column(name = "nombre_administradores", nullable = false, length = 45)
	public String getNombreAdministradores() {
		return this.nombreAdministradores;
	}

	/**
	 * Método para asignar el nombre del administador
	 * @param nombreAdministradores. Nuevo nombre que se quiere dar al administrador
	 */
	public void setNombreAdministradores(String nombreAdministradores) {
		this.nombreAdministradores = nombreAdministradores;
	}
	
	/**
	 * Método de selección/lectura de la contraseña del administrador
	 * Esta clase tiene selecionado que la contraseña no puede ser null
	 * @return Retorna la contraseña del administrador
	 */
	@Column(name = "password_administradores", nullable = false, length = 45)
	public String getPasswordAdministradores() {
		return this.passwordAdministradores;
	}

	/**
	 * Método para asignar la contraseña al administrador
	 * @param passwordAdministradores. Nueva contraseña que se le quiere asignar al administrador
	 */
	public void setPasswordAdministradores(String passwordAdministradores) {
		this.passwordAdministradores = passwordAdministradores;
	}

	/**
	 * Método que retorna el TimeStamp del administrador. Este parámetro lo controla Hibernate para
	 * manejar las versiones de los datos introducidos en la BBDD
	 * @return Time Stamp en la que el administrador ha sido creado/modificado
	 */
	@Version@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "version", nullable = false)
	public Date getFecha() {
		return this.timeStamp;
	}

	/**
	 * Método para asignar el TimeStamp al administrador
	 * @param timeStamp. Nuevo Time Stamp que se quiere dar al adminsitrador
	 */
	public void setFecha(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
