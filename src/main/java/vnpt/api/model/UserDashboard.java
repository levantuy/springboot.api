package vnpt.api.model;

import javax.persistence.*;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ADM_USER_DASHBOARD")
@NamedQuery(name = "UserDashboard.findAll", query = "SELECT u FROM UserDashboard u")
public class UserDashboard {
	@Id
	@Column(name="ID")
	private long id;
	@Column(name="USER_ID")
	private long userId;
	@Column(name="X")
	private int x;
	@Column(name="Y")
	private int y;
	@Column(name="H")
	private int h;
	@Column(name="W")
	private int w;
	@Column(name="I")
	private String i;
	
	public UserDashboard() {}
	
	public UserDashboard(long id, long userId, int x, int y, int h, int w, String i) {
		this.setId(id);
		this.setUserId(userId);
		this.setX(x);
		this.setY(y);
		this.setH(h);
		this.setW(w);
		this.setI(i);
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
	
	public String getI() {
		return this.i;
	}
	
	public void setI(String i) {
		this.i = i;
	}
}
