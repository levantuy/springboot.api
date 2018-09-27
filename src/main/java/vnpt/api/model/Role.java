package vnpt.api.model;

import org.hibernate.annotations.NaturalId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;
import vnpt.api.model.RoleName;

@Entity
@Table(name="ADM_ROLES")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private long featureId;
	@Enumerated(EnumType.STRING)
	@Column(name="NAME", length = 500, columnDefinition="VARCHAR2")
	private String name;	

	public Role() {
	}


	@Id
	@SequenceGenerator(name="ADM_ROLES_ID_GENERATOR", sequenceName="ROLE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADM_ROLES_ID_GENERATOR")
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}


	@Column(name="FEATURE_ID")
	public long getFeatureId() {
		return this.featureId;
	}

	public void setFeatureId(long featureId) {
		this.featureId = featureId;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
