package com.in.power.education.model;

import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Blob;

import javax.persistence.Entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.rest.core.annotation.Description;

@Entity
public class Topic extends AbstractEntity implements Serializable  {

//	1. courseID
	@Description(value="Topic Name")
	private String tNm;
	
	@Description(value="Topic Description")
	private String tDesc;
	
	@Description(value="Base Price for Subject")
	private Float basePrice;
	
	public Topic() {
	}
	
	public Topic(String tNm,String tDesc,Float basePrice){
		this.tNm = tNm;
		this.tDesc = tDesc;
		this.basePrice = basePrice;
	}
	
	public String gettNm() {
		return tNm;
	}

	public void settNm(String tNm) {
		this.tNm = tNm;
	}

	public String gettDesc() {
		return tDesc;
	}

	public void settDesc(String tDesc) {
		this.tDesc = tDesc;
	}

	public Float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Float basePrice) {
		this.basePrice = basePrice;
	}
}