package sc.provider.config.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sc.provider.config.dao.UserDao;
import sc.provider.config.model.User;
import sc.provider.config.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(Long id) {
		return userDao.getUser(id);
	}

	@Override
	public List<User> listUser() {
		return userDao.listUser();
	}

	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public int deleteUser(Long id) {
		return userDao.deleteUser(id);
	}

}
