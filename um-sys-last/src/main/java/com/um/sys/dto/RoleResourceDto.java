package com.um.sys.dto;

public class RoleResourceDto  extends BaseDto{

	private static final long serialVersionUID = 3747076318377031413L;

	private Integer roleId;
	
	private Integer resourceId;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	
}
