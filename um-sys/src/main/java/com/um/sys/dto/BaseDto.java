package com.um.sys.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class BaseDto implements Serializable{
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final long serialVersionUID = 6746928195674261913L;

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
