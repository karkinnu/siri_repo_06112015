package fi.javaee.siri.user;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fi.javaee.siri.asiakas.Asiakas;

@Repository("userDao")
@Transactional(propagation = Propagation.REQUIRED)
public class UserDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public UserDAO() {
		super();
	}
	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

			List<User> users = (List<User>) em.createQuery("select from User where t where t.username=:username")
				.setParameter("username", username).getResultList();
		
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
	
}