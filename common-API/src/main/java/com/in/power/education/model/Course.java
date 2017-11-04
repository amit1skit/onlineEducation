package com.in.power.education.model;

import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Blob;

import javax.persistence.Entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.rest.core.annotation.Description;

@Entity
public class Course extends AbstractEntity implements Serializable  {

	@Description(value="Course Name")
	private String cNm;
	
	@Description(value="Course Description")
	private String cDesc;
	
	@Description(value="Base Price for Subject")
	private Float basePrice;
	
	public Course() {
	}
	
	public Course(String cNm,String cDesc,Float basePrice){
		this.cNm = cNm;
		this.cDesc = cDesc;
		this.basePrice = basePrice;
	}
	public String getcNm() {
		return cNm;
	}

	public void setcNm(String cNm) {
		this.cNm = cNm;
	}

	public String getcDesc() {
		return cDesc;
	}

	public void setcDesc(String cDesc) {
		this.cDesc = cDesc;
	}

	public Float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Float basePrice) {
		this.basePrice = basePrice;
	}
}