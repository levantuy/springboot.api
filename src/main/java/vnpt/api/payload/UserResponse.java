package vnpt.api.payload;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vnpt.api.payload.RoleResponse;

public class UserResponse {
	private long id;	
	private String email;
	private String name;
	private String password;
	private String username;
	private List<RoleResponse> roles;	
	
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

	public List<RoleResponse> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleResponse> roles) {
        this.roles = roles;
    }	
}
