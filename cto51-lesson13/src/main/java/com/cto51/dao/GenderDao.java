package com.cto51.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cto51.dto.GenderDto;

@Mapper
public interface GenderDao {

	@Select("select id, gender_name genderName from t_gender where id=#{id}")
	public GenderDto getGenderByID(int id);
}
