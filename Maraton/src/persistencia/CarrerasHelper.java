package persistencia;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Modelo.Administradores;
import Modelo.Carrera;
import Modelo.Jueces;
import Modelo.Participantes;

public class CarrerasHelper {

	private Configuration cfg;
	
	public CarrerasHelper() {
		this.cfg = new Configuration();
	}
	
	public void insertar(Carrera car) {
		
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();		
		Transaction tx = session.beginTransaction();
		
		session.save(car);
		tx.commit();
		session.close();
	}
	
	public void delete(int idCarrera) {
		
		Carrera car = null;
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Query q = session.createQuery("from Carrera as car where car.idcarrera_carrera = " + idCarrera);
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

	public void cambiar(int idCarrera, String nombreCarrera, String distanciaCarrera, String altitudCarrera) {

		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		
		try { 
			Query q = session.createQuery("from carrera as car where car.idcarrera_carrera = "
					+ idCarrera);
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
		
	public List<Carrera> listarCarrera() {
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
        session.beginTransaction();
        List <Carrera> result = session.createQuery("SELECT c FROM carrera c").list();
        session.getTransaction().commit();
        return result;
		/*cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		List<Carrera> carreras = new ArrayList<Carrera>();
		Query query = session.createQuery("SELECT c FROM carrera c");
		List<Carrera> carr = query.list();
		
		for(int i = 0; i < carr.size(); i++) {
			if(carr.get(i).getIdcarreraCarrera() == dni) {
				carreras.add(carr.get(i));
			}	
		}
		return participante;
        */
        
        
    }
	
	public void insertar_juez(Jueces juez, int idCarrera) {
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		//int dni = juez.getDniJueces();
		try { 
			Query q = session.createQuery("from carrera as car where car.idcarrera_carrera = "
					+ idCarrera);
			Carrera car = new Carrera();
			car = session.load(Carrera.class, idCarrera); //CArgamoms objeto bbdd
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
	
	public void desasignar_juez(int idCarrera) {
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		
		try { 
			Query q = session.createQuery("from carrera as car where car.idcarrera_carrera = "
					+ idCarrera);
			Carrera car = new Carrera();
			car = session.load(Carrera.class, idCarrera); //CArgamoms objeto bbdd
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
	
	public static void main(String[] args) {
		CarrerasHelper prueba = new CarrerasHelper();
		//prueba.insertar(555, 1);
		//prueba.insertar(555, 11);
		//prueba.delete(555, 11);
		//prueba.delete(555, 1);
		//prueba.insertarTiempo(555, 1, 1234);
		//prueba.insertarTiempov2(555, 1, 0);
		
		System.out.println("Usuario 555 inscrito en: ");
		
			System.out.println(prueba.listarCarrera().get(0).getNombreCarrera());
			
		
	}
	
}
