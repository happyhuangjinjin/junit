package sc.thymeleaf.model;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = -8109194980736264299L;

	private int id;
	
	private String name;
	
	private int age;
	
	private String position;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}
