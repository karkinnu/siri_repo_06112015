package fi.javaee.siri.user;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String username;
	private String password;
	@Transient
	private String newPassword;
	private boolean enabled;
	// private Set<UserRole> userRole = new HashSet<UserRole>(0);

	public User() {
	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	/*
	 * public User(String username, String password, boolean enabled,
	 * Set<UserRole> userRole) { this.username = username; this.password =
	 * password; this.enabled = enabled; this.userRole = userRole; }
	 */

	public String getUsername() {
		return this.username;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") public
	 * Set<UserRole> getUserRole() { return this.userRole; }
	 * 
	 * public void setUserRole(Set<UserRole> userRole) { this.userRole =
	 * userRole; }
	 */

}
