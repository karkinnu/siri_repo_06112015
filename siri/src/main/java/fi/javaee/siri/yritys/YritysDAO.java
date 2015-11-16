package fi.javaee.siri.yritys;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

@Repository("yritysDao")
@Transactional(propagation = Propagation.REQUIRED)
public class YritysDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	public YritysDAO() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<Yritys> findAll() {
		List<Yritys> asiakkaat = (List<Yritys>) entityManager.createQuery("select t from Yritys t").getResultList();
		return asiakkaat;
	}

	@SuppressWarnings("unchecked")
	public List<Yritys> findByName(String nimi) {
		List<Yritys> asiakkaat = (List<Yritys>) entityManager.createQuery("select t from Yritys t where t.nimi=:nimi")
				.setParameter("nimi", nimi).getResultList();
		return asiakkaat;
	}

	public Yritys save(Yritys yritys) {
		entityManager.persist(yritys);
		return yritys;
	}

	public Yritys update(Yritys yritys) {
		entityManager.merge(yritys);
		return yritys;
	}

	public void delete(Yritys yritys) {
		entityManager.remove(yritys);
	}

	public void delete(Long id) {
		@SuppressWarnings("unchecked")
		List<Yritys> yritykset = (List<Yritys>) entityManager.createQuery("select t from Yritys t where t.yritysId=:id")
				.setParameter("id", id).getResultList();
		for (Yritys yritys : yritykset) {
			entityManager.remove(yritys);
			break;
		}
	}

	// TODO edit -> fingById
	public Yritys edit(Long id) {
		Yritys yritys = null;
		@SuppressWarnings("unchecked")
		List<Yritys> yritykset = (List<Yritys>) entityManager.createQuery("select t from Yritys t where t.yritysId=:id")
				.setParameter("id", id).getResultList();
		for (Yritys y : yritykset) {
			yritys = y;
			break;
		}

		return yritys;
	}
}
