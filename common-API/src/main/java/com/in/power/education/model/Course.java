package com.in.power.education.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.rest.core.annotation.Description;

@Entity
public class Course extends AbstractEntity implements Serializable  {

	@Description(value="Course Name")
	private String cNm;
	
	@Description(value="Course Description")
	private String cDesc;
	
	@Description(value="Base Price for Subject")
	private Float basePrice;
	
//	@Description("Course to Subject mapping")
//	@OneToMany(mappedBy="course", cascade=CascadeType.ALL, orphanRemoval = true)
//	private Set<Subject> subject; 
	
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