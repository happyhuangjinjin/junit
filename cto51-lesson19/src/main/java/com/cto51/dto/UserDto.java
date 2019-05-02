package com.cto51.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName="user_dto")
public class UserDto implements Serializable{

	private static final long serialVersionUID = 1357533280327864956L;

	@Id
	private Long id;
	
	@Field(type=FieldType.Text)
	private String userName;
	
	@Field(type=FieldType.Text)
	private String position;
	
	@Field(type=FieldType.Float)
	private float salary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
}
