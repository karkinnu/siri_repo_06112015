package fi.javaee.siri.yritys;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;


/*
 * Spring 4:ssa ei enää suositellä käytettäväksi erillistä XML-tiedostoa eikä
 * JpaTemplate-luokkaa, vaan toteutetaan suoraan JPA:n pohjalta.
 * 
 * EntityManager injektoidaan kuten EJB/JSF:ssä standardilla tavalla käyttäen 
 * @PersistenceContext annotaatiota.
 * 
 * Hyvä tutorial: http://www.baeldung.com/spring-dao-jpa
 */

@Repository("yritysDao")
@Transactional(propagation = Propagation.REQUIRED)
public class YritysDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public YritysDAO() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<Yritys> findAll() {
		List<Yritys> asiakkaat = (List<Yritys>) em.createQuery("select t from Yritys t").getResultList();
		return asiakkaat;
	}

	@SuppressWarnings("unchecked")
	public List<Yritys> findByName(String nimi) {
		List<Yritys> asiakkaat = (List<Yritys>) em.createQuery("select t from Yritys t where t.nimi=:nimi")
				.setParameter("nimi", nimi).getResultList();
		return asiakkaat;
	}

	public Yritys save(Yritys yritys) {
		em.persist(yritys);
		return yritys;
	}
	
	public Yritys update(Yritys yritys) {
		em.merge(yritys);
		return yritys;
	}

	public void delete(Yritys yritys) {
		em.remove(yritys);
	}

	public void delete(Long id) {
		System.out.println("Try remove...");
		@SuppressWarnings("unchecked")
		List<Yritys> yritykset = (List<Yritys>) em.createQuery("select t from Yritys t where t.yritysId=:id").setParameter("id", id).getResultList();
		for (Yritys yritys : yritykset) {
			System.out.println("Remove: " + yritys.getNimi());
			em.remove(yritys);
			break;
		}
	}

}
