package com.cto51.dao;

import java.util.List;

import com.cto51.dto.PayDto;

public interface PayDao {

	int save(PayDto payDto);

	int update(PayDto payDto);

	int delete(Integer id);

	List<PayDto> findAll();

	PayDto getPay(Integer id);

}
