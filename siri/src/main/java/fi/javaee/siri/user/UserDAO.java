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
		
		List<User> users = new ArrayList<User>();	
		users = em.createQuery("select t from User t where t.username LIKE :username")
				.setParameter("username", username).getResultList();
		
		if (users.size() > 0) {
			
			return users.get(0);
		} else {
			return null;
		}

	}
	
	@SuppressWarnings("unchecked")
	public void deleteUser(String username) {
		
		System.out.println("UserDAO:deleteUser");
		int deletedItems = em.createQuery("delete from User t where t.username LIKE :username")
				.setParameter("username", username).executeUpdate();

	}
	
	@SuppressWarnings("unchecked")
	public User saveUser(User user) {

		em.persist(user);
		return user;

	}
	
	
	@SuppressWarnings("unchecked")
	public User removeUser(User user) {

		em.remove(user);
		return user;

	}
}