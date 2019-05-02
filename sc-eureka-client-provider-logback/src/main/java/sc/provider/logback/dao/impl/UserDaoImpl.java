package sc.provider.logback.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sc.provider.logback.dao.UserDao;
import sc.provider.logback.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private  SqlSession sqlSession;
	
	@Override
	public User getUser(Long id) {
		return sqlSession.selectOne("getUser", id);
	}

	@Override
	public List<User> listUser() {
		return sqlSession.selectList("listUser");
	}

	@Override
	public int addUser(User user) {
		return sqlSession.insert("addUser", user);
	}

	@Override
	public int updateUser(User user) {
		return sqlSession.update("updateUser", user);
	}

	@Override
	public int deleteUser(Long id) {
		return sqlSession.delete("deleteUser", id);
	}

	
}
