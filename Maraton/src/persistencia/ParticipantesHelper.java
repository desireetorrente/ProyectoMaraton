package persistencia;

import org.hibernate.query.Query;

import Modelo.Carrera;
import Modelo.Jueces;
import Modelo.Participantes;
import Modelo.ParticipantesId;
import Modelo.Usuarios;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ParticipantesHelper {

	private Configuration cfg;
	
	
	public ParticipantesHelper() {
		this.cfg = new Configuration();
	}
	
	public void insertar(int dni, int idcarrera) {

		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		ParticipantesId participanteid = new ParticipantesId();
		participanteid.setDniUsuarios(dni);
		participanteid.setIdcarreraCarrera(idcarrera);
		participanteid.setTiempoParticipantes(0);
		participanteid.setDorsalParticipantes((int) Math.random()*10);
		
		Usuarios usuario = session.get(Usuarios.class, dni);
		Carrera carrera = session.get(Carrera.class, idcarrera);
		Participantes participante = new Participantes(participanteid, carrera, usuario);
		
		try {
			session.save(participante);
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
		}
		
	}
	
	public void insertar(Participantes participante, int tiempo) {

		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		participante.getId().setTiempoParticipantes(tiempo);
		
		try {
			session.save(participante);
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
		}
		
	}
	
	public Participantes delete(int dni, int idcarrera) {

		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		Participantes par = new Participantes();
		Query query = session.createQuery("SELECT p FROM Participantes p");
		List<Participantes> partis = query.list();
		
		for(int i = 0; i < partis.size(); i++) {
			if(partis.get(i).getId().getIdcarreraCarrera() == idcarrera && 
					partis.get(i).getId().getDniUsuarios() == dni) {
				par = partis.get(i);
			}	
		}
		
		try {
			session.delete(par);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			session.close();
		}
		return par;
	}
	
	public void insertarTiempo(int dni, int idcarrera, int tiempo) {
		insertar(delete(dni, idcarrera), tiempo);
		
	}
	
	public void insertarTiempov2(int dni, int idcarrera, int tiempo) {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		Participantes par = new Participantes();
		Query query = session.createQuery("SELECT p FROM Participantes p");
		List<Participantes> partis = query.list();
		
		for(int i = 0; i < partis.size(); i++) {
			if(partis.get(i).getId().getIdcarreraCarrera() == idcarrera && 
					partis.get(i).getId().getDniUsuarios() == dni) {
				par = partis.get(i);
			}	
		}
		
		try {
			ParticipantesId parrt = par.getId();
			parrt.setTiempoParticipantes(tiempo);
			par.setId(parrt);
			session.update(par);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			session.close();
		}
	}
	
	public List<Participantes> buscar(int dni) {
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		List<Participantes> participante = new ArrayList<Participantes>();
		Query query = session.createQuery("SELECT p FROM Participantes p");
		List<Participantes> partis = query.list();
		
		for(int i = 0; i < partis.size(); i++) {
			if(partis.get(i).getId().getDniUsuarios() == dni) {
				participante.add(partis.get(i));
			}	
		}
		return participante;
	}
	
	
	
	public static void main(String[] args) {
		ParticipantesHelper prueba = new ParticipantesHelper();
		//prueba.insertar(555, 1);
		//prueba.insertar(555, 11);
		//prueba.delete(555, 11);
		//prueba.delete(555, 1);
		//prueba.insertarTiempo(555, 1, 1234);
		//prueba.insertarTiempov2(555, 1, 0);
		
		System.out.println("Usuario 555 inscrito en: ");
		for(int i = 0; i < prueba.buscar(555).size(); i++) {
			System.out.println(prueba.buscar(555).get(i).getCarrera().getNombreCarrera());
			
		}
	}
	
}
