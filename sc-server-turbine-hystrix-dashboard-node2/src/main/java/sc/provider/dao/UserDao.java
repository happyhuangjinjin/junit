package sc.provider.dao;

import java.util.List;

import sc.provider.model.User;

public interface UserDao {

	User getUser(Long id);

	List<User> listUser();

	int addUser(User user);

	int updateUser(User user);

	int deleteUser(Long id);

}
