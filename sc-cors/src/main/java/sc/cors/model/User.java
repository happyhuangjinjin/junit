package sc.cors.model;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 6196249046354253389L;

	private int id;
	
	private String userName;
	
	private String position;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}
