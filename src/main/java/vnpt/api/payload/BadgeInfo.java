package vnpt.api.payload;

public class BadgeInfo {
	private String variant;
	private String text;
	
	public void setVariant(String variant){
		this.variant = variant;
	}
	
	public String getVariant()
	{
		return this.variant;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public String getText()
	{
		return this.text;
	}
}
