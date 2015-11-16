package fi.javaee.siri.asiakas;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fi.javaee.siri.yritys.Yritys;

import org.springframework.transaction.annotation.Propagation;

@Repository("asiakasDao")
@Transactional(propagation = Propagation.REQUIRED)
public class AsiakasDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public AsiakasDAO() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<Asiakas> findAll() {
		List<Asiakas> asiakkaat = (List<Asiakas>) entityManager.createQuery("select t from Asiakas t").getResultList();
		return asiakkaat;
	}

	@SuppressWarnings("unchecked")
	public List<Asiakas> findByName(String nimi) {
		List<Asiakas> asiakkaat = (List<Asiakas>) entityManager
				.createQuery("select t from Asiakas t where t.nimi=:nimi").setParameter("nimi", nimi).getResultList();
		return asiakkaat;
	}

	public Asiakas save(Asiakas asiakas) {
		entityManager.persist(asiakas);
		return asiakas;
	}

	public Asiakas update(Asiakas asiakas) {
		entityManager.merge(asiakas);
		return asiakas;
	}

	public void delete(Long id) {
		@SuppressWarnings("unchecked")
		List<Asiakas> asiakkaat = (List<Asiakas>) entityManager
				.createQuery("select t from Asiakas t where t.asiakasId=:id").setParameter("id", id).getResultList();
		for (Asiakas asiakas : asiakkaat) {
			entityManager.remove(asiakas);
			break;
		}
	}

	// TODO edit -> fingById
	public Asiakas edit(Long id) {
		Asiakas tempAsiakas = null;
		@SuppressWarnings("unchecked")
		List<Asiakas> asiakkaat = (List<Asiakas>) entityManager
				.createQuery("select t from Asiakas t where t.asiakasId=:id").setParameter("id", id).getResultList();
		for (Asiakas asiakas : asiakkaat) {
			tempAsiakas = asiakas;
			break;
		}

		return tempAsiakas;
	}

}
