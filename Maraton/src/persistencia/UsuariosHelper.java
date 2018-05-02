package persistencia;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Modelo.Carrera;
import Modelo.Usuarios;

/**
 * @author admin
 * @version 19/04/2018 Clase para manejar la persistencia de datos de la tabla usuarios
 */
public class UsuariosHelper {

	// Atributos
	private Configuration cfg;
	private ParticipantesHelper participantesHelper = new ParticipantesHelper();
	
	/**
	 * Constructor de la clase
	 */
	
	public UsuariosHelper() {
		this.cfg = new Configuration();

	}

	/**
	 * Método para insertar un nuevo usuario en la BBDD
	 * Se comprueba primero que el usuario no está creado en la BBDD
	 * @param user.Nuevo usuario que se quiere insertar
	 * @return Booleano que indica si se ha podido crear el nuevo usuario o no
	 */
	public int insertar(Usuarios user) {

		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		if(search(user.getDniUsuarios()) == null) {
			try {
				session.save(user);
				tx.commit();
				session.close();
			}catch(Exception e) {
				e.printStackTrace();
				session.close();	
			}
			return 0;
		}else {
			return 1;
		}

	}
	
	/**
	 * Método para listar los usuarios que hay inscritos en la BBDD
	 * @return Lista de usuarios.
	 */
	public List <Usuarios> listarUsuarios(){
		
		List<Usuarios>usuarios = null;
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Query query = session.createQuery("FROM Usuarios");
		
		usuarios = (List<Usuarios>) query.list();
		
        return usuarios;
	}

	/**
	 * Método que elimina un usuario de la BBDD
	 * @param dniUsuarios.DNI del usuario que se quiere borrar
	 */
	public void delete(int dniUsuarios) {

		Usuarios user = null;
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			Query q = session.createQuery("from Usuarios as user where user.dniUsuarios = " + dniUsuarios);
			user = (Usuarios) q.uniqueResult();
			session.delete(user);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			session.close();
		}

	}
	
	public void totalDelete(int dniUsuario) {
		if(participantesHelper.buscar(dniUsuario) != null) {
			for(int i = 0; i<participantesHelper.buscar(dniUsuario).size();i++) {
				participantesHelper.delete(dniUsuario, participantesHelper.buscar(dniUsuario).get(i).getId().getIdcarreraCarrera());
			}
			delete(dniUsuario);
		}else {
			delete(dniUsuario);
		}
	}

	/**
	 * Método para modificar un usuario queya existe en la BBDD
	 * @param dniUsuarios.DNI del usuario a modificar
	 * @param nombreUsuarios.Nombre del Usuario
	 * @param apellidosUsuarios.Apellidos del Usuario
	 * @param emailUsuarios.Email del Usuario
	 * @param passwordUsuarios.Password elegida por el Usuario
	 * @param edadUsuarios.Edad del Usuario
	 * @param cpUsuarios.Codigo Postal del Usuario
	 * @param telefonoUsuarios.Telefono del Usuario
	 */
	public void change(int dniUsuarios, String nombreUsuarios, String apellidosUsuarios, String emailUsuarios,
			String passwordUsuarios, int edadUsuarios, String cpUsuarios, String telefonoUsuarios) {

		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			Query q = session.createQuery("from Usuarios as user where user.dniUsuarios = " + dniUsuarios);
			Usuarios user = new Usuarios();
			user = session.load(Usuarios.class, dniUsuarios); 
			user.setNombreUsuarios(nombreUsuarios);
			user.setApellidosUsuarios(apellidosUsuarios);
			user.setEmailUsuarios(emailUsuarios);
			user.setPasswordUsuarios(passwordUsuarios);
			user.setEdadUsuarios(edadUsuarios);
			user.setCpUsuarios(cpUsuarios);
			user.setTelefonoUsuarios(telefonoUsuarios);
			session.update(user);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			session.close();
		}
	}

	/**
	 * Método para buscar usuarios por su dni
	 * @param dniUsuarios. DNI del usuario
	 */
	public Usuarios search(int dniUsuarios) {

		Usuarios user = null;
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			Query q = session.createQuery("from Usuarios as user where user.dniUsuarios = " + dniUsuarios);
			user = (Usuarios) q.uniqueResult();
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			System.err.println("No se pudo encontrar al usuario");
			e.printStackTrace();
			tx.rollback();
			session.close();
		}
		return user;

	}

}
