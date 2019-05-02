package com.um.sys.vo;

public class UserRoleVo  extends BaseVo{

	private static final long serialVersionUID = -1625070558927004212L;

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
