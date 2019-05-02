package com.um.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.um.sys.dao.RoleDao;
import com.um.sys.dto.RoleDto;
import com.um.sys.service.RoleService;

@Repository
public class RoleServiceImpl extends BaseService implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public Boolean addRole(RoleDto dto) {
		return roleDao.addRole(dto) > 0 ? true : false;
	}

	@Override
	public Boolean updateRole(RoleDto dto) {
		return roleDao.updateRole(dto) > 0 ? true : false;
	}

	@Override
	public Boolean deleteRole(Integer id) {
		return roleDao.deleteRole(id) > 0 ? true : false;
	}

	@Override
	public RoleDto getRole(Integer id) {
		return roleDao.getRole(id);
	}

	@Override
	public List<RoleDto> listAllRoles() {
		return roleDao.listAllRoles();
	}

	@Override
	public Map<String, Object> getPageRole(int pageSize, int pageIndex) {
		Map<String, Integer> param = new HashMap<>();
		param.put("pageSize", 10);
		param.put("pageIndex", 0);
		List<RoleDto>  list = roleDao.getPageRole(param);
		int totalCount = roleDao.getTotalCount();
		Map<String, Object> res = new HashMap<>();
		res.put("list", list);
		res.put("totalCount", totalCount);
		return res;
	}

}