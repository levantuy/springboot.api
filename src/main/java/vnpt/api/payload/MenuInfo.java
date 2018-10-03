package vnpt.api.payload;

import java.util.ArrayList;
import java.util.List;

public class MenuInfo {
	private long id;		
	private String name;	
	private long featureId;	
	private String icon;	
	private long position;	
	private long parentId;
	private List<MenuInfo> children = new ArrayList<MenuInfo>(); 
	
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
	
	public List<MenuInfo> getChildren() {
        return children;
    }

    public void setChildren(List<MenuInfo> children) {
        this.children = children;
    }	
    
    public void addChild(MenuInfo menuInfo) {
        children.add(menuInfo);        
    }

    public void removeChild(MenuInfo menuInfo) {
    	children.remove(menuInfo);
    }
}
