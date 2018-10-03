package vnpt.api.payload;

public class WrapperInfo {
	private String element;
	private String attributes;
	
	public void setElement(String element){
		this.element = element;
	}
	
	public String getElement()
	{
		return this.element;
	}
	
	public void setAttributes(String Attributes){
		this.attributes = attributes;
	}
	
	public String getAttributes()
	{
		return this.attributes;
	}
}
