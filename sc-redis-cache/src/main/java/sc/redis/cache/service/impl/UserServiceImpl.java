package sc.redis.cache.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import sc.redis.cache.dao.UserDao;
import sc.redis.cache.model.User;
import sc.redis.cache.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Cacheable(cacheNames = "user", key = "#id")
	@Override
	public User getUser(Long id) {
		return userDao.getUser(id);
	}

	@Cacheable(cacheNames = "user", key = "user:list")
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

	@CacheEvict(cacheNames = "user", key = "#id")
	@Override
	public int deleteUser(Long id) {
		return userDao.deleteUser(id);
	}
	
	

}
