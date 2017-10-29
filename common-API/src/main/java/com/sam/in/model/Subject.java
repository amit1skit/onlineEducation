package com.sam.in.model;

import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Blob;

import javax.persistence.Entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.rest.core.annotation.Description;

@Entity
public class Subject extends AbstractEntity implements Serializable  {

//	1. courseID
	@Description(value="Subject Name")
	private String subjectName;
	
	@Description(value="Subject Description")
	private String subjectDesc;
	
	@Description(value="Class of Subject")
	private String clas;
	
	@Description(value="Base Price for Subject")
	private Float basePrice;
	
	public Subject() {
	}
	
	public Subject(String subjectName,String subjectDesc,String clas,Float basePrice){
		this.subjectName = subjectName;
		this.subjectDesc = subjectDesc;
		this.clas =clas;
		this.basePrice = basePrice;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectDesc() {
		return subjectDesc;
	}

	public void setSubjectDesc(String subjectDesc) {
		this.subjectDesc = subjectDesc;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public Float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Float basePrice) {
		this.basePrice = basePrice;
	}
}