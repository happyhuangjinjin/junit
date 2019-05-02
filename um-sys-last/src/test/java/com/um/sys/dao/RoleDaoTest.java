package com.um.sys.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.um.sys.dto.RoleDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleDaoTest {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RoleDao dao;
	
	/**
	 * 添加
	 * @return
	 */
	@Test
	public void addRole(){
		RoleDto dto = new RoleDto();
		dto.setName("java 乐园");
		dto.setDescription("super admin");
		dao.addRole(dto);
	}

	/**
	 * 更新
	 * @return
	 */
	@Test
	public void updateRole(){
		RoleDto dto = new RoleDto();
		dto.setId(1);
		dto.setName("java 乐园 and 架构师知音");
		dto.setDescription("super admin for update");
		dao.updateRole(dto);
		
	}
	
	/**
	 * 根据ID获取
	 * @return
	 */
	@Test
	public void getRole(){
		RoleDto dto = dao.getRole(2);
		logger.info("name = {}", dto.getName());
		logger.info("desc = {}", dto.getDescription());
	}

	/**
	 * 获取全部
	 * @return
	 */
	@Test
	public void listAllRoles(){
		List<RoleDto> dtoList = dao.listAllRoles();
		logger.info("listAllRoles dtoList size = {}", dtoList.size());
	}
	
	/**
	 * 获取一页
	 * @return
	 */
	@Test
	public void getPageRole(){
		Map<String, Integer> param = new HashMap<>();
		param.put("pageSize", 10);
		param.put("pageIndex", 0);
		List<RoleDto> dtoList = dao.getPageRole(param);
		logger.info("getPageRole dtoList size = {}", dtoList.size());
	}
	
	/**
	 * 总条数
	 * @return
	 */
	@Test
	public void  getTotalCount(){
		logger.info("getTotalCount= {}", dao.getTotalCount());
	}
	/**
	 * 删除
	 * @return
	 */
	@Test
	public void deleteRole(){
		dao.deleteRole(1);
	}

}
