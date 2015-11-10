package fi.javaee.siri.asiakas;

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

@Repository("asiakasDao")
@Transactional(propagation = Propagation.REQUIRED)
public class AsiakasDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public AsiakasDAO() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<Asiakas> findAll() {
		List<Asiakas> asiakkaat = (List<Asiakas>) em.createQuery("select t from Asiakas t").getResultList();
		return asiakkaat;
	}

	@SuppressWarnings("unchecked")
	public List<Asiakas> findByName(String nimi) {
		List<Asiakas> asiakkaat = (List<Asiakas>) em.createQuery("select t from Asiakas t where t.nimi=:nimi")
				.setParameter("nimi", nimi).getResultList();
		return asiakkaat;
	}

	public Asiakas save(Asiakas asiakas) {
		em.persist(asiakas);
		return asiakas;
	}
	
	public Asiakas update(Asiakas asiakas) {
		em.merge(asiakas);
		return asiakas;
	}

	public void delete(Asiakas asiakas) {
		em.remove(asiakas);
	}

}
