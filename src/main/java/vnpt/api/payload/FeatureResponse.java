package vnpt.api.payload;

public class FeatureResponse {
	private long featureId;	
	private String name;	
	private String url;	
	private long featureGroupId;
	
	public FeatureResponse() {}
	
	public long getFeatureId() {
		return this.featureId;
	}

	public void setFeatureId(long id) {
		this.featureId = id;
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
}
