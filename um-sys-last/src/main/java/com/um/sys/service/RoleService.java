package com.um.sys.service;

import java.util.List;
import java.util.Map;

import com.um.sys.dto.RoleDto;

public interface RoleService {

	/**
	 * 添加
	 * @param dto
	 * @return
	 */
	Boolean addRole(RoleDto dto);

	/**
	 * 更新
	 * @param dto
	 * @return
	 */
	Boolean updateRole(RoleDto dto);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	Boolean deleteRole(Integer id);

	/**
	 * 根据ID获取
	 * @param id
	 * @return
	 */
	RoleDto getRole(Integer id);

	/**
	 * 获取全部
	 * @return
	 */
	List<RoleDto> listAllRoles();
	
	/**
	 * 获取一页
	 * @param pageSize
	 * @param pageIndex
	 * @return
	 */
	Map<String, Object> getPageRole(int pageSize, int pageIndex);
	
}