package com.cto51.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 商品销售明细列表
 */
public class SaleDetail implements Serializable {

	private static final long serialVersionUID = 2713333962726369832L;
	
	// 销售单号
	private String seriNo;
	
	// 销售日期
	private Date date;
	
	// 销售明细
	private List<Product> productList;
	
	//折扣
	private Float discount = 1.0f;
		
	public SaleDetail(String seriNo, Date date) {
		this.seriNo = seriNo;
		this.date = date;
		this.productList = new ArrayList<Product>();
	}
	
	//获取星期几在一个星期里的偏移量
	public int getDayOfWeek() {
		Calendar c = Calendar.getInstance();
		c.setTime(this.date);
		int dow = c.get(Calendar.DAY_OF_WEEK);
		return dow;
	}
	
	// 返回该销售单的总金额（优惠前）
	public Float getTotal() {
		Float total = 0.0f;
		for (Product p : this.productList) {
			Float itemTotal = p.getPrice() * p.getAmount();
			total = total + itemTotal;
		}
		return total;
	}
	
	// 返回优惠后的总金额
	public Float getDiscountTotal() {
		Float total = getTotal();
		total = total * this.discount;
		return total;
	}
	
	public void setDiscount(Float dicsount) {
		this.discount = dicsount;
	}
	
	public Float getDiscount() {
		return this.discount;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public String getSeriNo() {
		return seriNo;
	}

	public void setSeriNo(String seriNo) {
		this.seriNo = seriNo;
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public void addProduct(Product product) {
		this.productList.add(product);
	}
}
