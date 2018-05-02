package persistencia;
// Generated 18-abr-2018 14:18:14 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import Modelo.Administradores;

/**
 * Home object for domain model class Administradores.
 * @see Modelo.Administradores
 * @author Hibernate Tools
 */
@Stateless
public class AdministradoresHome {

	private static final Log log = LogFactory.getLog(AdministradoresHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Administradores transientInstance) {
		log.debug("persisting Administradores instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Administradores persistentInstance) {
		log.debug("removing Administradores instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Administradores merge(Administradores detachedInstance) {
		log.debug("merging Administradores instance");
		try {
			Administradores result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Administradores findById(int id) {
		log.debug("getting Administradores instance with id: " + id);
		try {
			Administradores instance = entityManager.find(Administradores.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
