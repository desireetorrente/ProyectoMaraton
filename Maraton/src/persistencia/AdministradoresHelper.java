package persistencia;

import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import Modelo.Administradores;

/**
 * Clase que contiene las conexiones de administradores a la bbdd
 */

public class AdministradoresHelper {
	
	private Configuration cfg;
	/**
	 * constructor por defecto
	 * @param cfg. inicia el objeto configuracion
	 */
	public AdministradoresHelper() {
		this.cfg = new Configuration();
	}
	/**
	 * Inserta un administrador en la bbdd.
	 * @param admin. Objeto administrador que se quiere insertar
	 */
	public void insertar(Administradores admin) {
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction(); 
		session.save(admin);
		tx.commit(); 
		session.close();
	}
	
	/**
	 * metodo para borrar un administrador de la bbdd
	 * @param dniAdministradores. dni del administrador que se quiere borrar
	 */
	
	public void delete(int dniAdministradores) {
		
		Administradores admin = null;
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		
		try {
			Query q = session.createQuery("from Administradores as admin where admin.dniAdministradores = "+ dniAdministradores);
			admin = (Administradores) q.uniqueResult();
			session.delete(admin);
			tx.commit();
			session.close();
		}catch (Exception e){
			e.printStackTrace();
			tx.rollback();
			session.close();
		} 
	}
	
	/**
	 * metodo para modificar un administrador
	 * @param dniAdministradores. dni del administrador
	 * @param name. nuevo nombre del administrador
	 * @param pwd. nueva contraseña del administrador
	 */
	
	public void modificar(int dniAdministradores, String name, String pwd) {
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		
		try { 
			Query q = session.createQuery("from Administradores as admin where admin.dniAdministradores = "
					+ dniAdministradores);
			Administradores admin = new Administradores();
			admin = session.load(Administradores.class, dniAdministradores); //CArgamoms objeto bbdd
			admin.setNombreAdministradores(name);
			admin.setPasswordAdministradores(pwd);			
			session.update(admin);
			tx.commit();
			session.close();	
		}catch (Exception e){
			e.printStackTrace();
			tx.rollback();
			session.close();
		}
	}
	
	/**
	 * metodo que lista los administradores.
	 * @return una lista con los administradores.
	 */
	
	public List <Administradores>listar() {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
        List<Administradores>administradores=new ArrayList<>();
        
        try {
        	Query q =session.createQuery("from Administradores");
        	administradores = q.list();
        	tx.commit();
        	session.close();
        	
        }catch(HibernateException e) {
        	e.printStackTrace();
			tx.rollback();
			session.close();
        	
        }
        return administradores;
    }
	
	/**
	 * metodo que busca un administrador
	 * @param dniAdministradores dni del administrador a buscar
	 * @return el administrador encontrado.
	 */
	
	public Administradores Buscar(int dniAdministradores) {

		Administradores admin = null;
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			Query q = session.createQuery("from Administradores as admin where admin.dniAdministradores = " + dniAdministradores);
			admin = (Administradores) q.uniqueResult();
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			System.err.println("No se pudo encontrar al administrador");
			e.printStackTrace();
			tx.rollback();
			session.close();
		}
		if (admin == null) {
			System.out.println("El administrador no existe");
		}else {
			System.out.println("El administrador: " + admin.getNombreAdministradores());
		}
		return admin;
	}

}
