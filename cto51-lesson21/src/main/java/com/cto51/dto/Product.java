package com.cto51.dto;

import java.io.Serializable;

/**
 * 商品
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 1266876575661487154L;

	//商品名称
	private String goodsName;
	
	//商品单价
	private Float price;
	
	//商品数量
	private Integer amount;

	public Product(String goodsName, Float price, Integer amount) {
		this.goodsName = goodsName;
		this.price = price;
		this.amount = amount;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
