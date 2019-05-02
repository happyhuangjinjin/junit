package sc.zuul.consumer.model;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = -1472115828411161165L;

	private int id;
	
	private String username;
	
	private String position;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}
