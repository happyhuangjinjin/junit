package com.cto51.dto;

import java.io.Serializable;

public class UserDto implements Serializable{

	private static final long serialVersionUID = 1357533280327864956L;
	
	private String userName;
	
	private String position;
	
	private int age;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
