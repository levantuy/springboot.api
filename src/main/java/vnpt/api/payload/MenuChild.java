package vnpt.api.payload;

public class MenuChild {
	private long id;		
	private String name;		
	private String icon;	
	private long position;	
	private long parentId;	
	private BadgeInfo badge = new BadgeInfo();
	private WrapperInfo wrapper = new WrapperInfo();
	private String url;
	
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
	
	public BadgeInfo getbadge() {
        return badge;
    }

    public void setChildrenBadge(BadgeInfo badge) {
        this.badge = badge;
    }	    
    
    public WrapperInfo getwrapper() {
        return this.wrapper;
    }

    public void setChildrenWrapper(WrapperInfo wrapper) {
        this.wrapper = wrapper;
    }	
    
    public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
}
