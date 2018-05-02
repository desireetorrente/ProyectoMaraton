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
	
	/**
	 * constructor por defecto
	 */
	public ParticipantesHelper() {
		this.cfg = new Configuration();
	}
	
	/**
	 * Inserta un participante en la bbdd
	 * @param dni. deni del participante
	 * @param idcarrera. ID de la carrera en la que se va a insertar el participante
	 */
	
	public void insertar(int dni, int idcarrera) {

		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		ParticipantesId participanteid = new ParticipantesId();
		participanteid.setDniUsuarios(dni);
		participanteid.setIdcarreraCarrera(idcarrera);
		participanteid.setTiempoParticipantes(0);
		participanteid.setDorsalParticipantes(nextDorsal(idcarrera));
		
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
	
	/**
	 * Inserta el tiempo de un participante
	 * @param participante participante al que se le va a dar el tiempo
	 * @param tiempo. tiempo a introducir
	 */
	
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
	
	/**
	 * Metodo para borrar un participante
	 * @param dni del participante
	 * @param idcarrera Id de la carrera
	 * @return el participante eliminado
	 */
	
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
	
	/**
	 * Busca un participante
	 * @param dni del participante a buscar
	 * @return el participante encontrado
	 */
	
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
	
	/**
	 * Metodo que lista los corredores de una carrera
	 * @param idcarrera. Id de carrera a listar
	 * @return lista de los corredores
	 */
	
	public List<Participantes> corredoresEnCarrera(int idcarrera){
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		List<Participantes> participante = new ArrayList<Participantes>();
		Query query = session.createQuery("SELECT p FROM Participantes p");
		List<Participantes> partis = query.list();
		
		for(int i = 0; i < partis.size(); i++) {
			if(partis.get(i).getId().getIdcarreraCarrera() == idcarrera) {
				participante.add(partis.get(i));
			}	
		}
		return participante;
	}
	
	/**
	 * Metodo que asigna los dorsales a los participantes
	 * @param idcarrera. Id de la carrera a asignar los dorsales de los participantes
	 * @return el dorsal asignado
	 */
	public int nextDorsal(int idcarrera) {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		List<Participantes> participante = new ArrayList<Participantes>();
		Query query = session.createQuery("SELECT p FROM Participantes p");
		List<Participantes> partis = query.list();
		for(int i = 0; i < partis.size(); i++) {
			if(partis.get(i).getId().getIdcarreraCarrera() == idcarrera) {
				participante.add(partis.get(i));
			}	
		}
		if(participante.isEmpty()) {
			return 1;
		}else {
			return participante.get(participante.size()-1).getId().getDorsalParticipantes()+1;
		}
		
	}
	
}

