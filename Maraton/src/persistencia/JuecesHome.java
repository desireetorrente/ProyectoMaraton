package persistencia;
// Generated 18-abr-2018 14:18:14 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import Modelo.Jueces;

/**
 * Home object for domain model class Jueces.
 * @see Modelo.Jueces
 * @author Hibernate Tools
 */
@Stateless
public class JuecesHome {

	private static final Log log = LogFactory.getLog(JuecesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Jueces transientInstance) {
		log.debug("persisting Jueces instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Jueces persistentInstance) {
		log.debug("removing Jueces instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Jueces merge(Jueces detachedInstance) {
		log.debug("merging Jueces instance");
		try {
			Jueces result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Jueces findById(int id) {
		log.debug("getting Jueces instance with id: " + id);
		try {
			Jueces instance = entityManager.find(Jueces.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
