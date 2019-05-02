package com.um.sys.dto;

public class UserRoleDto  extends BaseDto{

	private static final long serialVersionUID = -4829524483962513387L;

	private Integer userId;
	
	private Integer roleId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
}
