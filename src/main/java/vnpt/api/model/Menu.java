package vnpt.api.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "adm_menus")
public class Menu implements Serializable {
	@Id
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NAME")
	private String name;	
	
	@Column(name = "ICON")
	private String icon;
	
	@Column(name = "POSITION")
	private long position;
	
	@Column(name = "PARENT_ID")
	private long parentId;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "feature_id", nullable = false)
	private Feature feature;

	public Menu() {
	}
	
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

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public long getPosition() {
		return this.position;
	}

	public void setPosition(long position) {
		this.position = position;
	}

	public long getParentId() {
		return this.parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}
}
