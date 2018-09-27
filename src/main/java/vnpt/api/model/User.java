package vnpt.api.model;

import vnpt.api.model.audit.DateAudit;
import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ADM_USERS")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User extends DateAudit {
	private static final long serialVersionUID = 1L;
	private long id;	
	private String email;
	private String name;
	private String password;
	private String username;
	private Set<Role> roles = new HashSet<>();

	public User() {

	}

	public User(String name, String username, String email, String password) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	@Id
	@SequenceGenerator(name = "ADM_USERS_ID_GENERATOR", sequenceName = "USER_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADM_USERS_ID_GENERATOR")
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(name = "ADM_USER_ROLES", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID") })
	public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }	
}