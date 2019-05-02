package com.cto51.dto;

import java.io.Serializable;

public class PayDto implements Serializable {

	private static final long serialVersionUID = 935073745912359286L;
	
	private Integer id;
	
	private String name;
	
	private String payCard;
	
	private Float momey;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPayCard() {
		return payCard;
	}

	public void setPayCard(String payCard) {
		this.payCard = payCard;
	}

	public Float getMomey() {
		return momey;
	}

	public void setMomey(Float momey) {
		this.momey = momey;
	}

}
