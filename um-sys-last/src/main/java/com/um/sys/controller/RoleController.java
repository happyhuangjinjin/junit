package com.um.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.um.sys.constants.ResponseConstants;
import com.um.sys.dto.RoleDto;
import com.um.sys.service.RoleService;
import com.um.sys.utils.ListUtils;

@RestController
public class RoleController extends BaseController {

	@Autowired
	private RoleService roleService;

	/**
	 * 添加
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping("/um/addRole")
	public Map<String, Object> addRole(RoleDto dto) {
		Map<String, Object> ret = new HashMap<String, Object>();
		try {
			Boolean bRet = roleService.addRole(dto);
			if (bRet) {
				ret.put(ResponseConstants.CODE, ResponseConstants.SUCCESS_CODE);
				ret.put(ResponseConstants.MSG, ResponseConstants.SUCCESS_MSG);
				return ret;
			}
		} catch (Exception e) {
			logger.error("addRole: ", e);
		}
		ret.put(ResponseConstants.CODE, ResponseConstants.FAIL_CODE);
		ret.put(ResponseConstants.MSG, ResponseConstants.FAIL_MSG);
		return ret;
	}

	/**
	 * 更新
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping("/um/updateRole")
	public Map<String, Object> updateRole(RoleDto dto) {
		Map<String, Object> ret = new HashMap<String, Object>();
		try {
			Boolean bRet = roleService.updateRole(dto);
			if (bRet) {
				ret.put(ResponseConstants.CODE, ResponseConstants.SUCCESS_CODE);
				ret.put(ResponseConstants.MSG, ResponseConstants.SUCCESS_MSG);
				return ret;
			}
		} catch (Exception e) {
			logger.error("updateRole: ", e);
		}
		ret.put(ResponseConstants.CODE, ResponseConstants.FAIL_CODE);
		ret.put(ResponseConstants.MSG, ResponseConstants.FAIL_MSG);
		return ret;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/um/deleteRole")
	public Map<String, Object> deleteRole(Integer id) {
		Map<String, Object> ret = new HashMap<String, Object>();
		try {
			Boolean bRet = roleService.deleteRole(id);
			if (bRet) {
				ret.put(ResponseConstants.CODE, ResponseConstants.SUCCESS_CODE);
				ret.put(ResponseConstants.MSG, ResponseConstants.SUCCESS_MSG);
				return ret;
			}
		} catch (Exception e) {
			logger.error("deleteRole: ", e);
		}
		ret.put(ResponseConstants.CODE, ResponseConstants.FAIL_CODE);
		ret.put(ResponseConstants.MSG, ResponseConstants.FAIL_MSG);
		return ret;
	}

	/**
	 * 根据ID获取
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/um/getRole")
	public Map<String, Object> getRole(Integer id) {
		Map<String, Object> ret = new HashMap<String, Object>();
		try {
			RoleDto dto = roleService.getRole(id);
			if (dto != null) {
				ret.put(ResponseConstants.CODE, ResponseConstants.SUCCESS_CODE);
				ret.put(ResponseConstants.MSG, ResponseConstants.SUCCESS_MSG);
				ret.put(ResponseConstants.BODY, dto);
				return ret;
			}
		} catch (Exception e) {
			logger.error("getRole: ", e);
		}
		ret.put(ResponseConstants.CODE, ResponseConstants.FAIL_CODE);
		ret.put(ResponseConstants.MSG, ResponseConstants.FAIL_MSG);
		return ret;
	}

	/**
	 * 获取全部
	 * 
	 * @return
	 */
	@RequestMapping("/um/listAllRoles")
	public Map<String, Object> listAllRoles() {
		Map<String, Object> ret = new HashMap<String, Object>();
		try {
			List<RoleDto> list = roleService.listAllRoles();
			if (!ListUtils.isEmpty(list)) {
				ret.put(ResponseConstants.CODE, ResponseConstants.SUCCESS_CODE);
				ret.put(ResponseConstants.MSG, ResponseConstants.SUCCESS_MSG);
				ret.put(ResponseConstants.BODY, list);
				return ret;
			}
		} catch (Exception e) {
			logger.error("listAllRoles: ", e);
		}
		ret.put(ResponseConstants.CODE, ResponseConstants.FAIL_CODE);
		ret.put(ResponseConstants.MSG, ResponseConstants.FAIL_MSG);
		return ret;
	}

	/**
	 * 获取一页
	 * 
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/um/getPageRole")
	public Map<String, Object> getPageRole(int pageSize, int pageIndex) {
		Map<String, Object> ret = new HashMap<String, Object>();
		try {
			Map<String, Object> map = roleService.getPageRole(pageSize, pageIndex);
			if (map != null) {
				ret.put(ResponseConstants.CODE, ResponseConstants.SUCCESS_CODE);
				ret.put(ResponseConstants.MSG, ResponseConstants.SUCCESS_MSG);
				ret.put(ResponseConstants.BODY, map);
				return ret;
			}
		} catch (Exception e) {
			logger.error("getPageRole: ", e);
		}
		ret.put(ResponseConstants.CODE, ResponseConstants.FAIL_CODE);
		ret.put(ResponseConstants.MSG, ResponseConstants.FAIL_MSG);
		return ret;
	}

}
