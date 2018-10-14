package vnpt.api.model;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "ADM_DASHBOARD")
@NamedQuery(name = "Dashboard.findAll", query = "SELECT u FROM Dashboard u")
public class Dashboard {
	@Id	
	@Column(name="ID")
	private long id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Description")
	private String description;
	
	public Dashboard() {}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
