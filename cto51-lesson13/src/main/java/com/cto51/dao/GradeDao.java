package com.cto51.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cto51.dto.GradeDto;

@Mapper
public interface GradeDao {

	@Select(value = "SELECT id, course, grade, user_id userId FROM t_grade WHERE user_id=#{id,jdbcType=INTEGER}")
	public GradeDto getByStudentId(Integer userId);
}
