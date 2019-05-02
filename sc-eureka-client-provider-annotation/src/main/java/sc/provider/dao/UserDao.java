package sc.provider.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import sc.provider.model.User;

@Mapper
public interface UserDao {

	@Select(value="select id, userName, age, position from t_user where id = #{id,jdbcType=INTEGER}")
	User getUser(Long id);

	@Select(value="select id, userName, age, position from t_user")
	List<User> listUser();

	@Insert(value="insert into t_user (id, userName, age, position) values ( #{id,jdbcType=INTEGER},#{userName,jdbcType=VARCHAR},#{age,jdbcType=INTEGER},#{position,jdbcType=VARCHAR})")
	int addUser(User user);

	@Update(value="update t_user set userName = #{userName,jdbcType=VARCHAR},age = #{age,jdbcType=INTEGER},position = #{position,jdbcType=VARCHAR} where id = #{id,jdbcType=INTEGER}")
	int updateUser(User user);

	@Delete(value=" delete from t_user where id = #{id,jdbcType=INTEGER}")
	int deleteUser(Long id);

}
