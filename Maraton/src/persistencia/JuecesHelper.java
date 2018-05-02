package persistencia;

import org.hibernate.query.Query;

import Modelo.Administradores;
import Modelo.Jueces;
import Modelo.Participantes;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author admin
 * @version 20/04/2018
 * Clase para manejar la persistencia de datos de la tabla jueces
 *
 */
public class JuecesHelper {
	
	//atributos
	private Configuration cfg;

	/**
	 * Contructor de la clase
	 */
	public JuecesHelper() {
		this.cfg = new Configuration();
	}

	/**
	 * Método para insertar un nuevo juez en la BBDD
	 * @param juez. Nuevo juez que se quiere insertar
	 */
	public void insertar(Jueces juez) {

		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(juez);
		tx.commit();
		session.close();
	}

	/**
	 *  Método que elimina un juez de la BBDD
	 * @param dniJueces. DNI del juez que se quiere eliminar
	 */
	public void delete(int dniJueces) {

		Jueces juez = null;
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			Query q = session.createQuery(
					"from Jueces as juez where juez.dniJueces = " + dniJueces);
			juez = (Jueces) q.uniqueResult();
			session.delete(juez);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			session.close();
		}
	}

	/**
	 * Método para modificar un juez que ya existe en la BBDD
	 * @param dniJueces. DNI del Juez a modificar
	 * @param nombreJueces. Nombre del Juez
	 * @param apellidosJueces. Apellidos del Juez
	 * @param telefonoJueces. Telefono del Juez
	 */
	public void change(int dniJueces, String nombreJueces, String apellidosJueces, String telefonoJueces) {

		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			Query q = session.createQuery(
					"from Jueces as juez where juez.dniJueces = " + dniJueces);
			Jueces juez = new Jueces();
			juez = session.load(Jueces.class, dniJueces); // Cargamoms objeto bbdd
			juez.setNombreJueces(nombreJueces);
			juez.setApellidosJueces(apellidosJueces);
			juez.setTelefonoJueces(telefonoJueces);
			session.update(juez);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			session.close();
		}
	}
	
	/**
	 * Metodo para buscar un juez
	 * @param dniJueces. DNI del juez a busar
	 * @return Juez encontrado.
	 */
	
	public Jueces Buscar(int dniJueces) {

		Jueces juez = null;
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			Query q = session.createQuery("from Jueces as juez where juez.dniJueces = " + dniJueces);
			juez = (Jueces) q.uniqueResult();
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			System.err.println("No se pudo encontrar al juez");
			e.printStackTrace();
			tx.rollback();
			session.close();
		}
		if (juez == null) {
			System.out.println("El juez no existe");
		}
		return juez;
	}
	
	/**
	 * Lista los jueces
	 * @return lista de jueces
	 */
	
	public List<Jueces> imprimirJueces(){
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		List<Jueces> jueces = new ArrayList<>();
		
		try {
			Query query = session.createQuery("SELECT j FROM Jueces j");
			jueces = query.list();
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			session.close();
		}
		return jueces;
	}

}
