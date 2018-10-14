package vnpt.api.payload;

public class DashboardResponse {	
	private String label;
	private String value;
	
	public DashboardResponse() {}
	public DashboardResponse(String label, String value) {		
		this.label = label;
		this.value = value;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
