package sc.consumer.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sc.consumer.model.User;
import sc.consumer.service.hystrix.UserServiceHystrix;

@FeignClient(value="sc-eureka-client-provider", fallback=UserServiceHystrix.class)
public interface UserService {

	@GetMapping("/user/getUser/{id}")
	Map<String, Object> getUser(@PathVariable(value ="id") Long id);

	@RequestMapping("/user/listUser")
	Map<String, Object> listUser();

	@PostMapping("/user/addUser")
	Map<String, Object> addUser(@RequestBody User user);

	@PutMapping("/user/updateUser")
	Map<String, Object> updateUser(@RequestBody User user);

	@DeleteMapping("/user/deleteUser/{id}")
	Map<String, Object> deleteUser(@PathVariable(value ="id") Long id);

}
