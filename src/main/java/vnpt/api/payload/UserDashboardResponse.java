package vnpt.api.payload;

public class UserDashboardResponse {	
	public long id;
	public long userId;
	public String i;
	public int x;
	public int y;
	public int h;
	public int w;	
	
	public UserDashboardResponse(long id, long userId, String i, int x, int y, int w, int h) {	
		this.id = id;
		this.userId = userId;
		this.i = i;
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
	}	
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getI() {
		return this.i;
	}
	
	public void setI(String i) {
		this.i = i;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getH() {
		return this.h;
	}
	
	public void setH(int h) {
		this.h = h;
	}
	
	public int getW() {
		return this.w;
	}
	
	public void setW(int w) {
		this.w = w;
	}
}
