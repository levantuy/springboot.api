package vnpt.api.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ADM_MENUS")
@NamedQuery(name = "Menu.findAll", query = "SELECT u FROM Menu u")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name="ID")
	private long id;	
	@Column(name="NAME")
	private String name;
	@Column(name="FEATURE_ID")
	private long featureId;
	@Column(name="ICON")
	private String icon;
	@Column(name="POSITION")
	private long position;
	@Column(name="PARENT_ID")
	private long parentId;
	@OneToOne(mappedBy = "menu", cascade = CascadeType.ALL, 
            fetch = FetchType.LAZY, optional = false)
    private Feature feature;
	
	public Menu() {}
	
	@Id
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
	
	public long getFeatureId() {
		return this.featureId;
	}
	
	public void setFeatureId(long featureId) {
		this.featureId = featureId;
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
		return this.feature;
	}
	
	public void setFeature(Feature feature) {
		this.feature = feature;
	}
}
