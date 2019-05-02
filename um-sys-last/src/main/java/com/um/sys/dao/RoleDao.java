package com.um.sys.dao;

import java.util.List;
import java.util.Map;

import com.um.sys.dto.RoleDto;

public interface RoleDao {

	/**
	 * 添加
	 * @param dto
	 * @return
	 */
	int addRole(RoleDto dto);

	/**
	 * 更新
	 * @param dto
	 * @return
	 */
	int updateRole(RoleDto dto);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int deleteRole(Integer id);

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
	List<RoleDto> getPageRole(Map<String, Integer> param);
	
	/**
	 * 总条数
	 * 
	 * @return
	 */
	Integer getTotalCount();
}