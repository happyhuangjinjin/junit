package com.cto51.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cto51.dao.PayDao;
import com.cto51.dto.PayDto;
import com.cto51.service.PayService;

@Service
public class PayServiceImpl implements PayService {

	@Autowired
	private PayDao payDao;

	@Transactional
	@Override
	public Boolean doPay(PayDto fromUser, PayDto toUser) {
		payDao.update(fromUser);
		float temp = 10 / 0;
		payDao.update(toUser);
		return Boolean.TRUE;
	}

	@Override
	public int save(PayDto payDto){
		return payDao.save(payDto);
	}

	@Override
	public int delete(Integer id) {
		return payDao.delete(id);
	}

	@Override
	public List<PayDto> findAll() {
		return payDao.findAll();
	}

	@Override
	public PayDto getPay(Integer id) {
		return payDao.getPay(id);
	}
	
}
