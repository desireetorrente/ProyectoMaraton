package persistencia;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import Modelo.Carrera;
import Modelo.Jueces;

/**
 * Clase que contiene las conexiones de carreras a la bbdd
 */

public class CarrerasHelper {

	private Configuration cfg;
	
	/**
	 * constructor por defecto
	 * @param cfg. inicia el objeto configuracion
	 */
	
	public CarrerasHelper() {
		this.cfg = new Configuration();
	}
	
	/**
	 * Metodo para insertar una carrera a la bbdd
	 * @param car. Carrera a insertar
	 */
	
	public void insertar(Carrera car) {
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();		
		Transaction tx = session.beginTransaction();
		
		session.save(car);
		tx.commit();
		session.close();
	}
	
	
	/**
	 * Metodo que elimina una carrera
	 * @param idCarrera. ID de la carrera a eliminar
	 */
	
	public void delete(int idCarrera) {
		
		Carrera car = null;
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		
		try {
			Query q = session.createQuery("from Carrera as car where car.idcarreraCarrera = " + idCarrera);
			car = (Carrera) q.uniqueResult();
			session.delete(car);
			tx.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			session.close();
		}	
	}	
	
	/**
	 * Metodo para modificar una carrera
	 * @param idCarrera. id de la carrera
	 * @param nombreCarrera. Nuevo nombre de la carrera
	 * @param distanciaCarrera. nueva distancia de la carrera
	 * @param altitudCarrera. nueva altitu de la carrera
	 */
	
	public void cambiar(int idCarrera, String nombreCarrera, String distanciaCarrera, String altitudCarrera) {

		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		
		try { 
			Query q = session.createQuery("from Carrera as car where car.idcarreraCarrera = " + idCarrera);
			Carrera car = new Carrera();
			car = session.load(Carrera.class, idCarrera); //CArgamoms objeto bbdd
			car.setNombreCarrera(nombreCarrera);
			car.setDistanciaCarrera(distanciaCarrera);
			car.setAltitudCarrera(altitudCarrera);
			
			session.update(car);
			tx.commit();
			session.close();	
		}catch (Exception e){
			e.printStackTrace();
			tx.rollback();
			session.close();
		}
		
	}
	
	/**
	 * metodo que lista las carreras.
	 * @return una lista con las carreras.
	 */
		
	public List<Carrera> listarCarrera() {
		
		List <Carrera>carreras = null;
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Query query = session.createQuery("FROM Carrera");
		
		carreras = (List<Carrera>) query.list();
		
        return carreras;
        
    }
	
	/**
	 * Metodo que inserta un juez a una carrera
	 * @param juez. juez a insertar
	 * @param idCarrera. ID de la carrera a la que se le asigna el juez
	 */
	
	public void insertar_juez(Jueces juez, int idCarrera) {
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		
		try { 
			Query q = session.createQuery("from Carrera as car where car.idcarreraCarrera = " + idCarrera);
			Carrera car = new Carrera();
			car = session.load(Carrera.class, idCarrera); //Cargamoms objeto bbdd
			car.setJueces(juez);			
			session.update(car);
			tx.commit();
			session.close();	
		}catch (Exception e){
			e.printStackTrace();
			tx.rollback();
			session.close();
		}
		
		
	}
	
	/**
	 * Metodo que quita un juez de una carrera
	 * @param idCarrera. Id de la carrera a la que se le va a desasignar un juez
	 */
	
	public void desasignar_juez(int idCarrera) {
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		
		try { 
			Query q = session.createQuery("from Carrera as car where car.idcarreraCarrera = " + idCarrera);
			Carrera car = new Carrera();
			car = session.load(Carrera.class, idCarrera); //Cargamoms objeto bbdd
			car.setJueces(null);			
			session.update(car);
			tx.commit();
			session.close();	
		}catch (Exception e){
			e.printStackTrace();
			tx.rollback();
			session.close();
		}
		
	}
	
	/**
	 * Metodo para buscar una carrera
	 * @param idcarreraCarrera. ID de la carrera a buscar
	 * @return la carrera encontrada
	 */
	
	public Carrera Buscar(int idcarreraCarrera) {

		Carrera car = null;
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			Query q = session.createQuery("from Carrera as car where car.idcarreraCarrera = " + idcarreraCarrera);
			car = (Carrera) q.uniqueResult();
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			System.err.println("No se pudo encontrar la carrera");
			e.printStackTrace();
			tx.rollback();
			session.close();
		}
		if (car == null) {
			System.out.println("La carrera no existe no existe");
		}
		return car;
	}
	
}
