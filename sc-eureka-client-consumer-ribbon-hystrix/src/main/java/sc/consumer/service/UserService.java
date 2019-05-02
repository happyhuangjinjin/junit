package sc.consumer.service;

import java.util.Map;

import sc.consumer.model.User;

public interface UserService {

	Map<String, Object> getUser(Long id);

	Map<String, Object> listUser();

	Map<String, Object> addUser(User user);

	Map<String, Object> updateUser(User user);

	Map<String, Object> deleteUser(Long id);

}
