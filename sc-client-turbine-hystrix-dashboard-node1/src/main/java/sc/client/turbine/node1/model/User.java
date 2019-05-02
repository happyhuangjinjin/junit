package sc.client.turbine.node1.model;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 4639927446947303736L;

	private Long id;
	
	private String userName;

	private Integer age;

	private String position;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
