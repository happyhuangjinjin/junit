package com.cto51.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cto51.dao.UserDao;
import com.cto51.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public UserDto getUser(Integer id) {
		String sql = "SELECT id, name, nick_name nickName, photo, mobile_no mobileNo, email, birthday FROM t_user WHERE id=?";
		return jdbcTemplate.queryForObject(sql,  new Object[] {id}, new BeanPropertyRowMapper<UserDto>(UserDto.class));
	}

	@Override
	public int save(UserDto user) {
		String sql = "INSERT INTO t_user(name, nick_name, photo, mobile_no, email, birthday) values(?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, user.getName(), user.getNickName(), user.getPhoto(), user.getMobileNo(),
				user.getEmail(), user.getBirthday());
	}

	@Override
	public int update(UserDto user) {
		String sql = "UPDATE t_user SET name = ?, nick_name = ?, photo = ?, mobile_no = ?, email = ?, birthday = ? WHERE id = ?";
		return jdbcTemplate.update(sql, user.getName(), user.getNickName(), user.getPhoto(), user.getMobileNo(),
				user.getEmail(), user.getBirthday(), user.getId());
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM t_user where id = ?";
		return  jdbcTemplate.update(sql,id);
	}

	@Override
	public List<UserDto> findAll() {
		String sql = "SELECT id, name, nick_name nickName, photo, mobile_no mobileNo, email, birthday FROM t_user";
		return jdbcTemplate.query(sql, new RowMapper<UserDto>(){
			@Override
			public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserDto user = new UserDto();
				user.setName(rs.getString("name"));
				user.setNickName(rs.getString("nickName"));
				user.setPhoto(rs.getString("photo"));
				user.setMobileNo(rs.getString("photo"));
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getTime("birthday"));
				return user;
			}
			
		});
	}

}
