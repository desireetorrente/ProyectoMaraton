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

public class AdministradoresHelper {
	
	private Configuration cfg;
	
	public AdministradoresHelper() {
		this.cfg = new Configuration();
	}
	
	public void insertar(Administradores admin) {
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction(); 
		session.save(admin);
		tx.commit(); 
		session.close();
	}
	
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
