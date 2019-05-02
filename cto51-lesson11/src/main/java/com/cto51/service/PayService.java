package com.cto51.service;

import java.util.List;

import com.cto51.dto.PayDto;


public interface PayService {

	Boolean doPay(PayDto fromUser, PayDto toUser);

	int save(PayDto payDto);
	
	int delete(Integer id);

	List<PayDto> findAll();

	PayDto getPay(Integer id);
}
