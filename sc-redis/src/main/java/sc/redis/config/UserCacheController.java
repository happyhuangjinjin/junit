package sc.redis.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sc.redis.model.User;

@RestController
public class UserCacheController {

	//@Autowired
	//private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, Serializable> redisCacheTemplate;

	@GetMapping(value = "/cache/user/cacheUser")
	@ResponseBody
	public Map<String, Object> cacheUser() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");
		User u = new User();
		u.setId(1L);
		u.setAge(23);
		u.setUserName("huangjinjin");
		u.setPosition("cto");
		result.put("body", u);
		redisCacheTemplate.opsForValue().set(String.valueOf(u.getId()), u);
		return result;
	}
	
	/**
	 * 获取缓存信息
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/cache/user/getCacheUser/{id}")
	@ResponseBody
	public Map<String, Object> getCacheUser(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "success");
		User u =  (User) redisCacheTemplate.opsForValue().get(String.valueOf(1));
		System.out.println(u.getUserName());
		result.put("body", u);
		return result;
	}

}
