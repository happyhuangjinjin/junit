package com.cto51.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cto51.dao.PayDao;
import com.cto51.dto.PayDto;

@Repository
public class PayDaoImpl implements PayDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public PayDto getPay(Integer id) {
		String sql = "SELECT id, name, pay_card, momey FROM t_pay WHERE id=?";
		return jdbcTemplate.queryForObject(sql,  new Object[] {id}, new BeanPropertyRowMapper<PayDto>(PayDto.class));
	}

	@Override
	public int save(PayDto payDto) {
		String sql = "INSERT INTO t_pay(name, pay_card, momey) values(?, ?, ?)";
		return jdbcTemplate.update(sql, payDto.getName(), payDto.getPayCard(), payDto.getMomey());
	}

	@Override
	public int update(PayDto payDto) {
		String sql = "UPDATE t_pay SET name = ?, pay_card = ?, momey = ? WHERE id = ?";
		return jdbcTemplate.update(sql, payDto.getName(), payDto.getPayCard(), payDto.getMomey(), payDto.getId());
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM t_pay where id = ?";
		return  jdbcTemplate.update(sql,id);
	}

	@Override
	public List<PayDto> findAll() {
		String sql = "SELECT id, name, pay_card payCard, momey FROM t_pay";
		return jdbcTemplate.query(sql, new RowMapper<PayDto>(){
			@Override
			public PayDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				PayDto payDto = new PayDto();
				payDto.setId(rs.getInt("id"));
				payDto.setName(rs.getString("name"));
				payDto.setPayCard(rs.getString("payCard"));
				payDto.setMomey(rs.getFloat("momey"));
				return payDto;
			}
			
		});
	}

}
