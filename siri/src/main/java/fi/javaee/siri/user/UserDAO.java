package fi.javaee.siri.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

		System.out.println("UserDao:findByUserName");
		List<User> users = new ArrayList<User>();
		System.out.println("UserDao:findByUserName:Database query");
		users = em.createQuery("select t from User where t where t.username=:username")
				.setParameter("username", username).getResultList();
		
		System.out.println("UserDao:findByUserName: number of users"+users.size());
		if (users.size() > 0) {
			
			return users.get(0);
		} else {
			return null;
		}

	}
	
	@SuppressWarnings("unchecked")
	public User saveUser(User user) {

		em.persist(user);
		return user;

	}
}