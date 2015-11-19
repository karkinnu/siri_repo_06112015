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
	private boolean role_admin;
	private boolean role_user;
	private boolean role_dbadmin;

	public User() {
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
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
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isRole_admin() {
		return role_admin;
	}

	public void setRole_admin(boolean role_admin) {
		this.role_admin = role_admin;
	}

	public boolean isRole_user() {
		return role_user;
	}

	public void setRole_user(boolean role_user) {
		this.role_user = role_user;
	}

	public boolean isRole_dbadmin() {
		return role_dbadmin;
	}

	public void setRole_dbadmin(boolean role_dbadmin) {
		this.role_dbadmin = role_dbadmin;
	}
}
