package sc.provider.logback.service;

import java.util.List;

import sc.provider.logback.model.User;

public interface UserService {

	User getUser(Long id);

	List<User> listUser();

	int addUser(User user);

	int updateUser(User user);

	int deleteUser(Long id);

}
