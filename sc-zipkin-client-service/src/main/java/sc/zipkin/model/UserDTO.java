package sc.zipkin.model;

import java.io.Serializable;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1968539513902213702L;

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
