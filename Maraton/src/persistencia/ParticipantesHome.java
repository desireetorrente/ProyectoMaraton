package persistencia;
// Generated 18-abr-2018 14:18:14 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import Modelo.Participantes;
import Modelo.ParticipantesId;

/**
 * Home object for domain model class Participantes.
 * @see persistencia.Participantes
 * @author Hibernate Tools
 */
@Stateless
public class ParticipantesHome {

	private static final Log log = LogFactory.getLog(ParticipantesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Participantes transientInstance) {
		log.debug("persisting Participantes instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Participantes persistentInstance) {
		log.debug("removing Participantes instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Participantes merge(Participantes detachedInstance) {
		log.debug("merging Participantes instance");
		try {
			Participantes result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Participantes findById(ParticipantesId id) {
		log.debug("getting Participantes instance with id: " + id);
		try {
			Participantes instance = entityManager.find(Participantes.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
