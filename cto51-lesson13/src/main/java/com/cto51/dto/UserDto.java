package com.cto51.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 935073745912359286L;
	
	private Integer id;
	
	private String name;
	
	private String mobileNo;
	
	private Date birthday;
	
	private String email;
	
	private String nickName;
	
	private String photo;

	private GenderDto genderDto;
	
	private List<GradeDto> grades;
	
	private Integer genderId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<GradeDto> getGrades() {
		return grades;
	}

	public void setGrades(List<GradeDto> grades) {
		this.grades = grades;
	}

	public GenderDto getGenderDto() {
		return genderDto;
	}

	public void setGenderDto(GenderDto genderDto) {
		this.genderDto = genderDto;
	}

	public Integer getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}

}
