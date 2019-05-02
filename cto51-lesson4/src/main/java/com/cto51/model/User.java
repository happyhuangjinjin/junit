package com.cto51.model;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 2545117074764007938L;
	
	private Integer id;
	
	private String username;
	
	private String position;
	
	private float salary;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}
