package fi.javaee.siri.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Repository("userDao")
@Transactional(propagation = Propagation.REQUIRED)
public class UserDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public UserDAO() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		List<User> users = (List<User>) entityManager.createQuery("select t from User t").getResultList();
		return users;
	}

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();
		users = entityManager.createQuery("select t from User t where t.username LIKE :username")
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
		int deletedItems = entityManager.createQuery("delete from User t where t.username LIKE :username")
				.setParameter("username", username).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public User saveUser(User user) {
		System.out.println("*****saveUser  *****");
		StandardPasswordEncoder spe = new StandardPasswordEncoder();
		String salasana = user.getPassword();
		String kryptattuna = spe.encode(salasana);
		System.out.println("*****saveUser kryptaa *****");
		user.setPassword(kryptattuna);

		entityManager.persist(user);
		System.out.println("*****saveUser persist(user) *****");
		return user;
	}

	@SuppressWarnings("unchecked")
	public User removeUser(User user) {
		entityManager.remove(user);
		return user;
	}

	public User update(User user) {
		StandardPasswordEncoder spe = new StandardPasswordEncoder();
		String salasana = user.getPassword();
		String kryptattuna = spe.encode(salasana);
		user.setPassword(kryptattuna);
		entityManager.merge(user);
		return user;
	}

	public void delete(User user) {
		entityManager.remove(user);
	}

	public User delete(Long id) {
		User user = findById(id);

		if (user != null) {
			entityManager.remove(user);
		}

		return user;
	}

	public User findById(Long id) {
		User user = null;

		try {
			user = (User) entityManager.createQuery("select t from User t where t.userId=:id").setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			// http://www.objectdb.com/java/jpa/query/execute
			// heittaa poikkeuksen NonUniqueResultException tai
			// NoResultException
			System.err.println("Caught Exception: " + e.getMessage());
		}

		return user;
	}

}