package com.cto51.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.cto51.dto.UserDto;

@Mapper
public interface UserDao {

	@Insert(value = "INSERT INTO t_user (name, nick_name, photo, mobile_no, email, birthday, gender_id) VALUES"
			+ "(#{name,jdbcType=VARCHAR},#{nickName,jdbcType=VARCHAR},#{photo,jdbcType=VARCHAR},"
			+ "#{mobileNo,jdbcType=VARCHAR},#{email,jdbcType=VARCHAR}, #{birthday,jdbcType=TIMESTAMP},"
			+ "#{genderId,jdbcType=INTEGER})")
	int save(UserDto user);

	@Update(value = "UPDATE t_user SET name = #{name,jdbcType=VARCHAR},nick_name = #{nickName,jdbcType=VARCHAR},"
			+ " photo = #{photo,jdbcType=VARCHAR}, mobile_no = #{mobileNo,jdbcType=VARCHAR}, "
			+ "email = #{email,jdbcType=VARCHAR}, birthday = #{birthday,jdbcType=TIMESTAMP}"
			+ ", gender_id=#{genderId,jdbcType=INTEGER} WHERE "
			+ " id = #{id,jdbcType=INTEGER}")
	int update(UserDto user);

	@Delete(value = "DELETE FROM t_user where id =#{id,jdbcType=INTEGER}")
	int delete(Integer id);

	@Select(value = "SELECT id, name, nick_name nickName, photo, mobile_no mobileNo, email, birthday FROM t_user ")
	List<UserDto> findAll();

	@Select(value = "SELECT id, name, nick_name nickName, photo, mobile_no mobileNo,"
			+ " email, birthday FROM t_user WHERE id=#{id,jdbcType=INTEGER}")
	UserDto getUser(Integer id);
	
	
	@Select(value = "SELECT id, name, nick_name nickName, photo, mobile_no mobileNo, email, birthday FROM t_user ")
	@Results( id="rsMapper", value={
			@Result(column="id", property="id"),
			@Result(column="name", property="name"),
			@Result(column="nick_name", property="nickName"),
			@Result(column="photo", property="photo"),
			@Result(column="mobile_no", property="mobileNo"),
			@Result(column="email", property="email"),
			@Result(column="birthday", property="birthday")
	})
	List<UserDto> findAllRs();
	
	@Select(value = "SELECT id, name, nick_name, photo, mobile_no,"
			+ " email, birthday FROM t_user WHERE id=#{id,jdbcType=INTEGER}")
	@ResultMap(value="rsMapper")
	UserDto getUserRs(Integer id);
	
	@Select({"select * from t_user"})
	@Results(value={
			@Result(column="id", property="id"),
			@Result(column="name", property="name"),
			@Result(column="nick_name", property="nickName"),
			@Result(column="photo", property="photo"),
			@Result(column="mobile_no", property="mobileNo"),
			@Result(column="email", property="email"),
			@Result(column="birthday", property="birthday"),
			@Result(column="gender_id", property="genderDto", 
			one=@One(select="com.cto51.dao.GenderDao.getGenderByID"))
	})
	List<UserDto> getAllUserWithClass();
	
	@Select({"select * from t_user"})
	@Results(value={
		@Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
		@Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
		@Result(column="nick_name", property="nickName"),
		@Result(column="photo", property="photo"),
		@Result(column="mobile_no", property="mobileNo"),
		@Result(column="email", property="email"),
		@Result(column="birthday", property="birthday"),
		@Result(column="id", property="grades", javaType=List.class,
        many=@Many(select="com.cto51.dao.GradeDao.getByStudentId"))
	})
	List<UserDto> getAllUserAndGrade();

}
