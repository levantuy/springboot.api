package vnpt.api.payload;

public class RoleResponse {
	private long id;
	private long featureId;	
	private String name;	
	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
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
