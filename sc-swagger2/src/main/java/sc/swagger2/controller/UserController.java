package sc.swagger2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import sc.swagger2.model.User;

@Api(value="用户管理")
@Controller
public class UserController {

	@ApiResponses({ @ApiResponse(code = 000000, message = "操作成功"),
		@ApiResponse(code = 000001, message = "服务器内部异常") })
	@GetMapping(value = "/feign/user/getUser/{id}")
	@ResponseBody
	@ApiOperation(value = "获取根据Id用户信息",response = User.class)
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",example="100")
	public Map<String, Object> getUser(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");
		User u = new User();
		u.setId(1L);
		u.setAge(23);
		u.setUserName("huangjinjin");
		u.setPosition("cto");
		result.put("body", u);
		return result;
	}

	@ApiResponses({ @ApiResponse(code = 000000, message = "操作成功"), 
		@ApiResponse(code = 000001, message = "服务器内部异常") })
	@RequestMapping(value = "/feign/user/listUser", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取用户列表")
	public Map<String, Object> listUser() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");
		User u = new User();
		u.setId(1L);
		u.setAge(23);
		u.setUserName("huangjinjin");
		u.setPosition("cto");
		List<User> list = new ArrayList<User>();
		list.add(u);
		result.put("body", list);
		return result;
	}

	@ApiResponses({ @ApiResponse(code = 000000, message = "操作成功"), 
		@ApiResponse(code = 000001, message = "服务器内部异常") })
	@PostMapping(value = "/feign/user/addUser")
	@ResponseBody
	@ApiOperation(value = "添加用户", notes = "根据User对象创建用户")
	@ApiImplicitParams({ @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String"),
		@ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "String"),
		@ApiImplicitParam(name = "position", value = "职位", required = true, dataType = "String"),
		@ApiImplicitParam(name = "id", value = "用户ID", required = false, dataType = "Long",example="100")})
	public Map<String, Object> addUser(User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");
		result.put("body", 1);
		return result;
	}

	@ApiResponses({ @ApiResponse(code = 000000, message = "操作成功"), 
		@ApiResponse(code = 000001, message = "服务器内部异常") })
	@ApiOperation(value = "更新用户")
	@PutMapping(value = "/feign/user/updateUser")
	@ResponseBody
	@ApiImplicitParams({ @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String"),
		@ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "String"),
		@ApiImplicitParam(name = "position", value = "职位", required = true, dataType = "String"),
		@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", example="100")})
	public Map<String, Object> updateUser(User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");
		result.put("body", 1);
		return result;
	}

	@ApiResponses({ @ApiResponse(code = 000000, message = "操作成功"), 
		@ApiResponse(code = 000001, message = "服务器内部异常") })
	@DeleteMapping(value = "/feign/user/deleteUser/{id}")
	@ResponseBody
	@ApiOperation(value = "删除用户")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",example="100")
	public Map<String, Object> deleteUser(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");
		result.put("body", 1);
		return result;
	}
	
}
