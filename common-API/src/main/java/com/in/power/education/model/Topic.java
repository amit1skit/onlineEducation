package com.in.power.education.model;

import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Blob;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@Description(value="Subject Information")
	private Subject subject;
	
	@Description("Topic to Question mapping")
	@OneToMany(mappedBy="topic", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Question> question;
	
	public Topic() {
	}
	
	public Topic(String tNm,String tDesc,Float basePrice, Subject subject){
		this.tNm = tNm;
		this.tDesc = tDesc;
		this.basePrice = basePrice;
		this.subject = subject;
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
}