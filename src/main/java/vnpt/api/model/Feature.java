package vnpt.api.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "ADM_FEATURES")
@NamedQuery(name = "Feature.findAll", query = "SELECT u FROM Feature u")
public class Feature implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name="ID")
	private long id;
	@Column(name="NAME")
	private String name;
	@Column(name="URL")
	private String url;
	@Column(name="FEATURE_GROUP_ID")
	private long featureGroupId;
	@OneToOne(mappedBy = "menu", cascade = CascadeType.ALL, 
            fetch = FetchType.LAZY, optional = false)
	private Menu menu;
	
	public Feature() {
		
	}
	
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
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public long getfeatureGroupId() {
		return this.featureGroupId;
	}
	
	public void setfeatureGroupId(long featureGroupId) {
		this.featureGroupId = featureGroupId;
	}
}
