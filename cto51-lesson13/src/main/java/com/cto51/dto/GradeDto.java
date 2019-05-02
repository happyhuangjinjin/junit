package com.cto51.dto;

import java.io.Serializable;

public class GradeDto implements Serializable {

	private static final long serialVersionUID = 6190127671826316844L;

	private Integer id;

	private String course;

	private String grade;
	
	private String userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
