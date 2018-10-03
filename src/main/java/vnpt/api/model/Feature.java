package vnpt.api.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "adm_features")
public class Feature implements Serializable {	
	@Id
	private long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "URL")
	private String url;
	@Column(name = "FEATURE_GROUP_ID")
	private long featureGroupId;
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "feature")
	private Menu menu;

	public Feature() {

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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getFeatureGroupId() {
		return this.featureGroupId;
	}

	public void setFeatureGroupId(long featureGroupId) {
		this.featureGroupId = featureGroupId;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}
