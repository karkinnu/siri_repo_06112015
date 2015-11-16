package fi.javaee.siri.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fi.javaee.siri.yritys.Yritys;

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
		StandardPasswordEncoder spe = new StandardPasswordEncoder();
		String salasana = user.getPassword();
		String kryptattuna = spe.encode(salasana);
		user.setPassword(kryptattuna);
		entityManager.persist(user);
		return user;
	}

	@SuppressWarnings("unchecked")
	public User removeUser(User user) {
		entityManager.remove(user);
		return user;
	}

	public User update(User user) {
		entityManager.merge(user);
		return user;
	}

	public void delete(User user) {
		entityManager.remove(user);
	}

	public void delete(Long id) {
		System.out.println("Try remove...");
		@SuppressWarnings("unchecked")
		List<User> kayttajat = (List<User>) entityManager.createQuery("select t from User t where t.userId=:id")
				.setParameter("id", id).getResultList();
		System.out.println("for");
		for (User kayttaja : kayttajat) {
			System.out.println("Remove: " + kayttaja.getUsername());
			entityManager.remove(kayttaja);
			break;
		}
	}

	public User edit(Long id) {
		User kayttaja = null;
		System.out.println("Try edit...");
		@SuppressWarnings("unchecked")
		List<User> kayttajat = (List<User>) entityManager.createQuery("select t from User t where t.userId=:id")
				.setParameter("id", id).getResultList();
		for (User u : kayttajat) {
			System.out.println("Edit: " + u.getUsername());
			kayttaja = u;
			break;
		}

		return kayttaja;
	}

}